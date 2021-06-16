<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>${pageName} Employees</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container col-xs-4">
		<h2>Employee Report ${pageName}</h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>salary</th>
					<th>state</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="model" items="${employees}">
					<tr>
						<td>${model.id}</td>
						<td>${model.salary}</td>
						<td>${model.state}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
