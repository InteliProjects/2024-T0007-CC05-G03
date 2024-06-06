import React, { useEffect, useRef, useContext, useState } from 'react';
import './GenerateMap.css';
import { DataSharingContext } from '../context/DataSharingContext.jsx';

const obterLatitudeLongitude = async (nomeLugar) => {
    const apiKey = 'AIzaSyC0xCvNpxb9JFCphCIqeDwC5mWfVZqE_JY';
    const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(nomeLugar)}&key=${apiKey}`;
    
    try {
        const response = await fetch(url);
        const data = await response.json();
        
        if (response.ok && data.status === 'OK') {
            const latitude = data.results[0].geometry.location.lat;
            const longitude = data.results[0].geometry.location.lng;
            return { latitude, longitude };
        } else {
            return null;
        }
    } catch (error) {
        console.error('Erro na solicitação:', error);
        return null;
    }
}

const MapComponent = () => {
    const [locationsSetted, setLocationsSetted] = useState(false);
    const { nodesData, setNodesData, edgesData, setEdgesData } = useContext(DataSharingContext);
    
    const addLatLong = async (constante) => {
        const novosDados = await Promise.all(constante.map(async (item) => {
            const { id, description } = item;
            const result = await obterLatitudeLongitude(description);
            
            if (result && !isNaN(result.latitude) && !isNaN(result.longitude)) {
                const { latitude, longitude } = result;
                return { id, description, lat: latitude, lng: longitude };
            } else {
                return null;
            }
        }));
        
        return novosDados.filter(item => item !== null);
    }    

    console.log('edges:', edgesData);
    
    useEffect(() => {
        if (!locationsSetted) {
            addLatLong(nodesData)
                .then(novosDados => {
                    setNodesData(novosDados);
                    setLocationsSetted(true);
                })
                .catch(error => console.error(error));
        }

        console.log('nodesData:', nodesData);
    }, [locationsSetted, nodesData, setNodesData]);

    const mapaRef = useRef(null);
    let map;
    let markers = [];
    let infoWindow;
    let lines = [];
    let defaultPolylineOptions = {
        strokeColor: '#808080', 
        strokeOpacity: 1.0,
        strokeWeight: 5
    };

    const initialLat = "-20.279948";
    const initialLng = "-40.242166";

    const initialize = () => {
        const latlng = new google.maps.LatLng(initialLat, initialLng);
        const options = {
            zoom: 13,
            center: latlng,
            mapTypeId: google.maps.MapTypeId.SATELLITE,
            streetViewControl: false,
            fullscreenControl: false,
            zoomControl: true,
            zoomControlOptions: {
                position: google.maps.ControlPosition.RIGHT_CENTER
            }
        };
        map = new google.maps.Map(mapaRef.current, options);
        infoWindow = new google.maps.InfoWindow();
    }

    const setPointOnMap = (location) => {
        const circle = new google.maps.Circle({
            strokeColor: '#008F83',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#F3C108',
            fillOpacity: 0.65,
            map,
            center: new google.maps.LatLng(location.lat, location.lng),
            radius: 3000,
        });

        markers.push(circle);

        circle.addListener('click', function () {
            infoWindow.setContent(`Local: ${location.description}<br>Id: ${location.id}`);
            infoWindow.setPosition(circle.getCenter());
            infoWindow.open(map);
            highlightCircle(circle);
        });
    }

    const highlightCircle = (circle) => {
        markers.forEach(marker => {
            marker.setOptions({ fillColor: '#F3C108' });
        });
        circle.setOptions({ fillColor: '#FF0000' });
    }

    const setAllPointsOnMap = () => {
        deleteMarkers();
    
        nodesData.forEach(location => {
            setPointOnMap(location);
        });
    }
    

    const highlightPolylineSegment = (index, path) => {
        lines.forEach(polyline => {
            polyline.setOptions(defaultPolylineOptions);
        });
        const newPolyline = new google.maps.Polyline({
            path: [path[index - 1], path[index]],
            geodesic: true,
            strokeColor: '#00FF00',
            strokeOpacity: 1.0,
            strokeWeight: 5
        });
        newPolyline.setMap(map);
        lines.push(newPolyline);
    }

    const setMapOnAll = (map) => {
        for (let i = 0; i < markers.length; i++) {
            markers[i].setMap(map);
        }
    }

    const clearMarkers = () => {
        setMapOnAll(null);
    }

    const deleteMarkers = () => {
        clearMarkers();
        markers = [];
        lines.forEach(line => {
            line.setMap(null);
        });
        lines = [];
    }

    const findClosestPointIndex = (coordenates, path) => {
        let minDist = Number.MAX_VALUE;
        let index = -1;
        path.forEach((point, i) => {
            const dist = google.maps.geometry.spherical.computeDistanceBetween(coordenates, point);
            if (dist < minDist) {
                minDist = dist;
                index = i;
            }
        });
        return index;
    }

    useEffect(() => {
        initialize();
    }, []);

    return (
        <div>
            <div id="map" style={{ width: '100%', height: '100vh' }} ref={mapaRef}></div>
            <div id="places-map" className="places-map">
                <h2>AÇÕES</h2>
                <button className='mapButton' onClick={setAllPointsOnMap}>
                    Mostrar rotas
                </button>
                <button className='mapButton' onClick={deleteMarkers}>
                    Limpar
                </button>
            </div>
        </div>
    );

}

export default MapComponent;