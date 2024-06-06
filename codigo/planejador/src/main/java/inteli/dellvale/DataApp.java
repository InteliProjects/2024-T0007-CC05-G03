package inteli.dellvale;

import inteli.algoritmos.EdmondsKarp;
import inteli.algoritmos.FordFulkerson;
import inteli.places.endPlace.Client;
import inteli.places.endPlace.Port;
import inteli.places.intermediaryPlace.Warehouse;
import inteli.places.startPlace.Suppliers;
import inteli.transport.Transport;
import inteli.xml.sudeste.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class DataApp {

    /**
     * Obtém um InputStream para um arquivo no classpath.
     *
     * @param fileName O nome do arquivo a ser lido.
     * @return InputStream do arquivo solicitado.
     */
    public static InputStream getInputStream(String fileName) {
        ClassLoader classLoader = DataApp.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    /**
     * Lê um arquivo XML e converte para um objeto Cenario.
     *
     * @param fileName O nome do arquivo XML a ser lido.
     * @return Uma instância de Cenario com os dados lidos do arquivo.
     * @throws JAXBException Caso ocorra um erro durante a deserialização.
     */
    public static Cenario readXML(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cenario.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Cenario) jaxbUnmarshaller.unmarshal(getInputStream(fileName));
    }

    /**
     * Processa um arquivo XML e extrai uma lista de clientes.
     *
     * @param fileName O nome do arquivo XML.
     * @return Uma lista de objetos Client representando os clientes no XML.
     */
    public static List<Client> clientXML(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<ClienteAPS> clientsAPS = scenario.getCadeia().getClientesAPS().getClienteAPS();
        List<PrevisaoCarregamento> forecasts = scenario.getDemanda().getPrevisoesCarregamentos().getPrevisaoCarregamento();

        ArrayList<Client> clientsList = new ArrayList<>();
        for (ClienteAPS clientAPS : clientsAPS) {
            List<Serializable> content = clientAPS.getId().getContent();
            String id = content.get(0).toString();

            String name = clientAPS.getDescricao();
            String countryCode = clientAPS.getCodigoPais();
            String regionCode = clientAPS.getCodigoRegiao();

            for (PrevisaoCarregamento forecast : forecasts) {
                String clientId = forecast.getIdCliente().toString();

                String loadQuantity = null;
                if (clientId.equals(id)) {
                    loadQuantity = String.valueOf(forecast.getQuantidadeMassa());
                }

                Client client = new Client(id, name, loadQuantity, countryCode, regionCode);
                clientsList.add(client);
            }
        }
        return clientsList;
    }
    public static HashMap<BigInteger,Node> getClientsNodes(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }
        HashMap<BigInteger,Node> clientNodesMap = new HashMap<>();
        List<ClienteAPS> clientsAPS = scenario.getCadeia().getClientesAPS().getClienteAPS();
        List<PrevisaoCarregamento> forecasts = scenario.getDemanda().getPrevisoesCarregamentos().getPrevisaoCarregamento();
        HashMap<BigInteger,ArrayList<Demand>> demandMap = getDemandas(fileName);
        int counter = 0;
        int Prod_counter = 0;
        ArrayList<Client> clientsList = new ArrayList<>();
        for (ClienteAPS clientAPS : clientsAPS) {
            List<Serializable> content = clientAPS.getId().getContent();
            String id = content.get(0).toString();
            BigInteger clientId = BigInteger.valueOf(Integer.parseInt(id));
            String name = clientAPS.getDescricao();
            String countryCode = clientAPS.getCodigoPais();
            String regionCode = clientAPS.getCodigoRegiao();
            String tipo = clientAPS.getTipoElo();
            if (demandMap.containsKey(clientId)){
                counter += 1;
                Prod_counter += demandMap.get(clientId).size();
            }
            if (demandMap.containsKey(clientId)) {
                if (countryCode == null) {
                    Demand demand = new Demand();
                    ArrayList<Demand> demandArray = new ArrayList<>();
                    demandArray.add(demand);
                    Node client = new Node(clientId, tipo, name, "null", demandArray);
                    clientNodesMap.put(BigInteger.valueOf(Integer.parseInt(id)), client);
                } else {


                    Node client = new Node(clientId, tipo, name, countryCode, demandMap.get(clientId));
                    clientNodesMap.put(BigInteger.valueOf(Integer.parseInt(id)), client);

                }
            }

        }


        return clientNodesMap;
    }
    public static HashMap<BigInteger,Node> getUsinaPeloNodes(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }
        HashMap<BigInteger,Node> clientNodesMap = new HashMap<>();
        List<UsinaPelotizacaoAPS> clientsAPS = scenario.getCadeia().getUsinasPelotizacaoAPS().getUsinaPelotizacaoAPS();
        List<PrevisaoCarregamento> forecasts = scenario.getDemanda().getPrevisoesCarregamentos().getPrevisaoCarregamento();

        ArrayList<Client> clientsList = new ArrayList<>();
        for (UsinaPelotizacaoAPS clientAPS : clientsAPS) {
            List<Serializable> content = clientAPS.getId().getContent();
            String id = content.get(0).toString();

            String name = clientAPS.getDescricao();
            String tipo = clientAPS.getTipoElo();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);

            Node client= new Node(BigInteger.valueOf(Integer.parseInt(id)),tipo,name,"BRA",demandArray);
            clientNodesMap.put(BigInteger.valueOf(Integer.parseInt(id)),client);

        }
        return clientNodesMap;
    }
    /**
     * Processa um arquivo XML e extrai uma lista de fornecedores.
     *
     * @param fileName O nome do arquivo XML.
     * @return Uma lista de objetos Suppliers representando os fornecedores no XML.
     */
    public static List<Suppliers> suppliersXML(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<FornecedorAPS> suppliersAPS = scenario.getCadeia().getFornecedoresAPS().getFornecedorAPS();
        ArrayList<Suppliers> suppliersList = new ArrayList<>();

        for (FornecedorAPS supplier : suppliersAPS) {
            List<Serializable> content = supplier.getId().getContent();
            String id = content.get(0).toString();

            String name = supplier.getDescricao();
            String type = supplier.getTipoElo();
            boolean isActive = supplier.isAtivo();

            Suppliers supplierObj = new Suppliers(id, name, type, isActive);
            suppliersList.add(supplierObj);
        }
        return suppliersList;
    }
    public static HashMap<BigInteger,Node> getSuppliersNode(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<FornecedorAPS> suppliersAPS = scenario.getCadeia().getFornecedoresAPS().getFornecedorAPS();
        ArrayList<Suppliers> suppliersList = new ArrayList<>();
        HashMap<BigInteger,Node> suppliersNodeMap = new HashMap<>();

        for (FornecedorAPS supplier : suppliersAPS) {
            List<Serializable> content = supplier.getId().getContent();
            String id = content.get(0).toString();

            String name = supplier.getDescricao();
            String type = supplier.getTipoElo();
            boolean isActive = supplier.isAtivo();
            String Description = supplier.getDescricao();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);
            Node supplierNode = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,Description,"BRA",demandArray);
            suppliersNodeMap.put(BigInteger.valueOf(Integer.parseInt(id)),supplierNode);
            Suppliers supplierObj = new Suppliers(id, name, type, isActive);
            suppliersList.add(supplierObj);

        }
        return suppliersNodeMap;
    }
    public static HashMap<BigInteger,ArrayList<Demand>> getDemandas(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<PrevisaoAgregada> demandAPS = scenario.getDemanda().getPrevisoesAgregadas().getPrevisaoAgregada();
        HashMap<BigInteger,ArrayList<Demand>> demandMap = new HashMap<>();

        for (PrevisaoAgregada demanda : demandAPS) {
            List<Serializable> content = demanda.getId().getContent();
            BigInteger id = demanda.getCodigoElo();

            BigDecimal qtdeProduto = demanda.getQtdeProduto();
            Date data_inicio = demanda.getDataInicio().toGregorianCalendar().getTime();
            Date data_fim = demanda.getDataFim().toGregorianCalendar().getTime();
            String codigo_produto = demanda.getCodigoProduto();

            String demand_type = demanda.getTipoDemanda();
            if (demandMap.containsKey(id)){
                Demand demand = new Demand(id,data_inicio,data_fim,codigo_produto,demand_type,qtdeProduto);
                demandMap.get(id).add(demand);

            }else{
                ArrayList<Demand> demandList = new ArrayList<>();
                Demand demand = new Demand(id,data_inicio,data_fim,codigo_produto,demand_type,qtdeProduto);
                demandList.add(demand);
                demandMap.put(id, demandList);
            }



        }
        return demandMap;
    }
    /**
     * Processa um arquivo XML e extrai uma lista de transportes.
     *
     * @param fileName O nome do arquivo XML.
     * @param product O produto especificado.
     * @param clientId O ID do cliente.
     * @return Uma lista de objetos Transport representando os meios de transporte no XML.
     */
    public static List<Transport> transportXML(String fileName, String product, BigInteger clientId) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<TrechoTransporte> transportSegments = scenario.getFluxo().getTrechosTransporte().getTrechoTransporte();
        ArrayList<Transport> transportList = new ArrayList<>();
        ArrayList<BigInteger> destinationArray = new ArrayList<>();
        ArrayList<BigInteger> originArray = new ArrayList<>();
        ArrayList<Edge> edgeArray = new ArrayList<>();

        HashMap<String, Double> capacityMap = getCapacities(fileName, product);
        HashMap<BigInteger, Node> clientsMap = getClientsNodes(fileName);
        for (TrechoTransporte segment : transportSegments) {
            String id = segment.getId().toString();
            JAXBElement<String> modeCode = (JAXBElement<String>) segment.getId().getContent().get(1);
            JAXBElement<BigInteger> originId = (JAXBElement<BigInteger>) segment.getId().getContent().get(5);
            JAXBElement<BigInteger> destinationId = (JAXBElement<BigInteger>) segment.getId().getContent().get(3);

            Double capacity = capacityMap.get(modeCode.getValue());

            if(capacityMap.containsKey(modeCode.getValue())) {
                destinationArray.add(destinationId.getValue());
                originArray.add(originId.getValue());
                //Edge edge = new Edge(originId.getValue(), capacity.intValue(), destinationId.getValue(), modeCode.getValue());
                //edgeArray.add(edge);
            }

            String description = segment.getDescricao();
            boolean isActive = segment.isConsiderarAtendimento();
            String capacityStr = segment.getConsiderarCapacidade();
            int travelTime = segment.getTempoPercurso().intValue();
            Transport transport = new Transport(id, description, isActive, capacityStr, travelTime);
            transportList.add(transport);
        }

        return transportList;
    }

    /**
     * Processa um arquivo XML e extrai uma lista de portos.
     *
     * @param fileName O nome do arquivo XML.
     * @return Uma lista de objetos Port representando os portos no XML.
     */
    public static List<Port> portXML(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<PortoAPS> portsAPS = scenario.getCadeia().getPortosAPS().getPortoAPS();
        ArrayList<Port> portsList = new ArrayList<>();

        for (PortoAPS portAPS : portsAPS) {
            List<Serializable> content = portAPS.getId().getContent();
            String id = content.get(0).toString();
            String description = portAPS.getDescricao();
            boolean isActive = portAPS.isAtivo();
            String type = portAPS.getTipoElo();

            Port port = new Port(id, description, isActive, type);
            portsList.add(port);
        }
        return portsList;
    }
    public static HashMap<BigInteger,Node> getPortNodes(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }


        List<PortoAPS> portsAPS = scenario.getCadeia().getPortosAPS().getPortoAPS();
        ArrayList<Port> portsList = new ArrayList<>();
        HashMap<BigInteger,Node> portNodesMap = new HashMap<>();
        for (PortoAPS portAPS : portsAPS) {
            List<Serializable> content = portAPS.getId().getContent();
            String id = content.get(0).toString();
            String description = portAPS.getDescricao();
            boolean isActive = portAPS.isAtivo();
            String type = portAPS.getTipoElo();
            String country = portAPS.getCodigoPais();
            if (country == null){
                Demand demand =new Demand();
                ArrayList<Demand> demandArray = new ArrayList<>();
                demandArray.add(demand);

                Node portNode = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,"null",demandArray);
            portNodesMap.put(BigInteger.valueOf(Integer.parseInt(id)),portNode);
            Port port = new Port(id, description, isActive, type);
            portsList.add(port);
            } else{
                Demand demand =new Demand();
                ArrayList<Demand> demandArray = new ArrayList<>();
                demandArray.add(demand);
                Node portNode = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,country,demandArray);
                portNodesMap.put(BigInteger.valueOf(Integer.parseInt(id)),portNode);
                Port port = new Port(id, description, isActive, type);
                portsList.add(port);

            }        }
        return portNodesMap;
    }
    /**
     * Processa um arquivo XML e extrai uma lista de pátios.
     *
     * @param fileName O nome do arquivo XML.
     * @return Uma lista de objetos Warehouse representando os pátios no XML.
     */
    public static List<Warehouse> patioXML(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<PatioAPS> yardsAPS = scenario.getCadeia().getPatiosAPS().getPatioAPS();
        ArrayList<Warehouse> yardsList = new ArrayList<>();

        for (PatioAPS yardAPS : yardsAPS) {
            List<Serializable> content = yardAPS.getId().getContent();
            String id = content.get(0).toString();
            String description = yardAPS.getDescricao();
            boolean isActive = yardAPS.isAtivo();
            String type = yardAPS.getTipoElo();

            Warehouse yard = new Warehouse(id, description, isActive, type);
            yardsList.add(yard);
        }
        return yardsList;
    }

    public static HashMap<BigInteger,Node> getPatiosNode(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<PatioAPS> patiosList = scenario.getCadeia().getPatiosAPS().getPatioAPS();
        HashMap<BigInteger,Node> patiosNodeMap = new HashMap<>();
        for (PatioAPS patio : patiosList) {
            List<Serializable> content = patio.getId().getContent();
            String id = content.get(0).toString();
            String description = patio.getDescricao();
            String type = patio.getCodigoTipoPatio();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);
            Node patioNode = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,"BRA",demandArray);
            patiosNodeMap.put(BigInteger.valueOf(Integer.parseInt(id)),patioNode );

        }
        return patiosNodeMap;
    }
    public static HashMap<BigInteger,Node> getMinasNode(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<MinaAPS> minasList = scenario.getCadeia().getMinasAPS().getMinaAPS();
        HashMap<BigInteger,Node> minasNodeMap = new HashMap<>();
        for (MinaAPS mina : minasList) {
            List<Serializable> content = mina.getId().getContent();
            String id = content.get(0).toString();
            String description = mina.getDescricao();
            String type = mina.getTipoElo();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);           
            Node minaNode = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,"BRA",demandArray);
            minasNodeMap.put(BigInteger.valueOf(Integer.parseInt(id)),minaNode );

        }
        return minasNodeMap;
    }
    public static HashMap<BigInteger,Node> getUsinaBeneficiamentoNodes(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<UsinaBeneficiamentoAPS> usinasList = scenario.getCadeia().getUsinasBeneficiamentoAPS().getUsinaBeneficiamentoAPS();
        HashMap<BigInteger,Node> usinasNodeMap = new HashMap<>();
        for (UsinaBeneficiamentoAPS usina : usinasList) {
            List<Serializable> content = usina.getId().getContent();
            String id = content.get(0).toString();
            String description = usina.getDescricao();
            String type = usina.getTipoElo();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);
            Node mina = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,"BRA",demandArray);
            usinasNodeMap.put(BigInteger.valueOf(Integer.parseInt(id)),mina );

        }
        return usinasNodeMap;
    }
    public static HashMap<BigInteger,Node> getUsinasBriqNodes(String fileName) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<UsinaBriqueteAPS> usinasList = scenario.getCadeia().getUsinasBriqueteAPS().getUsinaBriqueteAPS();
        HashMap<BigInteger,Node> usinaNodeMap = new HashMap<>();
        for (UsinaBriqueteAPS usina : usinasList) {
            List<Serializable> content = usina.getId().getContent();
            String id = content.get(0).toString();
            String description = usina.getDescricao();
            String type = usina.getTipoElo();
            Demand demand =new Demand();
            ArrayList<Demand> demandArray = new ArrayList<>();
            demandArray.add(demand);

            Node mina = new Node(BigInteger.valueOf(Integer.parseInt(id)),type,description,"BRA",demandArray);
            usinaNodeMap.put(BigInteger.valueOf(Integer.parseInt(id)),mina );

        }
        return usinaNodeMap;
    }
    
    // Outros métodos similares para processamento de pátios, minas, usinas, etc.

    /**
     * Cria um mapa de nós a partir do arquivo XML fornecido.
     *
     * @param filename O nome do arquivo XML.
     * @return Um mapa de nós representando diferentes elementos da cadeia logística.
     */
    public static  HashMap<BigInteger,Node>  getNodesMap(String filename) {
        HashMap<BigInteger,Node> clientNodesMap = getClientsNodes(filename);
        HashMap<BigInteger,Node> patiosNodeMap = getPatiosNode(filename);
        HashMap<BigInteger,Node> portNodesMap = getPortNodes(filename);
        HashMap<BigInteger,Node> pelNodesMap = getUsinaPeloNodes(filename);
        HashMap<BigInteger,Node> minasNodeMap = getMinasNode(filename);
        HashMap<BigInteger,Node> benefNodesMap = getUsinaBeneficiamentoNodes(filename);
        HashMap<BigInteger,Node> BriqNodesMap = getUsinasBriqNodes(filename);


        HashMap<BigInteger, Node> generalNodeMap = new HashMap<>(clientNodesMap);
        HashMap<BigInteger,Node> suppliersNodeMap = getSuppliersNode(filename);
        generalNodeMap.putAll(suppliersNodeMap);
        generalNodeMap.putAll(patiosNodeMap);
        generalNodeMap.putAll(portNodesMap);
        generalNodeMap.putAll(pelNodesMap);
        generalNodeMap.putAll(minasNodeMap);
        generalNodeMap.putAll(benefNodesMap);
        generalNodeMap.putAll(BriqNodesMap);

        return generalNodeMap;


    }
        /**
     * Cria arestas para um grafo a partir do arquivo XML fornecido e do produto especificado.
     *
     * @param filename O nome do arquivo XML.
     * @param product O produto especificado.
     * @return Uma lista de objetos Edge representando as arestas do grafo.
     */
    public static List<Edge> CreateEdges(String filename,String product) {
        // Método para criar arestas a partir do XML
        Cenario cenario;
        try {
            cenario = readXML(filename);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Erro ao ler o arquivo XML");
        }

        List<TrechoTransporte> transporte = cenario.getFluxo().getTrechosTransporte().getTrechoTransporte();
        ArrayList<Transport> transportList = new ArrayList<>();
        ArrayList<BigInteger> ArrayDestino = new ArrayList<>();

        ArrayList<BigInteger> ArrayOrigem = new ArrayList<>();
        ArrayList<Edge> arrayEdges = new ArrayList<>();
        HashMap<String,Double> capacities = getCapacities(filename,product);


        HashMap<BigInteger, Node> generalNodeMap = getNodesMap(filename);


        for (TrechoTransporte trecho : transporte) {
            JAXBElement<String> codigoModal = (JAXBElement<String>) trecho.getId().getContent().get(1);
            JAXBElement<BigInteger> idOrigem = (JAXBElement<BigInteger>) trecho.getId().getContent().get(5);
            JAXBElement<BigInteger> idDestino = (JAXBElement<BigInteger>) trecho.getId().getContent().get(3);
            Double time = trecho.getTempoPercurso().doubleValue();
            String timeType = trecho.getIndicadorUnidadeMedidaTempoPercurso();


            if(capacities.containsKey(codigoModal.getValue())) {
                Double capacity = capacities.get(codigoModal.getValue());
                if(timeType.equals("H")) {
                    if(time!=0.0) {
                        capacity = capacity*24/time;

                    }
                }else{
                    if(time!=0.0) {
                        capacity = capacity/time;
                    }
                }
                ArrayDestino.add(idDestino.getValue());
                ArrayOrigem.add(idOrigem.getValue());
                if (generalNodeMap.containsKey(idDestino.getValue())&&generalNodeMap.containsKey(idOrigem.getValue())){
                    if(generalNodeMap.get(idOrigem.getValue()).getCountry().equals("BRA") &&generalNodeMap.get(idDestino.getValue()).getCountry().equals("BRA")) {
                            Edge edge = new Edge(idOrigem.getValue(), capacity.intValue(), idDestino.getValue(), codigoModal.getValue(), generalNodeMap.get(idOrigem.getValue()), generalNodeMap.get(idDestino.getValue()));
                            arrayEdges.add(edge);


                    }




                }

            }


        }


        return arrayEdges;
    }
      /**
     * Obtém as capacidades de transporte a partir do arquivo XML e do produto especificado.
     *
     * @param fileName O nome do arquivo XML.
     * @param product O produto especificado.
     * @return Um mapa de capacidades de transporte para diferentes modos de transporte.
     */
    public static HashMap<String, Double> getCapacities(String fileName, String product) {
        Cenario scenario;
        try {
            scenario = readXML(fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error reading XML file");
        }

        List<SubmodalTransporte> submodalTransports = scenario.getFluxo().getSubmodaisTransporte().getSubmodalTransporte();
        HashMap<String, Double> capacities = new HashMap<>();

        for (SubmodalTransporte submodal : submodalTransports) {
            if (submodal.getContent().get(7) instanceof PesosMediosTransporteProduto) {
                PesosMediosTransporteProduto averageWeights = (PesosMediosTransporteProduto) submodal.getContent().get(7);
                List<PesoMedioTransporteProduto> weightList = averageWeights.getPesoMedioTransporteProduto();
                for (PesoMedioTransporteProduto weight : weightList) {
                    if (weight.getCodigoProduto().equals(product)) {
                        capacities.put(weight.getCodigoSubModal(), weight.getPesoMedio().doubleValue());
                    }
                }
            }
        }
        return capacities;
    }


    /**
     * Método principal para executar a leitura e processamento dos dados XML.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        List<Client> clients = clientXML("202204_SistemaSudeste.xml");
        List<Suppliers> suppliers = suppliersXML("202204_SistemaSudeste.xml");
        List<Transport> transports = transportXML("202204_SistemaSudeste.xml", "FNCM", BigInteger.valueOf(2438));
        List<Port> ports = portXML("202204_SistemaSudeste.xml");
        List<Warehouse> yards = patioXML("202204_SistemaSudeste.xml");
        List<Edge> edges = CreateEdges("202204_SistemaSudeste.xml", "FNCM");

        Digrafo graph = new Digrafo(edges);

        graph.showAdjList();
        EdmondsKarp ed  =new EdmondsKarp(graph);
        FordFulkerson ff = new FordFulkerson(graph);
        System.out.println("EK");

        System.out.println(ed.getMaxFlow(0, graph.getV()-1));
        for (Edge edge : edges){

            System.out.println("{");
            System.out.println("NodeOrigem:" + edge.getOriginNode().getDescription() + "/" + edge.getOriginNode().getCountry() + "/" + edge.getOriginNode().getType() + "/" + edge.getOriginNode().getId() + "/");
            System.out.println("NodeDestiny:" + edge.getDestinyNode().getDescription() + "/" + edge.getDestinyNode().getCountry() + "/" + edge.getDestinyNode().getType() + "/" + edge.getDestinyNode().getId() + "/");
            System.out.println("Fluxo:" + edge.getFlow());
            System.out.println("Capacity:" + edge.getCapacity());
            System.out.println("}");

        }
        graph.resetFlows();
        System.out.println("FF");
        System.out.println(ff.fordFulkerson(graph.getAdjMatrix(), 0, graph.getV()-1));

        for (Edge edge : edges){
            System.out.println("{");
            System.out.println("NodeOrigem:"+edge.getOriginNode().getDescription()+"/"+edge.getOriginNode().getCountry()+"/"+edge.getOriginNode().getType()+"/"+edge.getOriginNode().getId()+"/");
            System.out.println("NodeDestiny:"+edge.getDestinyNode().getDescription()+"/"+edge.getDestinyNode().getCountry()+"/"+edge.getDestinyNode().getType()+"/"+edge.getDestinyNode().getId()+"/");
            System.out.println("Fluxo:"+edge.getFlow());
            System.out.println("Capacity:"+edge.getCapacity());
            System.out.println("}");

        }
          }


}
