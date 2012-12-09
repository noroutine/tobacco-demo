package me.noroutine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import me.noroutine.cache.IfNoneMatch;
import me.noroutine.util.ReloadableMessageSource;
import me.noroutine.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Oleksii Khilkevych
 * @since 02.12.12
 */

@Controller
public class ResourcesController {

    private static final Logger log = LoggerFactory.getLogger(ResourcesController.class);

    @Autowired
    @Qualifier("messageSource")
    private ReloadableMessageSource messageSource;

    @Autowired
    @Qualifier("applicationMessageSource")
    private ReloadableMessageSource applicationMessageSource;

    private static final String VALUE = "$";

    private final ConcurrentMap<Locale, ObjectNode> resourcesMap = new ConcurrentHashMap<Locale, ObjectNode>();

    @PostConstruct
    private void prepareResources() {
        for (Locale locale: Arrays.asList(Locale.getDefault(), Locale.ENGLISH, Locale.GERMAN, Locale.GERMANY)) {
            resourcesMap.putIfAbsent(locale, prepareLocalizedResources(locale));
        }
    }
    private ObjectNode prepareLocalizedResources(Locale locale) {
        ObjectNode resources = JsonNodeFactory.instance.objectNode();
        ObjectNode resourcesTree = JsonNodeFactory.instance.objectNode();
        resources.put("$tree", resourcesTree);

        Iterable<Map.Entry<Object, Object>> entries = Utils.IterableIterator.from(
                messageSource.getProperties(locale).entrySet(),
                applicationMessageSource.getProperties(locale).entrySet()
        );

        for (Map.Entry<Object, Object> entry: entries) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();

            String[] keyParts = key.split("\\.");

            // go down the object properties
            ObjectNode node = resourcesTree;
            for (String keyPart : keyParts) {
                JsonNode child = node.get(keyPart);
                ObjectNode childObject;

                if (child == null) {
                    childObject = JsonNodeFactory.instance.objectNode();
                    node.put(keyPart, childObject);
                } else {
                    childObject = (ObjectNode) child;
                }

                node = childObject;
            }

            node.put(VALUE, value);
            resources.put(key, value);
        }
        return resources;
    }

    @RequestMapping("/resources.js")
    @ResponseBody
    @IfNoneMatch
    public JSONPObject getResources(Locale locale) {
        ObjectNode localizedResources = resourcesMap.get(locale);
        if (localizedResources == null) {
            log.info("Creating locale resources for {}, consider doing this on initialization", locale);
            resourcesMap.putIfAbsent(locale, prepareLocalizedResources(locale));
        }
        return new JSONPObject("R.registerResources", resourcesMap.get(locale));
    }
}
