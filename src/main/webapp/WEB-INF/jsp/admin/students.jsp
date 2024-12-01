<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CY School Manager</title>

	<link href="${pageContext.request.contextPath}/assets/global/global.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/layouts/admin_left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/pages/student/student.css" rel="stylesheet" type="text/css">
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
				<h1>Etudiants</h1>
				<table class="users-table">
					<tr>
						<th>Email</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>
							Classe
						</th>
					</tr>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>
								<a href=""><div class="item">${student.email}</div></a>
							</td>
							<td>
								<a href=""><div class="item">${student.lastName}</div></a>
							</td>
							<td>
								<a href=""><div class="item">${student.firstName}</div></a>
							</td>
							<td>
								<a href="">
									<div class="item">
										<c:choose>
											<c:when test="${student.studentGroup != null}">
												${student.studentGroup.studentGroupName}
											</c:when>
											<c:otherwise>
												Aucune classe assignée
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