 
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BrasilDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var ="b"  items="${listaRelativo}" >
REGIÃO  :  ${b.regiao}  ;
VALOR   :  ${b.valor}  ;
OPÇÃO   :  ${b.opcao} ;
ANO   :   ${b.ano}  ;
<br>		
	
</c:forEach>
<br>

<c:forEach var ="b"  items="${listaAbsoluto}" >
REGIÃO  :  ${b.regiao}  ;
VALOR   :  ${b.valor}  ;
OPÇÃO   :  ${b.opcao} ;
ANO   :   ${b.ano}  ;
<br>
</c:forEach>
<br>
<br>
<br>
<br>


</body>
</html>