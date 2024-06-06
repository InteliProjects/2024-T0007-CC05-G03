import React, { useEffect, useRef } from 'react';
import './GerarMapaInput.css';
import { useLocation } from 'react-router-dom';

const MapComponent = () => {
    const {state} = useLocation();
    const locations = state?.fileData ? JSON.parse(state.fileData) : []; // Parse do JSON se fileData existir
    const mapaRef = useRef(null);
    let map;
    let markers = [];
    let infoWindow;
    let polyline;
    let lines = [];
    let defaultPolylineOptions = {
        strokeColor: '#808080', // Cor cinza padrão para os elementos não selecionados
        strokeOpacity: 1.0,
        strokeWeight: 5
    };


    const latInicial = "-20.279948";
    const lngInicial = "-40.242166";

    const initialize = () => {
        const latlng = new google.maps.LatLng(latInicial, lngInicial);
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

    const marcarPonto = (location) => {
        const circle = new google.maps.Circle({
            strokeColor: '#008F83',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#F3C108',
            fillOpacity: 0.65,
            map,
            center: new google.maps.LatLng(location.lat, location.lng),
            radius: 2500,
        });

        markers.push(circle);

        circle.addListener('click', function () {
            infoWindow.setContent(`Local: ${location.local}<br>Capacidade: ${location.capacidade}`);
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

    const marcarTodosPontos = () => {
        deleteMarkers();

        const path = locations.map(location => {
            marcarPonto(location);
            return new google.maps.LatLng(location.lat, location.lng);
        });

        polyline = new google.maps.Polyline({
            path: path,
            geodesic: true,
            strokeColor: '#808080', // Cor cinza padrão para os elementos não selecionados
            strokeOpacity: 1.0,
            strokeWeight: 5
        });

        polyline.setMap(map);

        polyline.addListener('click', function (event) {
            const latLng = event.latLng;
            const index = findClosestPointIndex(latLng, path);
            const location = locations[index];
            if (location) {
                infoWindow.setContent(`Tipo: Aresta<br>Origem: ${locations[index - 1].local}<br>Destino: ${locations[index].local}`);
                infoWindow.setPosition(latLng);
                infoWindow.open(map);
                highlightPolylineSegment(index, path);
            }
        });

        lines.push(polyline);
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

    const findClosestPointIndex = (latLng, path) => {
        let minDist = Number.MAX_VALUE;
        let index = -1;
        path.forEach((point, i) => {
            const dist = google.maps.geometry.spherical.computeDistanceBetween(latLng, point);
            if (dist < minDist) {
                minDist = dist;
                index = i;
            }
        });
        return index;
    }

    useEffect(() => {
        if (locations.length > 0) {
            initialize(); // Chame initialize somente se locations estiver definido
        }
    }, [locations]);

    return (
        <div>
            <div id="mapa" style={{ width: '100%', height: '100vh' }} ref={mapaRef}></div>
            <div id="mapa-lugares" className="mapa-lugares">
                <h2>AÇÕES</h2>
                <button className='botaoMapa' onClick={marcarTodosPontos}>
                    Mostrar rotas
                </button>
                <button className='botaoMapa' onClick={deleteMarkers}>
                    Limpar
                </button>
            </div>
        </div>
    );

}

export default MapComponent;
