
var chart2;

function generateChart2(serie){
	
if(serie.size==8){
		
		chart2 = new Highcharts.Chart({
			
			chart: {
				renderTo:'containerDLD2',
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: 'Dados relativos destino do lixo domiciliar '
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: false,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                },
	        			showInLegend: true
	        
	            }
	        },
	        series: [{
	        	renderTo:'containerDLD2',
	            type: 'pie',
	            name: 'Browser share',
	            data:[
	                [serie.dataG2[0],serie.dataG[0]],
	                [serie.dataG2[1],serie.dataG[1]],
	                [serie.dataG2[2],serie.dataG[2]],
	                [serie.dataG2[3],serie.dataG[3]]
	             
	            ]
	        }]
	    });
		
		
		
	}
	
	
	
	if(serie.size==10){
		
		chart2 = new Highcharts.Chart({
			
			chart: {
				renderTo:'containerDLD2',
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: 'Dados relativos destino do lixo domiciliar '
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: false,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                },
	        			showInLegend: true
	        
	            }
	        },
	        series: [{
	        	renderTo:'containerDLD2',
	            type: 'pie',
	            name: 'Browser share',
	            data:[
	                [serie.dataG2[0],serie.dataG[0]],
	                [serie.dataG2[1],serie.dataG[1]],
	                [serie.dataG2[2],serie.dataG[2]],
	                [serie.dataG2[3],serie.dataG[3]],
	                [serie.dataG2[4],serie.dataG[4]]
	               
	            ]
	        }]
	    });
		
		
		
	}
	
if(serie.size==12){
		
		chart2 = new Highcharts.Chart({
			
			chart: {
				renderTo:'containerDLD2',
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: 'Dados relativos destino do lixo domiciliar '
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: false,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                },
	        			showInLegend: true
	        
	            }
	        },
	        series: [{
	        	renderTo:'containerDLD2',
	            type: 'pie',
	            name: 'Browser share',
	            data:[
	                [serie.dataG2[0],serie.dataG[0]],
	                [serie.dataG2[1],serie.dataG[1]],
	                [serie.dataG2[2],serie.dataG[2]],
	                [serie.dataG2[3],serie.dataG[3]],
	                [serie.dataG2[4],serie.dataG[4]],
	                [serie.dataG2[5],serie.dataG[5]]
	            ]
	        }]
	    });
		
		
		
	}

if(serie.size==14){
	
	chart2 = new Highcharts.Chart({
		
		chart: {
			renderTo:'containerDLD2',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Dados relativos destino do lixo domiciliar '
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                },
        			showInLegend: true
        
            }
        },
        series: [{
        	renderTo:'containerDLD2',
            type: 'pie',
            name: 'Browser share',
            data:[
                [serie.dataG2[0],serie.dataG[0]],
                [serie.dataG2[1],serie.dataG[1]],
                [serie.dataG2[2],serie.dataG[2]],
                [serie.dataG2[3],serie.dataG[3]],
                [serie.dataG2[4],serie.dataG[4]],
                [serie.dataG2[5],serie.dataG[5]],
                [serie.dataG2[6],serie.dataG[6]]
            ]
        }]
    });
	
	
	
}

	

	
	
	
}
