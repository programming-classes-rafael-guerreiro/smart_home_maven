<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>SmartHome - Sign Up</title>

		<link href="<c:url value='/css/style.css' />" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>

		<form action="<c:url value='/sign-in' />" method="POST">
			<label>
				E-mail
				<input type="text" name="email" maxlength="255" value="${email}" />
			</label>
			<label>
				Password
				<input type="password" name="password" />
			</label>
			<button type="submit">Submit</button>
		</form>
	</body>
</html>