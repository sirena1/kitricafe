<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kitri.member.model.ZipCodeDto"%>
<%
List<ZipCodeDto> list = (List<ZipCodeDto>) request.getAttribute("ziplist");
%>
{ "ziplist" : [
<%
if(list != null){
	int len = list.size();
	for(int i=0;i<len;i++) {
		ZipCodeDto zipCodeDto = list.get(i);
%>		
{"zipcode" : "<%=zipCodeDto.getZipcode()%>", "address" : "<%=zipCodeDto.getAddress()%>"}
 <%
 		if(i != len -1) /* 마지막에 , 붙이지 않기 */
 			out.print(",");
	}
}
 %>
 			 ]
}
    