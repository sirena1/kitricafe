<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDetailDto"%>
<%@ include file="/template/top.jsp" %>
<%
MemberDetailDto memberDetailDto = (MemberDetailDto) request.getAttribute("registerInfo");
if(memberDetailDto != null) {
%>
<font size="15" color="steelblue"><%=memberDetailDto.getName()%>(<%=memberDetailDto.getId()%>)님 회원 가입을 축하합니다.</font><br>
로그인 후 서비스를 이용할 수 있습니다.<br>
<a href="<%=root%>/user?act=mvlogin">로그인</a>
<%
} else {
%>
<script>
alert("정상적인 접근이 아닙니다.");
location.href = "<%=root%>/user";
</script>
<%	
}
%>
<%@ include file="/template/bottom.jsp" %>