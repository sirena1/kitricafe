<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
   $("#loginBtn").click(function() {
      if($("#id").val() == "") {
         alert("아이디 입력!!!");
         return;
      } else if($("#pass").val() == "") {
         alert("비밀번호 입력!!!");
         return;
      } else {
         $("#loginform").attr("action", "<%=root%>/login/login_process.jsp").submit();
      }
   });
   
   $("#moveRegisterBtn").click(function() {
      $(location).attr("href", "<%=root%>/member/member.jsp");
   });
});
</script>

   <div class="col-lg-6" align="center">
      <h2>로그인</h2>
      <form id="loginform" method="post" action="">
         <div class="form-group" align="left">
            <label for="">아이디</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="">
         </div>
         <div class="form-group" align="left">
            <label for="">비밀번호</label>
            <input type="password" class="form-control" id="pass" name="pass" placeholder="">
         </div>
         <div class="form-group" align="center">
            <button type="button" class="btn btn-warning" id="loginBtn">로그인</button>
            <button type="button" class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
         </div>
      </form>
   </div>

<%@ include file="/template/bottom.jsp" %>