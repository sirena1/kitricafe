<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	
	var isIdCheck = false;
	
	$("#registerBtn").click(function() {
		if($("#name").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#id").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#pass").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if($("#pass").val() != $("#passcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		} else if(!isIdCheck) {
			alert("아이디 중복검사를 하세요!!!");
			return; 
		}
		else {
			$("#memberform").attr("action", "<%=root%>/user").submit();
		}
	});
	
	$("#id").keyup(function () {
		var sid = $("#id").val();
		//console.log(sid);
		var sidlen = sid.length;
		if(sidlen < 6 || sidlen > 16){
			$("#idresult").css("color","gray").html("아이디는 6자리 이상 16자리 이하로 입력해주세요");
		} else {
			//서버랑 통신해야 하는 부분
			$.ajax({
			url : '<%=root%>/user', /*controller */
			type : 'GET',
			data : {act : 'idcheck', checkid : sid}, 
			dataType : 'json',
			success : function(data) { //json 
				var returnid = data.searchid; //
				var cnt = parseInt(data.idcnt);
				if(cnt == 0){
					isIdCheck = true;
					$("#idresult").css("color","skyblue").html("<strong>" + returnid + "</strong>는 사용할 수 있습니다.");
				} else {
					isIdCheck = false;
					$("#idresult").css("color","magenta").html("<strong>" + returnid + "</strong>는 사용할 수 없습니다.");
			
				}		
			},
			error : function() {
			}
		});
			
		}
	});
	 
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
});
</script>


<div class="col-lg-6" align="center">
	<h2>회원가입</h2>
	<form id="memberform" method="post" action="">
		<!-- 우리 눈에 보이지는 않지만 데이터를 넘겨야 하는 경우 hidden -->
		<input type="hidden" name="act" value="register">
		<div class="form-group" align="left">
			<label for="name">이름</label> <input type="text" class="form-control"
				id="name" name="name" placeholder="">
		</div>
		<div class="form-group" align="left">
			<label for="">아이디</label> <input type="text" class="form-control"
				id="id" name="id" placeholder="">
			<div id="idresult"></div>
		</div>
		<div class="form-group" align="left">
			<label for="">비밀번호</label> <input type="password"
				class="form-control" id="pass" name="pass" placeholder="">
		</div>
		<div class="form-group" align="left">
			<label for="">비밀번호재입력</label> <input type="password"
				class="form-control" id="passcheck" name="passcheck" placeholder="">
		</div>
		<div class="form-group" align="left">
			<label for="email">이메일</label><br>
			<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="emailid" name="emailid"
					placeholder="" size="25"> @ <select class="form-control"
					id="emaildomain" name="emaildomain">
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
			</div>
		</div>
		<div class="form-group" align="left">
			<label for="tel">전화번호</label>
			<div id="tel" class="custom-control-inline">
				<select class="form-control" id="tel1" name="tel1">
					<option value="010">010</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="041">041</option>
					<option value="051">051</option>
					<option value="061">061</option>
				</select> _ <input type="text" class="form-control" id="tel2" name="tel2"
					placeholder=""> _ <input type="text" class="form-control"
					id="tel3" name="tel3" placeholder="">
			</div>
		</div>
		<div class="form-group" align="left">
			<label for="">주소</label><br>
			<div id="addressdiv" class="custom-control-inline">
				<input type="text" class="form-control" id="zipcode" name="zipcode"
					placeholder="우편번호" size="7" maxlength="5" readonly="readonly">
				<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
			</div>
			<input type="text" class="form-control" id="address" name="address"
				placeholder="" readonly="readonly"> <input type="text" class="form-control"
				id="address_detail" name="address_detail" placeholder="">
		</div>
		<div class="form-group" align="center">
			<button type="button" class="btn btn-primary" id="registerBtn">회원가입</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</div>
	</form>
</div>

<%@ include file="/template/bottom.jsp"%>
<%@ include file="/member/zipsearch.jsp"%>