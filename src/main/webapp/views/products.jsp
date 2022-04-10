<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>
<% List<Product> products = (List<Product>)request.getAttribute("products"); %>
</body>

<table>
<thead>
<tr>
<td>Nome</td>
<td>Valor</td>
</tr>
</thead>
<tbody>
<tr>
<td>bla<td>
</tr>
</tbody>
</table>
</html>