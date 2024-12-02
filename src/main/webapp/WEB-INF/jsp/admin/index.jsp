<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html; charset=UTF-8" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CY School Manager</title>

	<link href="${pageContext.request.contextPath}/assets/global/global.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/layouts/admin_left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/pages/admin/index/index.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/button/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/header/header.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/left_sidebar/left_sidebar.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="layout">
	<%@ include file='/assets/components/admin/left_sidebar/left_sidebar.jsp' %>

	<main class="container">
		<jsp:include page='/assets/components/admin/header/header.jsp'/>
		<div class="inner-container">


			<c:choose>
				<c:when test="${sessionScope.error != null || sessionScope.success != null}">
					<div class="popup-container ${sessionScope.error != null ? 'popup-container-error' : 'popup-container-success'}">
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
				</c:when>
			</c:choose>

			<main class="index-main">
				<h1>Bienvenu(e) ${user.firstName} !</h1>
				<img class="img_1" alt="CY TECH" src="https://cytech.cyu.fr/medias/photo/20210910-142739-1-_1658393597514-jpg?ID_FICHE=111566">
			</main>
		</div>
	</main>
</div>

<%
	// Suppression des attributs session après utilisation
	session.removeAttribute("error");
	session.removeAttribute("success");
%>
</body>
</html>
