<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="menu" align="center">
		<ul>
			<li><a href="index.jsp">Home</a></li>
            <li><a >Brasil</a>
            	<ul>
                	<li><a href="buscaBrasil?pg=simples">Pesquise</a></li>
                    <li><a href="buscaBrasil?pg=composto">Compare</a></li>
                </ul>
            </li>
            <li><a >Estados</a>
            	<ul>
                	<li><a href="buscaUf?pg=simples">Pesquise</a></li>
                    <li><a href="buscaUf?pg=ano">Compare Ano</a></li>
                    <li><a href="buscaUf?pg=uf">Compare estados</a></li>
            	</ul>
            </li>
            <li><a href="">Regiões Metropolitanas</a>
            	<ul>
                	<li><a href="buscaRegiao?pg=simples">Pesquise</a></li>
                	<li><a href="buscaRegiao?pg=ano">Compare Ano</a></li>
                	<li><a href="buscaRegiao?pg=regiao">Compare Regiao</a></li>
                    

           	</ul>
            </li>
		</ul>
	</div>

</body>
</html>