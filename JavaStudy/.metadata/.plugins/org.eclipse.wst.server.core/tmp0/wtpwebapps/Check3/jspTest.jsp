<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div>
  <%@ include file="header.jsp"%>
</div>
<!-- name、idの入力エリアを作成しなさい -->
<table border="0">
<tr>
  <th>name</th>
  <td><input type="text"></td>
</tr>
<tr>
  <th>id</th>
  <td><input type="text"></td>
</tr>
</table>
<div>
  <%@ include file="footer.jsp"%>
</div>  
</body>
</html>