<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="title" /></title>
</head>
<body>
	<h3>
		<s:text name="title" />
	</h3>
	<s:form action="processSignIn">
		<s:textfield name="userEmail" label="%{getText('userEmail')}" />
		<s:password name="userPassword" label="%{getText('userPassword')}" />

		<s:submit value="%{getText('ok')}" />
	</s:form>
</body>
</html>