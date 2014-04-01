<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
</head>
<body>
	<h3>SignUp</h3>

	<s:form action="processSignUp">
		<s:textfield name="userName" label="Nombre" />
		<s:textfield name="userEmail" label="Email" />
		<s:password name="userPassword" label="Password"/>
		<s:password name="userConfirmPass" label="Confirm Pass"/>
		
		<s:submit value="Aceptar" />
	</s:form>
</body>
</html>