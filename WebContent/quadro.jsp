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
            <a href="http://www.menucool.com/jquery-slider" target="_blank">
                <img src="images/image-slider-1.jpg" alt="Welcome to jQuery Slider" />
            </a>
            <a class="lazyImage" href="images/image-slider-2.jpg" title="Como voce pode contribuir">Pure JavaScript</a>
            <a href="http://www.menucool.com/javascript-image-slider"><img  src ="images/image-slider-3.jpg">Image Slider</a>
            <a class="lazyImage" href="images/image-slider-4.jpg" title="">Slide 4</a>
        </div>
 
        <div id="thumbs">
            <div class="thumb">
                <div class="frame"><img src="images/thumb1.jpg" /></div>
                <div class="thumb-content"><p>Coleta Seletiva</p>Veja como pequenas açoes podem ajudar</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/thumb2.jpg" /></div>
                <div class="thumb-content"><p>Descarte</p>Qual a importância do descarte correto?</div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/thumb3.jpg" /></div>
                <div class="thumb-content"><p>Empresas Verdes</p>Iniciativas que dão lucro com lixo </div>
                <div style="clear:both;"></div>
            </div>
            <div class="thumb">
                <div class="frame"><img src="images/thumb4.jpg" /></div>
                <div class="thumb-content"><p>Pensamento Verde</p>Lorem ipson</div>
                <div style="clear:both;"></div>
            </div>
        </div>
        <!--clear above float:left elements. It is required if above #slider is styled as float:left. -->
        <div style="clear:both;height:0;"></div>
    </div>




</body>
</html>