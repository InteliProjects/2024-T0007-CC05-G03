import React, { useEffect, useState } from 'react';
import './GraphContainer.css';
import * as d3 from 'd3';

const GraphContainer = ({ setInformation, Algorithm, setMaxFlow }) => {
    const [dataIndex, setDataIndex] = useState(0);
    const [data, setData] = useState([]);
    const [isLoading, setIsLoading] = useState(true);


    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = () => {
        setIsLoading(true);
        fetch('http://localhost:8080/flow/AF40')
            .then(response => response.json())
            .then(data => {
                setData(data);
                setIsLoading(false);
            })
            .catch(error => {
                console.error('Erro ao buscar dados:', error);
                setIsLoading(false);
            });
    };

    useEffect(() => {
        if (data.length > 0) {
            const selectedData = data[Algorithm].edgesWithFlow;
            setMaxFlow(data[Algorithm].maxFlow);

            const nodeMap = {};

            const links = selectedData.map(d => ({
                source: d.originNode?.id,
                target: d.destinyNode?.id,
                capacity: d.capacity,
                flow: d.flow,
                type: 'edge'
            })).filter(link => link.source && link.target);

            const nodes = selectedData.flatMap(d => [d.originNode, d.destinyNode])
                .filter(node => {
                    if (!nodeMap[node.id]) {
                        nodeMap[node.id] = node;
                        return true;
                    }
                    return false;
                })
                .map(node => ({ ...node, type: 'node' }));

            const width = 1000;

            const svg = d3.select("#graph");
            svg.selectAll("*").remove();

            const g = svg.append("g");

            const zoom = d3.zoom()
                .scaleExtent([1, 10])
                .on("zoom", (event) => {
                    g.attr("transform", event.transform);
                });

            svg.call(zoom);

            let highlightedElement = null;

            const handleClick = (event, d) => {
                setInformation({ ...d, type: d.type });
            
                if (highlightedElement) {
                    if (highlightedElement.datum().type === 'node') {
                        highlightedElement.attr('r', 10).attr('fill', '#69b3a2');
                    } else if (highlightedElement.datum().type === 'edge') {
                        highlightedElement.attr('stroke-width', 1).attr('stroke', '#999');
                    }
                }
            
                if (d.type === 'node') {
                    d3.select(event.currentTarget).attr('r', 10).attr('fill', '#ff0000');
                } else if (d.type === 'edge') {
                    d3.select(event.currentTarget).attr('stroke-width', 3).attr('stroke', '#ff0000');
                }
                highlightedElement = d3.select(event.currentTarget);
            };
            
            const handleMouseOut = (event, d) => {
                if (d.type === 'node') {
                    d3.select(event.currentTarget).attr('r', 10);
                } else if (d.type === 'edge') {
                    d3.select(event.currentTarget).attr('stroke-width', 1);
                }
            };
            
            const link = g.append("g")
                .attr("stroke", "#999")
                .attr("stroke-opacity", 0.9)
                .selectAll("line")
                .data(links)
                .join("line")
                .on("click", handleClick)
                .on("mouseout", handleMouseOut);
            
                const node = g.append("g")
                .attr("stroke", "#645645")
                .attr("stroke-width", 1.5)
                .selectAll("circle")
                .data(nodes)
                .join("circle")
                .attr("r", 10)
                .attr("fill", d => {
                    console.log(d);
                    if (d.type === 'PCLIE') {
                        return '#ff0000'; 
                    } else {
                        return "#69b3a2"; 
                    }
                })
                .on("click", handleClick)
                .on("mouseout", handleMouseOut);
            
            

            const simulation = d3.forceSimulation(nodes)
                .force("charge", d3.forceManyBody().strength(-100))
                .force("link", d3.forceLink(links).id(d => d.id))
                .force("x", d3.forceX(d => {
                    if (d.id == 1009) {
                        return width / 2; 
                    } else if (!links.some(link => link.target.id == d.id)) {
                        return 0;
                    } else {
                        return width; 
                    }
                }).strength(0.4))

            simulation.on("tick", () => {
                link
                    .attr("x1", d => d.source.x)
                    .attr("y1", d => d.source.y)
                    .attr("x2", d => d.target.x)
                    .attr("y2", d => d.target.y);

                node
                    .attr("cx", d => d.x)
                    .attr("cy", d => d.y);
            });
        }
    }, [data, dataIndex, Algorithm]);

    const handleAlgorithmChange = index => {
        setDataIndex(index);
    };

    if (isLoading) {
        return <h1 className='loadingText'>Carregando...</h1>;
    }

    return (
        <div className="containerGraph">
            <svg id="graph"></svg>
        </div>
    );
};

export default GraphContainer;
