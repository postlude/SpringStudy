<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <form:form method="post" action="validTest/result">
		<form:input path="name"/>
		<form:errors path="name"/>
	</form:form> --%>
	
	<form action="/spring_14_2_ex1_srpingex/validTest/result" method="post">
		<input type="text" name="name"/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>