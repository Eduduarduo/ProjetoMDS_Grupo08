<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="JS/jquery.featureCarousel.min.js" type="text/javascript" ></script>
<script src="JS/caroussel.js" type="text/javascript"></script>
<script src="JS/slider.js" type="text/javascript"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			serie = {
				dataM1 : [],
				dataM2 : [],
			}
			generateChart4(serie);
		});
		function changeSerie(f) {
			$.ajax({
				url : f.action,
				type : 'POST',
				dataType : 'json',
				data : {
					regiao1 : $('#regiao1').val(),
					regiao2 : $('#regiao2').val(),
					ano : $('#ano').val(),
				},
				success : function(dados) {
					console.debug(dados);
					serie.year1 = [];
					serie.year2 = [];
					serie.dataM1 = [];
					serie.dataM2 = [];
					serie.tipos=[];
					serie.regiao=dados[0].regiao;
					for (var i = 0; i < dados.length; i++) {
						if (serie.regiao==dados[i].regiao) {
							console.debug(dados[i]);
							serie.year1.push(dados[i].regiao);
							serie.dataM1.push(dados[i].valor);
						}else{
							console.debug(dados[i]);
							serie.year2.push(dados[i].regiao);
							serie.dataM2.push(dados[i].valor);		
						}
						serie.tipos.push(dados[i].opcao);
					}
					if(serie.year2.length ==0){
						alert("Não é possivel fazer a comparação na mesmo regiao");
					}else{
						generateChart4(serie);
					}
				}
			});
		}
</script>
<script type="text/javascript" src="JS/plotarGraficoDuplo2.js"></script>
</head>
<body>

	<jsp:include page="quadro.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	
		<br>
		<br>

<div class="conteudo">
	<br>
	<br>
	<p>Selecione as regiões e informe um ano para que possamos comparará-las.</p>
	<div style="font-weight: bold; margin: 5px auto;">
	<form id="frm" action="buscaRegiao?cmd=comparacaoRegiao" method="post">
		Ano: 
		<select name="ano" id="ano">
			<c:forEach var="list" items="${listaDatas}">
				<option value="${list.ano}">${list.ano}</option>
			</c:forEach>
		</select> 
		Regiões:
		<select name="regiao1" id="regiao1">
				<c:forEach var ="list" items="${listaRegioes}" >
					<option value="${list.regiao}">${list.regiao}</option>
				</c:forEach>
		</select>
		<select name="regiao2" id="regiao2">
				<c:forEach var ="list" items="${listaRegioes}" >
					<option value="${list.regiao}">${list.regiao}</option>
				</c:forEach>
		</select>
				
		<input type="button" onclick="changeSerie(this.form);" value="comparar" />
	</form>
	<br>
	<div class="boxTagClouds" id="boxTagClouds">
		<div id="containerDLD4"
			style="width: 680px; height: 420px; margin: 0 auto"></div>
	</div>
	<script src="JS/highcharts.js"></script>
	<script src="JS/modules/exporting.js"></script>
	</div>
</div> 

</body>
</html>