<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.springmap.MapVO"%>
<%@ page import="java.util.*"%>
<%
	ArrayList<MapVO> mapList = (ArrayList<MapVO>) request.getAttribute("mapList");
	double latSum = 0;
	double lngSum = 0;

	for(int i=0; i<mapList.size(); i++){
		latSum += mapList.get(i).getLat();
		lngSum +=mapList.get(i).getLng();
	}
	
	double latAvg = latSum/mapList.size();
	double lngAvg = lngSum/mapList.size();

%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <title>Marker Clustering</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      
      #map{
      height: 80%;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>  
      function initMap() {
    	var markers = new Array();
		var pre_infors = new Array();
    	var inforWindows = new Array();
    	var siteLines = new Array();
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: {lat: <%=latAvg%>, lng: <%=lngAvg%>}
        });

<%
     	for(int i=0; i<mapList.size(); i++){
%>	
			markers[<%=i%>] = new google.maps.Marker({
		   	 	position: new google.maps.LatLng(<%=mapList.get(i).getLat() %>, <%=mapList.get(i).getLng() %>),
		   	 	label : '<%=mapList.get(i).getName() %>',
		   		title : '<%=mapList.get(i).getName() %>',
		   		map: map
			});
			
			inforWindows[<%=i%>] = new google.maps.InfoWindow({
					content: '<div id="<%=mapList.get(i).getName() %>" class="carousel slide" data-ride="carousel"><ol class="carousel-indicators">'
					+ '<li data-target="#<%=mapList.get(i).getName() %>" data-slide-to="0" class="active"></li> <li data-target="#myCarousel" data-slide-to="1"></li>'
					+ '<li data-target="#<%=mapList.get(i).getName() %>" data-slide-to="2"></li></ol><div class="carousel-inner">'
					+ '<div class="item active"><img src="/altaltal/image/site/<%=mapList.get(i).getPicture1()%>" width="400" height="400" /></div>'
					+ '<div class="item"><img src="/altaltal/image/site/<%=mapList.get(i).getPicture2()%>" width="400" height="400" /></div>'
					+ '<div class="item"><img src="/altaltal/image/site/<%=mapList.get(i).getPicture3()%>" width="400" height="400" /></div></div>'
					+ '<a class="left carousel-control" href="#<%=mapList.get(i).getName() %>" data-slide="prev">'
					+ '<span class="glyphicon glyphicon-chevron-left"></span><span class="sr-only">Previous</span></a>'
					+ '<a class="right carousel-control" href="#<%=mapList.get(i).getName() %>" data-slide="next">'
					+ '<span class="glyphicon glyphicon-chevron-right"></span><span class="sr-only">Next</span></a></div>'
			});
     		  
			pre_infors[<%=i%>] = true;
			
			markers[<%=i%>].addListener('click', function(){
				if(pre_infors[<%=i%>]){
					inforWindows[<%=i%>].open(map, this); 
					pre_infors[<%=i%>] = false;
				}else{
					inforWindows[<%=i%>].close(map, this); 
					pre_infors[<%=i%>] = true;
				}
			});
			
			siteLines[<%=i%>] = {lat: <%=mapList.get(i).getLat() %>, lng: <%=mapList.get(i).getLng() %>};
			
			
			
     		 <%
     	}
     		 %>
     	var flightPath = new google.maps.Polyline({
		          path: siteLines,
		          geodesic: true,
		          strokeColor: '#FF0000',
		          strokeOpacity: 1.0,
		          strokeWeight: 2
		        });

		        flightPath.setMap(map);
/*         
        google.maps.event.addListener(infowindow1, 'domready', function() {
		    var l = document.getElementById('b1');
		    l.addEventListener('click', function(){
		    	window.open("https://www.google.co.kr/maps/dir//동대문문화역사공원", "target");
		    })
		}); 	 */	

    } 
     
    </script>
    <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXLWZuztJOAvb2wZpL7ebcXaxHv65paaA&callback=initMap">
    </script>
  </body>
</html>