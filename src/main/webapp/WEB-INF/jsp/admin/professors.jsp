<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CY School Manager</title>

	<link href="${pageContext.request.contextPath}/assets/global/global.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/layouts/admin_left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/pages/admin/users/users.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/button/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/header/header.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/left_sidebar/left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/users_table/users_table.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="layout">
	<%@ include file='/assets/components/admin/left_sidebar/left_sidebar.jsp' %>

	<main class="container">
		<jsp:include page='/assets/components/admin/header/header.jsp'/>

		<div class="inner-container">
			<main class="users-main">
				<h1>Professeurs</h1>
				<table class="users-table">
					<tr>
						<th>Email</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Cours</th>
					</tr>
					<c:forEach items="${professors}" var="professor">
						<tr>
							<td>
								<a href=""><div class="item">${professor.email}</div></a>
							</td>
							<td>
								<a href=""><div class="item">${professor.lastName}</div></a>
							</td>
							<td>
								<a href=""><div class="item">${professor.firstName}</div></a>
							</td>
							<td>
								<a href="">
									<div class="item">
										<c:choose>
											<c:when test="${not empty professor.courses}">
												<c:forEach items="${professor.courses}" var="course" varStatus="status">
													${course.className}
													<c:if test="${!status.last}">, </c:if>
												</c:forEach>
											</c:when>
											<c:otherwise>
												Aucun cours assigné
											</c:otherwise>
										</c:choose>
									</div>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</main>
		</div>
	</main>
</div>
</body>
</html>