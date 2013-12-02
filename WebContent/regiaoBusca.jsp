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
<script src="JS/jquery.featureCarousel.min.js" type="text/javascript" ></script>
<script src="JS/caroussel.js" type="text/javascript"></script>
<script src="JS/slider.js" type="text/javascript"></script>
<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			serie = {
				dataM : [],
			}
			generateChart(serie);
			generateChart2(serie);
		});
	</script>
		<script type="text/javascript">
		function changeSerie(f) {
			$.ajax({
				url : f.action,
				type : 'POST',
				dataType : 'json',
				data : {
					ano : $('#ano').val(),
					regiao : $('#regiao').val(),
				},
				success : function(dados) {
					console.debug(dados);
					serie.dataM = [];
					serie.dataM2 = [];
					serie.dataG = [];
					serie.dataG2 = [];
					serie.size=dados.length;
					for (var i = 0; i < dados.length; i++) {
						if (dados[i].tipo == "Relativo") {
							console.debug(dados[i]);
							serie.dataG.push(dados[i].valor);
							serie.dataG2.push(dados[i].opcao);
						} else {
							console.debug(dados[i]);
							serie.year = dados[i].ano;
							serie.dataM.push(dados[i].valor);
							serie.dataM2.push(dados[i].opcao);
						}
					}
					generateChart(serie);
					generateChart2(serie);
				}
			});
		}
	</script>
	
	<script type="text/javascript" src="JS/plotarGraficoDePizza.js"></script>

	<script type="text/javascript" src="JS/plotarGraficoDeBarras.js"></script>	
		
</head>
<body>

	<jsp:include page="quadro.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	
		<br>
		<br>

<div class="conteudo">
<br><br>
		<p>Selecione um ano  e a regiao.</p> 
		<div style="font-weight: bold; margin: 5px auto;">
		<form action="buscaRegiao?cmd=busca" method="post" id="form" name="form"> 
			<select name="ano" id="ano">
				<c:forEach var ="list" items="${listaDatas}" >
					<option value="${list.ano}">${list.ano}</option>
				</c:forEach>
			</select>
			<select name="regiao" id="regiao">
				<c:forEach var ="list" items="${listaRegioes}" >
					<option value="${list.regiao}">${list.regiao}</option>
				</c:forEach>
			</select>
			
			<input type="button" onclick="changeSerie(this.form);" value="Pesquisar" />
   		</form>
		
		</div>
		<br>
						<div class="boxTagClouds" id="boxTagClouds">

					<div id="containerDLD"
						style="width: 480px; height: 420px; margin: 0 auto"></div>
				</div>

				<div class="boxTagClouds" id="boxTagClouds">

					<div id="containerDLD2"
						style="width: 480px; height: 420px; margin: 0 auto"></div>
				</div>

	<script src="JS/highcharts.js"></script>

	<script src="JS/modules/exporting.js"></script>
		
		
</div>
	
</body>
</html>