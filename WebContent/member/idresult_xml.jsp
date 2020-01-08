<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) request.getAttribute("searchid");
String cnt = (String) request.getAttribute("idcount");
%>

<idresult>
	<sid><%=id%></sid>
	<idcnt><%=cnt%></idcnt>
</idresult>