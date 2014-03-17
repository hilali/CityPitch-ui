<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />


<title>Map View Canada !</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
		
		<style type="text/css">
		
			  .Fullscreen
			  {
			    position:absolute;
			    left: 0;
			    top: 0;
			    width: 100%;
			    height: 100%;
			    /* Optional - just for DIV)*/
			    border: solid 1px #000000;
			    background-color:grey;
			  }		
			#searchForm label.error, label.error {
				margin-left: 10px;
				width: auto;
				display: inline;
				color: red;
				font-style: italic;
				font-weight: normal;
			}
		      .gmap3{
		        margin: 20px auto;
		        border: 1px dashed #C0C0C0;
		        width: 500px;
		        height: 250px;
		      }		
		</style>
		
		<script type="text/javascript" charset="utf-8">
			var ctx = '${ctx}';
			var FOLDER_IMG = ctx+"/design/images/";
			var FOLDER_COMMON_IMG = ctx+"/design/images/common/";
		</script>
		<script type="text/javascript" src="${ctx}/${jQueryDir}/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="${ctx}/${jQueryDir}/jquery-ui-1.8.18.custom.min.js"></script>
		<script type="text/javascript" src="${ctx}/design/javascript/common.js"></script>
		

     
    <script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
    
    <script type="text/javascript" src="${ctx}/${jQueryDir}/gmap3.js"></script>	
	
		
		<script type="text/javascript" charset="utf-8">
			
			$(document).ready(function() {
				$("input:submit, input:button, button").button();
				
				 $('.Fullscreen').gmap3({
			    	 marker:{
			             values:[
									{latLng:[45.5,-73.6], data:"Montreal"},
									{latLng:[46.833,-71.250], data:"Quebec"},
									{latLng:[43.70,-79.417], data:"Toronto"},
									{latLng:[51.083,-114.083], data:"Calgary"},
									{latLng:[49.217,-123.10], data:"Vancouver"}		                     
			                   ]			    	    
			    	 },
			    	    map:{
			    	        options:{
			    	          center:[55,-90],
			    	          zoom: 5
			    	        }
			    	      }
			    	});				
			});		
		</script>
</head>
<body >
<div class="Fullscreen" id="test1"></div>
</body>
</html>


