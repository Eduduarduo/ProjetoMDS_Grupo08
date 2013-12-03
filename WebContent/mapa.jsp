<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="CSS/styleConteudo.css" type="text/css"/>
<style type="text/css">
	.active { display:inherit; }
	ul#map {display: block; margin: 0; padding: 0; width: 296px; height: 294px; background-image: url('images/img/mapa.jpg');}
	ul#map li {display: block; padding: 0; position: absolute;}
	li#crs {margin-top: 243px; margin-left: 125px;}
	li#csc {margin-top: 236px; margin-left: 148px;}
	li#cpr {margin-top: 209px; margin-left: 143px;}
	li#csp {margin-top: 190px; margin-left: 158px; z-index:9999; }
	li#cms {margin-top: 169px; margin-left: 118px;}
	li#crj {margin-top: 201px; margin-left: 210px; z-index:9999; }
	li#ces {margin-top: 181px; margin-left: 231px; z-index:9999; }
	li#cmg {margin-top: 152px; margin-left: 169px; z-index:9998; }
	li#cgo {margin-top: 132px; margin-left: 154px; z-index:9999; }
	li#cdf {margin-top: 162px; margin-left: 186px; z-index:9999; }
	li#cba {margin-top: 98px; margin-left: 197px;}
	li#cmt {margin-top: 98px; margin-left: 95px;}
	li#cro {margin-top: 100px; margin-left: 57px; z-index:9998; }
	li#cac {margin-top: 99px; margin-left: 1px;}
	li#cam {margin-top: 24px; margin-left: 2px;}
	li#crr {margin-top: 1px; margin-left: 72px;}
	li#cpa {margin-top: 22px; margin-left: 114px;}
	li#cap {margin-top: 11px; margin-left: 146px;}
	li#cma {margin-top: 53px; margin-left: 191px; z-index:9999;}
	li#cto {margin-top: 83px; margin-left: 175px;}
	li#cse {margin-top: 122px; margin-left: 266px;}
	li#cal {margin-top: 116px; margin-left: 267px;}
	li#cpe {margin-top: 102px; margin-left: 245px;}
	li#cpb {margin-top: 96px; margin-left: 265px;}
	li#crn {margin-top: 85px; margin-left: 265px;}
	li#cce {margin-top: 68px; margin-left: 245px;}
	li#cpi {margin-top: 67px; margin-left: 209px; z-index:9997;}

	ul#map li a {display: block; text-decoration: none; position: absolute;}
	a#rs {width: 50px; height: 49px; }
	a#sc {width: 35px; height: 24px; }
	a#pr {width: 43px; height: 31px; }
	a#sp {width: 55px; height: 41px; }
	a#ms {width: 51px; height: 52px; }
	a#rj {width: 28px; height: 16px; }
	a#es {width: 18px; height: 24px; }
	a#mg {width: 79px; height: 63px; }
	a#go {width: 53px; height: 55px; }
	a#df {width: 10px; height: 5px; }
	a#ba {width: 74px; height: 95px; }
	a#mt {width: 84px; height: 76px; }
	a#ro {width: 49px; height: 44px; }
	a#ac {width: 55px; height: 27px; }
	a#am {width: 130px; height: 91px;}
	a#rr {width: 43px; height: 49px; }
	a#pa {width: 96px; height: 94px; }
	a#ap {width: 38px; height: 41px; }
	a#ma {width: 51px; height: 68px; }
	a#to {width: 34px; height: 62px; }
	a#se {width: 13px; height: 15px; }
	a#al {width: 21px; height: 12px; }
	a#pe {width: 48px; height: 19px; }
	a#pb {width: 29px; height: 16px; }
	a#rn {width: 27px; height: 16px; }
	a#ce {width: 29px; height: 39px; }
	a#pi {width: 41px; height: 59px; }

	a#rs:hover, a#rs:active {background-image: url('images/img/mapa/rs.png');}
	a#sc:hover, a#sc:active {background-image: url('images/img/mapa/sc.png');}
	a#pr:hover, a#pr:active {background-image: url('images/img/mapa/pr.png');}
	a#sp:hover, a#sp:active {background-image: url('images/img/mapa/sp.gif');}
	a#ms:hover, a#ms:active {background-image: url('images/img/mapa/ms.gif');}
	a#rj:hover, a#rj:active {background-image: url('images/img/mapa/rj.gif');}
	a#es:hover, a#es:active {background-image: url('images/img/mapa/es.gif');}
	a#mg:hover, a#mg:active {background-image: url('images/img/mapa/mg.gif');}
	a#go:hover, a#go:active {background-image: url('images/img/mapa/go.gif');}
	a#df:hover, a#df:active {background-image: url('images/img/mapa/df.gif');}
	a#ba:hover, a#ba:active {background-image: url('images/img/mapa/ba.gif');}
	a#mt:hover, a#mt:active {background-image: url('images/img/mapa/mt.gif');}
	a#ro:hover, a#ro:active {background-image: url('images/img/mapa/ro.gif');}
	a#ac:hover, a#ac:active {background-image: url('images/img/mapa/ac.gif');}
	a#am:hover, a#am:active {background-image: url('images/img/mapa/am.gif');}
	a#rr:hover, a#rr:active {background-image: url('images/img/mapa/rr.gif');}
	a#pa:hover, a#pa:active {background-image: url('images/img/mapa/pa.gif');}
	a#ap:hover, a#ap:active {background-image: url('images/img/mapa/ap.gif');}
	a#ma:hover, a#ma:active {background-image: url('images/img/mapa/ma.gif');}
	a#to:hover, a#to:active {background-image: url('images/img/mapa/to.gif');}
	a#se:hover, a#se:active {background-image: url('images/img/mapa/se.gif');}
	a#al:hover, a#al:active {background-image: url('images/img/mapa/al.gif');}
	a#pe:hover, a#pe:active {background-image: url('images/img/mapa/pe.gif');}
	a#pb:hover, a#pb:active {background-image: url('images/img/mapa/pb.gif');}
	a#rn:hover, a#rn:active {background-image: url('images/img/mapa/rn.gif');}
	a#ce:hover, a#ce:active {background-image: url('images/img/mapa/ce.gif');}
	a#pi:hover, a#pi:active {background-image: url('images/img/mapa/pi.gif');}

	ul#map li a img {border: 0; width: inherit; height: inherit;}

