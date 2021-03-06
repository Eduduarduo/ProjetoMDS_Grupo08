var chart;

function generateChart3(serie){

	
	
	chart = new Highcharts.Chart({
            chart: {
            	renderTo: 'containerDLD3',
                type: 'column'
            },
            title: {
                text: serie.title,
            },
            subtitle: {
                text: 'Dados Comparativos absolutos Destino do lixo Domiciliar'
            },
            xAxis: {
                categories: 
                	serie.tipos
            },
            yAxis: {
                min: 0,
                title: {
                    text: '	lixo em Toneladas (T)'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} T</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: serie.year1[1],
                data: serie.dataM1
    
            },{
            	name: serie.year2[1],
                data: serie.dataM2
            	
            }]
        });
 	
}

