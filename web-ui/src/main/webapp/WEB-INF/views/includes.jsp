<%@ taglib prefix="c"			uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"			uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring"		uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"		uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt"			uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"			uri="http://www.springframework.org/security/tags" %>

<c:set var="shortDateFormat">dd/MM/yyyy</c:set>
<c:set var="longDateFormat">dd/MM/yyyy HH:mm</c:set>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<c:set var="jQueryDir" value="design/javascript/jquery"/>

<% pageContext.setAttribute("newLine", "\n"); %> 