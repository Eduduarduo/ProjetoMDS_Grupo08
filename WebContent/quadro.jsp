<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div id="sliderFrame">
        <div id="slider">
            <a href="coletaSeletiva.jsp">
                <img src="images/lixeiras.jpg" alt="Participe dessa ideia"/></a>
            
            <a href="descarteCorreto.jsp" title="Como voce pode contribuir"> 
            <img  src="images/descarte-correto.jpg"></a>
            
            
            <a href="empresasVerdes.jsp"><img  src ="images/empresa-verde.jpg"></a>
            <a class="lazyImage" href="images/simbolo-reciclagem.png" title=""></a>
       
        </div>
 
        <div id="thumbs">
            <div class="thumb">
                <div class="frame"><img src="images/lixeiras.jpg" /></div>
                <div class="thumb-content"><p><a href="coletaSeletiva.jsp" >Coleta Seletiva</a></p>Por que no Brasil não existe coleta Seletiva?</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/descarte-correto.jpg" /></div>
                <div class="thumb-content"><p><a href="descarteCorreto.jsp">Descarte Correto</a></p><a href="descarteCorreto.jsp">Onde posso descartar meu lixo eletrônico?</a></div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/empresa-verde.jpg" /></div>
                <div class="thumb-content"><p><a href="empresasVerdes.jsp">Empresas Verdes</a></p><a href="empresasVerdes.jsp">Existem Empresas Verdes? </a></div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/simbolo-reciclagem.png" /></div>
                <div class="thumb-content"><p><a href="pensamentoVerde.jsp"> Pensamento Verde</a> </p><a href="pensamentoVerde.jsp"> Por que a coleta seletiva deve ser implementada?</a> </div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <!--clear above float:left elements. It is required if above #slider is styled as float:left. -->
        <div style="clear:both;height:0;"></div>
    </div>
</body>
</html>