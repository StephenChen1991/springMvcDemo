<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>列表</div>
	<div>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Age</th>
				<th>ComingTime</th>
				<th>MaxScore</th>
				<th>MinScore</th>
			</tr>
			<tr>
				<c:forEach items="${findAllList}" var="s">
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.comingtime}</td>
					<td>${s.maxscore}</td>
					<td>${s.minscore}</td>
				</c:forEach>
			</tr>
		</table>
	</div>

</body>
</html>