<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%@ include file="/template/top.jsp" %>
<c:if test="${userInfo != null }">
<br><a href="${root}/user?act=logout">로그아웃</a>
<br>
<font size="15" color="darkgray">${userInfo.name}(${userInfo.id})님 메일 목록입니다.</font><br>
10. 안녕하세요1.<br>
9. 안녕하세요2.<br>
8. 안녕하세요3.<br>
</c:if>
<c:if test="${userInfo == null }">
<script>
alert("로그인 후 서비스를 이용할 수 있습니다.");
$(location).attr("href", "${root}/user?act=mvlogin");
</script>
</c:if>
<%@ include file="/template/bottom.jsp" %>