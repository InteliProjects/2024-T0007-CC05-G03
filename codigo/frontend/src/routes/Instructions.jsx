import './Instructions.css';
import { Link } from 'react-router-dom';
import React from 'react';

const Instructions = () => {
    const json = {
        nós: [
            {"Minas": "Conseição",
            "Fornecedores": "Arcelor",
            "Usina de Beneficiamento": "UBS3",
            "Entrepostos": "Entreposto3"}
        ],
        arestas: [
            {"Capacidade": "3 toneladas",
            "Origem": "Conceição",
            "Destino": "Porto de Tubarão",
            "Distância": "100 km"}
        ]
    };

    const jsonString = JSON.stringify(json, null, '  ');

    return (
        <div className="containerHome">
            <div className='containerMain'>
                <div className='buttonBackContainer'>
                    <Link className='buttonBackInitial' to={'/'}>X</Link>
                </div>
                <h1 className='newGraphsTitle'>INSTRUÇÕES</h1>
                <p className='instructionsDescription'> 
                    Para gerar um novo grafo que represente os seus dados, você deve 
                    passá-los para o formato JSON. Para isso, o arquivo deve ter os seguintes tópicos (<i>Keys</i>): nós e arestas, 
                    que vão representar respectivamente os nós e as arestas do grafo.
                </p>
                <div className='codeSpace'>
                    <p>
                        {JSON.stringify({
                            nós: [
                            ],
                            arestas: [
                                // ...
                            ]
                        }, null, 2)}
                    </p>
                </div>
                <p className='instructionsDescription'>
                    Assim, você pode inserir outros objetos e arrays, dentro das <i>Keys</i> nós e arestas, com as propriedades 
                    de interesse para o grafo. Como, por exemplo, “Minas”, “Fornecedores”, “Usina de Beneficiamento”, 
                    “Entrepostos”, “Cliente Intermediário” e “Porto” para nós, e "Capacidade", "Origem", "Destino" e 
                    "Distância" para arestas.
                </p>
                <div className='codeSpace'>
                    <pre>{jsonString}</pre>
                </div>
                <p className='instructionsDescription'>
                    Com os dados em formato JSON, você pode clicar no botão de adicionar um arquivo, localizado 
                    na página inicial, e, em seguida, clicar em "Gerar" e pronto! Seu grafo será gerado.
                </p>
            </div>
        </div>
    );
}

export default Instructions;