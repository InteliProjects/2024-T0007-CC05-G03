package br.edu.inteli.backend.services;

import inteli.places.endPlace.Client;
import org.springframework.stereotype.Service;

import java.util.List;

import static inteli.dellvale.DataApp.clientXML;

/**
 * Serviço para gerenciamento de operações relacionadas aos clientes.
 *
 * <p>Este serviço é responsável por interagir com a fonte de dados dos clientes,
 * fornecendo uma camada de abstração para o acesso e manipulação de informações
 * de clientes. Utiliza o método estático clientXML da classe DataApp para carregar
 * os dados dos clientes.</p>
 */
@Service
public class ClientService {

    /**
     * Recupera a lista completa de clientes.
     *
     * <p>Este método acessa os dados de clientes a partir de um arquivo XML
     * especificado e os retorna como uma lista de objetos Client. É utilizado
     * para fornecer acesso aos dados de todos os clientes cadastrados no sistema.</p>
     *
     * @return Uma lista de objetos Client representando todos os clientes cadastrados.
     */
    public List<Client> getAllClients() {
        // Aqui o método clientXML é chamado com um arquivo XML específico como argumento.
        // Este arquivo contém os dados dos clientes que são carregados e transformados em objetos Client.
        List<Client> clients = clientXML("202204_SistemaSudeste.xml");
        return clients;
    }
}
