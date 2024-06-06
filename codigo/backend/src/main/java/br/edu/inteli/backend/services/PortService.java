package br.edu.inteli.backend.services;

import inteli.places.endPlace.Port;
import org.springframework.stereotype.Service;

import java.util.List;

import static inteli.dellvale.DataApp.portXML;

/**
 * Serviço para gerenciamento de operações relacionadas aos portos.
 *
 * <p>Este serviço oferece funcionalidades para acessar e manipular informações sobre
 * os portos, permitindo a recuperação de uma lista de todos os portos cadastrados no sistema
 * a partir de um arquivo XML.</p>
 */
@Service
public class PortService {

    /**
     * Recupera a lista completa de portos a partir de um arquivo XML.
     *
     * <p>Este método acessa os dados de portos armazenados em um arquivo XML especificado,
     * e os retorna como uma lista de objetos Port. É utilizado para fornecer acesso aos dados
     * de todos os portos cadastrados no sistema.</p>
     *
     * @return Uma lista de objetos Port representando todos os portos cadastrados.
     */
    public List<Port> getAllPorts() {
        List<Port> ports = portXML("202204_SistemaSudeste.xml");
        return ports;
    }
}
