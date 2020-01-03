<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<!-- 쿼리 스트링 지정해주기, MemberController로 보내기 -->
<a href="<%=root%>/user?act=mvjoin">회원가입</a>
<a href="<%=root%>/user?act=mvlogin">로그인</a>
</div>
</body>
</html>