#mapa {
		float:left;
		margin-top:50px;
		
		}

</style>

</head>
<body>
<div id="mapa">
    <ul id="map">
        <li id="crs" estado="rs"><a href="buscaUf?pg=simples" id="rs" title="RS"><img src="images/img/null.gif" alt="RS" /></a></li>
        <li id="csc" estado="sc"><a href="buscaUf?pg=simples" id="sc" title="SC"><img src="images/img/null.gif" alt="SC" /></a></li>
        <li id="cpr" estado="pr"><a href="buscaUf?pg=simples" id="pr" title="PR"><img src="images/img/null.gif" alt="PR" /></a></li>
        <li id="csp" estado="sp"><a href="buscaUf?pg=simples" id="sp" title="SP"><img src="images/img/null.gif" alt="SP" /></a></li>
        <li id="cms" estado="ms"><a href="buscaUf?pg=simples" id="ms" title="MS"><img src="images/img/null.gif" alt="MS" /></a></li>
        <li id="crj" estado="rj"><a href="buscaUf?pg=simples" id="rj" title="RJ"><img src="images/img/null.gif" alt="RJ" /></a></li>
        <li id="ces" estado="es"><a href="buscaUf?pg=simples" id="es" title="ES"><img src="images/img/null.gif" alt="ES" /></a></li>
        <li id="cmg" estado="mg"><a href="buscaUf?pg=simples" id="mg" title="MG"><img src="images/img/null.gif" alt="MG" /></a></li>
        <li id="cgo" estado="go"><a href="buscaUf?pg=simples" id="go" title="GO"><img src="images/img/null.gif" alt="GO" /></a></li>
        <li id="cdf" estado="df"><a href="buscaUf?pg=simples" id="df" title="DF"><img src="images/img/null.gif" alt="DF" /></a></li>
        <li id="cba" estado="ba"><a href="buscaUf?pg=simples" id="ba" title="BA"><img src="images/img/null.gif" alt="BA" /></a></li>
        <li id="cmt" estado="mt"><a href="buscaUf?pg=simples" id="mt" title="MT"><img src="images/img/null.gif" alt="MT" /></a></li>
        <li id="cro" estado="ro"><a href="buscaUf?pg=simples" id="ro" title="RO"><img src="images/img/null.gif" alt="RO" /></a></li>
        <li id="cac" estado="ac"><a href="buscaUf?pg=simples" id="ac" title="AC"><img src="images/img/null.gif" alt="AC" /></a></li>
        <li id="cam" estado="am"><a href="buscaUf?pg=simples" id="am" title="AM"><img src="images/img/null.gif" alt="AM" /></a></li>
        <li id="crr" estado="rr"><a href="buscaUf?pg=simples" id="rr" title="RR"><img src="images/img/null.gif" alt="RR" /></a></li>
        <li id="cpa" estado="pa"><a href="buscaUf?pg=simples" id="pa" title="PA"><img src="images/img/null.gif" alt="PA" /></a></li>
        <li id="cap" estado="ap"><a href="buscaUf?pg=simples" id="ap" title="AP"><img src="images/img/null.gif" alt="AP" /></a></li>
        <li id="cma" estado="ma"><a href="buscaUf?pg=simples" id="ma" title="MA"><img src="images/img/null.gif" alt="MA" /></a></li>
        <li id="cto" estado="to"><a href="buscaUf?pg=simples" id="to" title="TO"><img src="images/img/null.gif" alt="TO" /></a></li>
        <li id="cse" estado="se"><a href="buscaUf?pg=simples" id="se" title="SE"><img src="images/img/null.gif" alt="SE" /></a></li>
        <li id="cal" estado="al"><a href="buscaUf?pg=simples" id="al" title="AL"><img src="images/img/null.gif" alt="AL" /></a></li>
        <li id="cpe" estado="pe"><a href="buscaUf?pg=simples" id="pe" title="PE"><img src="images/img/null.gif" alt="PE" /></a></li>
        <li id="cpb" estado="pb"><a href="buscaUf?pg=simples" id="pb" title="PB"><img src="images/img/null.gif" alt="PB" /></a></li>
        <li id="crn" estado="rn"><a href="buscaUf?pg=simples" id="rn" title="RN"><img src="images/img/null.gif" alt="RN" /></a></li>
        <li id="cce" estado="ce"><a href="buscaUf?pg=simples" id="ce" title="CE"><img src="images/img/null.gif" alt="CE" /></a></li>
        <li id="cpi" estado="pi"><a href="buscaUf?pg=simples" id="pi" title="PI"><img src="images/img/null.gif" alt="PI" /></a></li>
    </ul>
    </div>
<br>
<br>
<br><br>
<div  class="texto">
<h2>Você sabe aonde seu lixo vai parar?</h2>
<br>
<h2>E o lixo produzido pelo seu estado?</h2>
<h3>
<br><br>
E o lixo produzido pelo seu estado?<br>
Os dados absolutos e relativos do descarte de lixo no Brasil dos últimos<br> 20 anos estão 
disponibiliza-los livremente pelo IBGE. Para ajudá-lo a melhor entender<br> esses dados,
este site permite que vc pesquise e melhor visualize a a destinação<br> do lixo domiciliar brasileiro.<br>
</h3> 
</div>


   



</body>
</html>