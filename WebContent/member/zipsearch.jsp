<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
$(document).ready(function() {
	$("#searchBtn").click(function() {
		var doro = $("#doro").val();
		if(doro.length != 0){
			$.ajax({
				//에러 무시해도 괜찮음--> 정상작동 된다...
				url : '${root}/user', /*controller */
				type : 'GET',
				data : {act : 'zipsearch', sdoro : doro}, 
				dataType : 'json',
				success : function(data) { //jason 
					/* alert(data.ziplist[0].zipcode);
					alert(data.ziplist[0].address); */
					var zlist = data.ziplist;
					var len = zlist.length;
					var list = ''; 
					for(var i=0;i<len;i++){	
					list +=	'<tr>';
					list +=		'<td>' + zlist[i].zipcode + '</td>'
					list += 	'<td><a href="#" onclick="zipput(\''+ zlist[i].zipcode + '\',\'' + zlist[i].address + '\');">';
					list += zlist[i].address + '</a></td>'
					list += '</tr>';
					}
					//html로 list를 집어넣어라
					$("#zipcodeView").html(list);
				}
			});
		}
	});
});

function zipput(zipcode, address){
	//내용 지우기
	$("#zipcodeView").empty();
	$("#doro").val('');
	//모달창 default는 show <-> hide
	$("#zipModal").modal('hide');
	//클릭한 값을 입력하기
	$("#zipcode").val(zipcode);
	$("#address").val(address);
	
}

</script>	
	
<div id="zipModal" class="modal fade" role="dialog">
	<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body text-center">

				<div align="center">
					<label>도로명 주소검색</label>
				</div>
				<div class="input-group" align="left">
					<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)"> 
					<span class="input-group-btn"> 
					<input class="btn btn-warning" value="검색" id="searchBtn">
					</span>
				</div>

				<div style="width: 100%; height: 200px; overflow: auto">
					<table class="table text-center">
						<thead>
							<tr>
								<th style="width: 150px;">우편번호</th>
								<th style="width: 600px;">주소</th>
							</tr>
						</thead>
						<tbody id="zipcodeView"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>