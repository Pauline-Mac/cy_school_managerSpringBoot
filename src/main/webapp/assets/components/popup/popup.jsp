<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html; charset=UTF-8" />

<div class="popup-container
    <c:choose>
        <c:when test="${sessionScope.error != null}">
            popup-container-error
        </c:when>
        <c:otherwise>
            popup-container-success
        </c:otherwise>
    </c:choose>">
    <p class="popup-text">
        <c:choose>
            <c:when test="${sessionScope.error != null}">
                ${sessionScope.error}
            </c:when>
            <c:otherwise>
                ${sessionScope.success}
            </c:otherwise>
        </c:choose>
    </p>
</div>

<%
    session.removeAttribute("error");
    session.removeAttribute("success");
%>
