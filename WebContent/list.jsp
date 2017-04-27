<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $(".delete").click(function(){
		 
		  $e=$(this);
		var username= $(this).parent().parent().children("td").eq(1).html();
		var flag=confirm("你确定要删除"+username);
		if(flag){
			var url=this.href;
			
			$.post(url ,function(data){
				if(data==1){
					var html=$e.parent().parent().remove();
					alert("已经删除"+html);
				}else{
					alert("删除失败"+data);
				}				
			});
			
		}
		 return false;
	 });
	 
 });

</script>
</head>
<body>
	<table border="1" cellspacing="0">
	<caption>所有人员信息</caption>
		<tr>
			<td>id</td>
			<td>lastName</td>
			<td>birth</td>
			<td>email</td>
			<td>creatTime</td>
			<td>depart</td>
		</tr>
		<s:iterator value="#request.findAll">
		<tr>
			<td>${id}</td>
			<td>${lastName}</td>
			<td>${birthTime}</td>
			<td>${email}</td>
			<td>${createTime}</td>
			<td>${depart.department}</td>
			<td><a href="emp-delete?id=${id}" class="delete">删除</a></td>
			<td><a href="emp-update?id=${id}">更改</a></td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>