<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> <s:text name="title" /> </title>
</head>
<body>
	<h3> <s:text name="title" /> </h3>
	
	<s:form action="processSignUp" validate="true">
		<s:textfield id="userNameTxt"  name="userName" label="%{getText('userName')}" />
		<s:textfield name="userEmail" label="%{getText('userEmail')}" />
		<s:password cssClass="pass"  name="userPassword" label="%{getText('userPassword')}"/>
		<s:password name="userConfirmPass" label="%{getText('userConfirmPass')}"/>
			
		<s:combobox list="countries" id="userCountryCmb" name="userCountryId" label="Pais" />	
		
		<s:submit value="%{getText('ok')}" />
	</s:form>
	
	
	
	<!-- jquery -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	
	<script 
	 	type="text/javascript" 
	 	src="<s:url value='/resources/js/signUp.js'/>"></script>	
</body>
</html>







