import './generateGraph.css'
import GraphContainer from '../components/GraphContainer.jsx';
import InformationBar from '../components/InformationBar.jsx';
import { useState } from 'react';

const GenerateMap = () => {
    const [informationsGraph , setInformationsGraph] = useState([]);
    const [ algorithm, setAlgorithm ] = useState(0);
    const [ maxFlow, setMaxFlow ] = useState(0);

    return (
        <div className="containerGenerateMap">
            <div className='graphContainerGenerated'><GraphContainer setMaxFlow={setMaxFlow} Algorithm={algorithm} setInformation={setInformationsGraph}/></div>
            <div className='informationContainerGenerated'><InformationBar MaxFlow={maxFlow} setAlgorithm={setAlgorithm} informationsGraph={informationsGraph}/></div>
        </div>
    );
};

export default GenerateMap;