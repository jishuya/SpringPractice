<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert result</title>
</head>
<body>
	
	<script type="text/javascript">
		window.alert("${result}");
		location.href = "/chap4Controller/";
	</script>
</body>
</html>