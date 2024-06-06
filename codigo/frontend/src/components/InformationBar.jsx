import React from 'react';
import './InformationBar.css';
import { useState } from 'react';

const InformationBar = ({ informationsGraph, setAlgorithm, MaxFlow }) => {

    const handleAlgorithmChange = (algorithm) => {
        setAlgorithm(algorithm);
        setAlgorithmTwo(algorithm);
    }

    const [ algorithmTwo, setAlgorithmTwo ] = useState(0);
    
    return (
        <div className="containerInformationBar">
            <div>
                <button className='buttonAlgorithm' onClick={() => handleAlgorithmChange(0)}>Ford-Fulkerson</button>
                <button className='buttonAlgorithm' onClick={() => handleAlgorithmChange(1)}>Edmonds-Karp</button>
            </div>

            <p className='titleInformation'>Algoritmo Usado</p>

            <p className='descriptionInformation'>{algorithmTwo?  "Edmonds-Karp": "Ford-Fulkerson"}</p>

            <p className='titleInformation'>Fluxo Máximo</p>

            <p className='descriptionInformation'>{MaxFlow}</p>

            {informationsGraph.type != 'node' && informationsGraph.type != 'edge' && (
                <p className='descriptionInformation'>Selecione um nó ou aresta para ver mais informações</p>
            )}
            {informationsGraph && informationsGraph.type == 'node' && (
                <>
                    <p className='titleInformation'>Node</p>
                    <p className='descriptionInformation'>ID: {informationsGraph.id}</p>
                    <p className='descriptionInformation'>Descrição: {informationsGraph.description}</p>
                </>
            )}
            {informationsGraph && informationsGraph.type == 'edge' && (
                <>
                    <p className='titleInformation'>Edge</p>
                    <p className='descriptionInformation'>Capacidade: {informationsGraph.capacity}</p>
                    <p className='descriptionInformation'>Fluxo: {informationsGraph.flow}</p>
                </>
            )}
        </div>
    );
}

export default InformationBar;
