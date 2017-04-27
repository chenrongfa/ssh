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
	<s:form action="emp-add" method="post">
		<s:textfield label="姓名" name="lastName"></s:textfield>
		<s:textfield label="邮件" name="email"></s:textfield>
		<s:textfield label="生日" name="birthTime"></s:textfield>

		<s:select list="#request.findAll" listKey="id" listValue="department"
			label="选择部门" name="depart.id">
		</s:select>

		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>