<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Destinação do Lixo Domiciliar</title>
<link rel="stylesheet"  href="CSS/styleMenu.css" type="text/css"/>
<link rel="stylesheet"  href="CSS/styleMapa.css" type="text/css"/>
<link rel="stylesheet"  href="CSS/styleConteudo.css" type="text/css"/>
<link rel="stylesheet" href="CSS/styleCarousel.css"/>
<link href="CSS/styleSlider.css" rel="stylesheet" type="text/css" />
<script src="JS/jquery-1.7.min.js" type="text/javascript"></script>
<script src="JS/jquery.featureCarousel.min.js" type="text/javascript" ></script>
<script src="JS/caroussel.js" type="text/javascript"></script>
<script src="JS/slider.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="quadro.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<div class="conteudo">

<form action="buscaBrasil?cmd=Comparacao" method="post"> 
<br><br><br>
<select name="ano1">
<c:forEach var ="list" items="${listaDatas}" >
<option value="${list.ano}">${list.ano}</option>
</c:forEach>
</select>
<br>
<br><br>
<input  type="submit"  value="Pesquisar"  /> 
   </form>

<br>

<c:forEach var ="b"  items="${listaBrasilAbsolutoAno1}" >
REGIÃO  :  ${b.regiao}  ;
VALOR   :  ${b.valor}  ;
OPÇÃO   :  ${b.opcao} ;
ANO   :   ${b.ano}  ;
<br>		
	
</c:forEach>
<br>

<c:forEach var ="b"  items="${listaBrasilRelativoAno1}" >
REGIÃO  :  ${b.regiao}  ;
VALOR   :  ${b.valor}  ;
OPÇÃO   :  ${b.opcao} ;
ANO   :   ${b.ano}  ;
<br>
</c:forEach>
<br>

</div>
<jsp:include page="carrousel.jsp"></jsp:include>
</body>
</html>