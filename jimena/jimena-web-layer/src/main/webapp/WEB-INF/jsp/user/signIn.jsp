<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignIn</title>
</head>
<body>
	<h3>SignIn</h3>
	<s:form action="processSignIn">
		<s:textfield name="userEmail" label="Email" />
		<s:password name="userPassword" label="Password" />
		
		<s:submit value="Aceptar"/>
	</s:form>
</body>
</html>