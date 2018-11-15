import folium
import webbrowser
import vincent
import numpy as np
import json
import branca
import pandas as pd
from folium import features

try:
    from altair import Chart, load_dataset
except TypeError:
    print('Try updating your python version to 3.5.3 or above')
N = 100

multi_iter2 = pd.DataFrame({
    'x': np.random.uniform(size=(N,)),
    'y': np.random.uniform(size=(N,)),
})

scatter = Chart(multi_iter2).mark_circle().encode(x='x', y='y')
scatter.width = 420
scatter.height = 250
data = json.loads(scatter.to_json())

f = branca.element.Figure()

# Create two maps.
m = folium.Map(
    location=[0, 0],
    tiles='stamenwatercolor',
    zoom_start=1,
    position='absolute',
    left='0%',
    width='50%',
    height='50%'
)

m2 = folium.Map(
    location=[46, 3],
    tiles='OpenStreetMap',
    zoom_start=4,
    position='absolute',
    left='50%',
    width='50%',
    height='50%',
    top='50%')


# Create two Vega.
v = features.VegaLite(
    data,
    position='absolute',
    left='50%',
    width='50%',
    height='50%'
)

v2 = features.VegaLite(
    data,
    position='absolute',
    left='0%',
    width='50%',
    height='50%',
    top='50%'
)

f.add_child(m)
f.add_child(m2)
f.add_child(v)
f.add_child(v2)

f.save('test.html')
webbrowser.open('test.html')