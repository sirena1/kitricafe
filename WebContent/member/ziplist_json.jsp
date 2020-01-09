<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kitri.member.model.ZipCodeDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{ "ziplist" : [
<c:if test="${ziplist != null }">
	<c:forEach var="zipCodeDto" varStatus="i" items="${ziplist }">
		{"zipcode" : "${zipCodeDto.zipcode}", "address" : "${zipCodeDto.address}"}
 			<c:if test="${i.index != ziplist.size() - 1}">
 			,
 			</c:if>
 	</c:forEach>
 </c:if>
 			 ]
}
    