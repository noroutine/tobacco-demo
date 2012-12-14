<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<util:dust path="/template/dustjs_demo" />

<util:js value="/resources/js/pages/demo.js" />

<h3>JSP EL Demo</h3>
<p>
    2 + 2 = ${2+2}
</p>

<h3>Form Demo</h3>
<div id="submit_demo">

<form class="form-horizontal" method="get">
    <c:if test="${empty a}"><c:set var="a" value="2" /></c:if>
    <c:if test="${empty b}"><c:set var="b" value="2" /></c:if>

    <input class="input-mini" type="text" name="a" value="${a}" /> + <input class="input-mini" type="text" name="b" value="${b}"/>
    <input type="submit" class="btn" value="Add" />
</form>
<p>
    <c:if test="${not empty result}">${a} + ${b} = ${result}</c:if>
   &nbsp;
</p>
</div>

<h3>Ajax Form Demo</h3>
<div id="ajax_demo">
    <div class="form-horizontal" style="margin-bottom: 20px">
        <input class="input-mini" type="text" name="a" value="2" /> + <input class="input-mini" type="text" name="b" value="2"/>
        <button class="btn" value="Add">Add</button>
    </div>
    <p>&nbsp;</p>
</div>

<h3>Dust.js Demo</h3>
<div id="dustjs_demo">

</div>

<p>
<small class="muted">
    <spring:url value="/template/dustjs_demo.dust" var="dustjs_demo_url" />
    <spring:url value="/api/add?a=1&b=2" var="ajax_api_demo_url" />
    <c:set var="github_sources" value="https://github.com/noroutine/tobacco-demo/blob/demo_1.0.2/tobacco-demo-webapp/src/main" />

    You can find source of this page in <a href="${github_sources}/webapp/WEB-INF/jsp/views/demo.jsp"><code>demo.jsp</code></a>
    JavaScript code can be found in <a href="${github_sources}/webapp/js/pages/demo.js"><code>demo.js</code></a>
    Source code for logic is in <a href="${github_sources}/java/me/noroutine/DemoController.java"><code>DemoController.java</code></a>.<br/>
    API endpoint for Ajax Demo can be tested <a href="${ajax_api_demo_url}">here</a>.<br/>
    dust.js template source code can be found in <a href="${github_sources}/webapp/WEB-INF/jsp/templates/dustjs_demo.jsp"><code>dustjs_demo.jsp</code></a>
    dust.js template can be checked at <a href="${dustjs_demo_url}">${dustjs_demo_url}</a>, compiled version is at <a href="${dustjs_demo_url}.js">${dustjs_demo_url}.js</a>
</small>
</p>
