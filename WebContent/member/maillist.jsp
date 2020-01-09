<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%@ include file="/template/top.jsp" %>
<%
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto != null) {
%>
<br><a href="${root}/user?act=logout">로그아웃</a>
<br>
<font size="15" color="darkgray"><%=memberDto.getName()%>(<%=memberDto.getId()%>)님 메일 목록입니다.</font><br>
10. 안녕하세요1.<br>
9. 안녕하세요2.<br>
8. 안녕하세요3.<br>
<%
} else {
%>
<script>
alert("로그인 후 서비스를 이용할 수 있습니다.");
$(location).attr("href", "${root}/user?act=mvlogin");
</script>
<%	
}
%>
<%@ include file="/template/bottom.jsp" %>