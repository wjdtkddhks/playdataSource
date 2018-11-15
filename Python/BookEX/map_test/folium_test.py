import folium

map_osm = folium.Map(location=[37.566345, 126.977893])
map_osm.save('map1.html')

map_osm = folium.Map(location=[37.566345, 126.977893], zoom_start=17)
map_osm.save('map2.html')

# folium은 기본적으로 'Open Street Map'을 기반으로 동작, 내부적으로는
# 'Stamen Terrain', 'Stamen Toner', 'Mapbox Bright', 'Mapbox Control room tiles' 형식을 가짐
map_osm = folium.Map(location=[37.566345, 126.977893], zoom_start=17, tiles="Stamen Terrain")
map_osm.save('map3.html')

map_osm = folium.Map(location=[37.566345, 126.977893], zoom_start=17)
folium.Marker([37.566345, 126.977893], popup='서울시청').add_to(map_osm)
folium.Marker([37.5658859, 126.9754788], popup='창덕궁').add_to(map_osm)
map_osm.save('map4.html')

map_osm = folium.Map(location=[37.566345, 126.977893], zoom_start=17)
folium.Marker([37.566345, 126.977893], popup='서울시청', icon=folium.Icon(color='red', icon='info-sign')).add_to(map_osm)
folium.CircleMarker([37.5658859, 126.9754788], popup='창덕궁', radius=100, color='#3186cc', fill_color='#3186cc').add_to(map_osm)
map_osm.save('map5.html')