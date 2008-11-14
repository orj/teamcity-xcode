<%--
 * Copyright (c) 2008 Oliver Jones.  All rights reserved.
--%>

<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<div class="parameter">
    XCode Project File:
    <strong><props:displayValue name="xcode.project" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    <c:set var="target" value="${propertiesBean.properties['xcode.target']}" />
    Target:
    <strong>
        <c:choose>
            <c:when test="${target == '_AllTargets'}">All Targets</c:when>
            <c:when test="${target == '_ActiveTarget'}">Active Target</c:when>
            <c:when test="${target == '_Target'}">
                <c:out value="${propertiesBean.properties['xcode.targetName']}" />
            </c:when>
            <c:otherwise>not specified</c:otherwise>
        </c:choose>
    </strong>
</div>
<div class="parameter">
    Parallelize Targets:
    <strong><props:displayValue name="xcode.parallelizeTargets" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    Configuration:
    <strong><props:displayValue name="xcode.configuration" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    Build Action(s): 
    <strong><props:displayValue name="xcode.buildAction" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    SDK:
    <strong><props:displayValue name="xcode.sdk" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    Build Settings:
    <strong><props:displayValue name="xcode.buildSettings" emptyValue="not specified"/></strong>
</div>
<div class="parameter">
    User Defaults:
    <strong><props:displayValue name="xcode.userDefaults" emptyValue="not specified"/></strong>
</div>
