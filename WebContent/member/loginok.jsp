<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/top.jsp" %>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
%>
<font size="15" color="steelblue"><%=name %>(<%=id%>)님 안녕하세요!!!!!!</font> <br>
<%@ include file="/template/bottom.jsp" %>