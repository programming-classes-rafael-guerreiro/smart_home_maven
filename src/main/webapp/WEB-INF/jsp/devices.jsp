<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>SmartHome - Devices</title>

		<link href="<c:url value='/css/style.css' />" rel="stylesheet" type="text/css" />

		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="https://momentjs.com/downloads/moment.min.js"></script>
	</head>
	<body>
		<c:forEach items="${users}" var="user">
			<p>${user.name} - <span data-date-of-last-log-in="${user.formattedLastSignIn}"></span></p>
		</c:forEach>

		<hr />

		<c:forEach items="${data}" var="userDevice">
			<p class="${userDevice.even ? 'even' : 'odd'}">${userDevice.formattedRow}</p>
		</c:forEach>
		
		<script type="text/javascript">
			$(function() {
				var $span = $("[data-date-of-last-log-in]");
				var date = $span.data("dateOfLastLogIn");

				var utc = moment(date);
				$span.text(utc);
			});
		</script>
	</body>
</html>