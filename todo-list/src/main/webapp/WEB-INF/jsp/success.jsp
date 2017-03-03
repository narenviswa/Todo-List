<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Todo List</title>
</head>
<body>
<h2>Todo for you</h2>
<table>
	<tr>
		<th>title</th>
		<th>description</th>
	</tr>
	<c:forEach items="${todolist}" var="todolist" varStatus="status">
		<tr>
			<td>${todolist.title}</td>
			<td>${todolist.description}</td>
		</tr>
	</c:forEach>
</table>	
</body>
</html>