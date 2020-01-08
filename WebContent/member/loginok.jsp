<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%@ include file="/template/top.jsp"%>
<%
	MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
	if (memberDto != null) {
%>
<font size="15" color="steelblue"><%=memberDto.getName()%>(<%=memberDto.getId()%>)님 안녕하세요.</font>
<br><a href="<%=root%>/user?act=maillist">메일보기</a>
<br><a href="<%=root%>/user?act=logout">로그아웃</a>
<%
	} else {
%>
<script>
alert("로그인 후 서비스를 이용할 수 있습니다.");
$(location).attr("href", "<%=root%>/user?act=mvlogin");
</script>
<%
}
%>
<%@ include file="/template/bottom.jsp"%>