<jsp:directive.page contentType="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CY School Manager</title>
	<link href="${pageContext.request.contextPath}/assets/global/global.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/layouts/admin_left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/button/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/header/header.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/admin/left_sidebar/left_sidebar.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/components/user_profile/user_profile.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
	<jsp:include page='/assets/components/admin/header/header.jsp'/>
	<%@ include file='/assets/components/admin/left_sidebar/left_sidebar.jsp' %>
	<div class="inner-container">
		<main>
			<jsp:directive.page contentType="text/html; charset=UTF-8" />
			<form class="user-profile" action="profile" method="POST">
				<div class="login-form-container">
					<h1 class="title">Mes coordonnées</h1>
					<br><br>
					<span>Email :</span>
					<input
							class="user-data-input"
							type="email"
							id="email"
							name="email"
							placeholder="Changer mon email"
							value=${user.email}
					>
					<br><br>
					<span>Mot de passe : </span>
					<input
							type="password"
							id="password"
							name="password"
							placeholder="Changer mon mot de passe"
					>
					<br><br>
					<span>Prénom :</span>
					<input
							type="text"
							id="name"
							name="name"
							placeholder="Changer mon prénom"
							value=${user.firstName}
					>
					<br><br>
					<span>Nom de famille : </span>
					<input
							type="text"
							id="family_name"
							name="family_name"
							placeholder="Changer mon nom de famille"
							value=${user.lastName}
					>
					<br><br>
					<span>Téléphone :</span>
					<input
							type="text"
							id="phone"
							name="phone"
							placeholder="Changer mon numéro mobile"
							value=${user.phone}
					>
					<br><br>
					<input class="button" type="submit" value="Mettre à jour">
				</div>
			</form>
		</main>
	</div>
</div>
</body>
</html>