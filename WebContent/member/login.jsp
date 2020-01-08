<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="/template/top.jsp" %>
<%
Cookie cookie[] = request.getCookies();
String saveid = "";
String checkedid = "";
if(cookie != null) {
	int len = cookie.length;
	for(int i=0;i<len;i++){
		if(cookie[i].getName().equals("asid")){
			//아이디 저장 성공
			saveid = cookie[i].getValue();
			checkedid = " checked='checked'";
			break;
		}
	}
}
%>
<script type="text/javascript">
$(document).ready(function() {
	$("#loginBtn").click(function() {
		if($("#id").val() == '') {
			alert("아이디 입력!!!");
			return;
		} else if($("#pass").val() == '') {
			alert("비밀번호 입력!!!");
			return;
		} else {
			$("#loginform").attr("action", "<%=root%>/user").submit();
		}
	});
	
	$("#moveRegisterBtn").click(function() {
		$(location).attr("href", "<%=root%>/user?act=mvjoin");
	});
});
</script>

	<div class="col-lg-6" align="center">
		<h2>로그인</h2>
		<form id="loginform" method="post" action="">
			<input type="hidden" name="act" value="login">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" value="<%=saveid%>">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디저장</label>
				<input type="checkbox" id="idsave" name="idsave" value="saveok" <%=checkedid%>>
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" id="loginBtn">로그인</button>
				<button type="button" class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
			</div>
		</form>
	</div>

<%@ include file="/template/bottom.jsp" %>