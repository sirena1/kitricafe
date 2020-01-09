<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto"%>
<%@ include file="/template/top.jsp"%>

<c:if test="${userInfo != null }">
<font size="15" color="steelblue">${userInfo.name}(${userInfo.id})님 안녕하세요.</font>
<br><a href="${root}/user?act=maillist">메일보기</a>
<br><a href="${root}/user?act=logout">로그아웃</a>
</c:if>
<c:if test="${userInfo == null }">
<script>
alert("로그인 후 서비스를 이용할 수 있습니다.");
$(location).attr("href", "${root}/user?act=mvlogin");
</script>
</c:if>
<%@ include file="/template/bottom.jsp"%>