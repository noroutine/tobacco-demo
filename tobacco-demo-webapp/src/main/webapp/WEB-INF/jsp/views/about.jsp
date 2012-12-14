<%--
 @author Oleksii Khilkevych
 @since 09.12.12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<h1>About Tobacco</h1>

<c:set value="<a href=\"http://tobacco.noroutine.me/\">Tobacco</a>" var="Tobacco" />
<p>
    ${Tobacco} is not a framework or library. It is Maven archetype or simply speaking project template. <br />
    It's aim is to make starting new project in Java simple and fast.
</p>
<p>
    This particular site is just a demonstration of what Tobacco project will look like.<br />
    Try this demo on mobile devices too.<br />
    You can also check the <a href="https://github.com/noroutine/tobacco-demo/blob/demo_1.0.2">sources of this site on GitHub</a>
</p>

<small class="muted">You can find source of this page in <a href="https://github.com/noroutine/tobacco-demo/blob/demo_1.0.2/tobacco-demo-webapp/src/main/webapp/WEB-INF/jsp/views/about.jsp"><code>about.jsp</code></a></small>
