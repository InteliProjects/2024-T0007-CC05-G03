import Home from './routes/Home.jsx';
import App from './App';
import GenerateMap from './routes/GenerateGraph.jsx';
import Instructions from './routes/Instructions.jsx';
import { createBrowserRouter } from 'react-router-dom';
import React from 'react';

export const router = createBrowserRouter([
    {
      path: '/',
      element: <App />,
      children: [
        { path: '/', element: <Home /> },
        { path: '/instructions', element: <Instructions />},
        { path: '/generatemap', element: <GenerateMap />},
      ],
    },
  ]);