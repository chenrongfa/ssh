<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="emp-updateById">
		<s:hidden name="id" value="%{#request.findById.id}"></s:hidden>
		<s:textfield name="lastName" label="姓名"
			value="%{#request.findById.lastName}"></s:textfield>
		<s:textfield name="birthTime" label="生日"
			value="%{#request.findById.birthTime}"></s:textfield>
		<s:textfield name="email" label="邮箱"
			value="%{#request.findById.email}"></s:textfield>
		<s:select name="depart.id" label="部门" list="#request.findAll"
		listKey="id" listValue="department"
		></s:select>
		<s:submit></s:submit>


	</s:form>
</body>
</html>