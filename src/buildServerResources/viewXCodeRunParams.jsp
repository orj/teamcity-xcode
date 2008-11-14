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
