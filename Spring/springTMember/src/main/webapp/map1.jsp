<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
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

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: {lat: 37.580955, lng: 126.969939}
        });

       var markers = locations.map(function(location, i) {
          return new google.maps.Marker({
            position: location,
           	title: "통인시장"
          });
        });
      
     	 //ddp 37.566868 127.009458
        var content1 =  '<div>안녕하세요</div><img src="http://img.movist.com/?img=/x00/04/90/83_p1.jpg" />'
                + '<button id="b1">길찾기</button>';       	
        var content2 = '<div>통인시장입니다</div><img src="http://harpersbazaar.co.kr/wp-content/uploads/2018/01/bz201801_celeb_jenny_006-640x830.jpg" />';
        var content3 = '<div>익선동입니다</div><img src="http://img.movist.com/?img=/x00/04/90/83_p1.jpg" />';
     	var content4 ='<div>content4</div>';
        
        var infowindow1 = new google.maps.InfoWindow({
    		content: content1
    	});
        var infowindow2 = new google.maps.InfoWindow({
    		content: content2
    	});
        var infowindow3 = new google.maps.InfoWindow({
    		content: content3
    	});
        
        
        var infowindow4 = new google.maps.InfoWindow({
    		content: content4
    	});
        
        markers[0].addListener('click', function() {
    		infowindow1.open(map, markers[0]);
    	});
        markers[1].addListener('click', function() {
    		infowindow2.open(map, markers[1]);
    	});	
        markers[2].addListener('click', function() {
				infowindow3.open(map, markers[2]);
    	});
       
        	infowindow4.open(map, markers[0]);
    	
       
        
        google.maps.event.addListener(infowindow1, 'domready', function() {
		    var l = document.getElementById('b1');
		    l.addEventListener('click', function(){
		    	window.open("https://www.google.co.kr/maps/dir//동대문문화역사공원", "target");
		    })
		});		
        
       
    		
        
    			
       var markerCluster = new MarkerClusterer(map, markers,
     {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
      
    }
     
      var locations = [
          {lat: 37.566868, lng: 127.009458},  
          {lat: 37.580955, lng: 126.969939},
          {lat: 37.574453, lng: 126.989804}
        ]
    </script>
    <script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXLWZuztJOAvb2wZpL7ebcXaxHv65paaA&callback=initMap">
    </script>
  </body>
</html>