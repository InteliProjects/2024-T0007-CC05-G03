import React, { createContext, useState } from 'react';

export const DataSharingContext = createContext();

export const DataSharingProvider = ({ children }) => {
  const [nodesData, setNodesData] = useState(null);
  const [edgesData, setEdgesData] = useState(null);

  return (
    <DataSharingContext.Provider value={{ nodesData, edgesData, setEdgesData, setNodesData }}>
      {children}
    </DataSharingContext.Provider>
  );
};
