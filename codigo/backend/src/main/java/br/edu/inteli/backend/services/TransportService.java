package br.edu.inteli.backend.services;

import inteli.transport.Transport;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static inteli.dellvale.DataApp.transportXML;

/**
 * Serviço para gerenciamento de operações relacionadas ao transporte.
 *
 * <p>Este serviço oferece funcionalidades para acessar e manipular informações sobre
 * os meios de transporte disponíveis, permitindo a recuperação de todos os transportes
 * cadastrados no sistema, além da busca por um transporte específico pelo seu ID.</p>
 */
@Service
public class TransportService {

    /**
     * Recupera a lista completa de transportes a partir de um arquivo XML.
     *
     * <p>Este método acessa os dados de transportes armazenados em um arquivo XML,
     * utilizando filtros específicos para produto e cliente (neste caso, usando valores
     * padrão para demonstração) e retorna uma lista de objetos Transport.</p>
     *
     * @return Uma lista de objetos Transport representando todos os meios de transporte cadastrados.
     */
    public List<Transport> getAllTransports() {
        List<Transport> transports = transportXML("202204_SistemaSudeste.xml", "FNCM", BigInteger.valueOf(-1));
        return transports;
    }

    /**
     * Busca um meio de transporte específico pelo seu identificador.
     *
     * <p>Este método procura por um meio de transporte pelo seu ID em uma lista de transportes
     * carregada a partir de um arquivo XML. O método retorna um {@link Optional<Transport>},
     * que estará vazio caso o transporte não seja encontrado, ou conterá o objeto Transport
     * correspondente ao ID, se existir.</p>
     *
     * @param id O identificador único do transporte a ser buscado.
     * @return Um Optional contendo o transporte encontrado, ou um Optional vazio se nenhum
     *         transporte for encontrado com o ID fornecido.
     */
    public Optional<Transport> getTransportById(String id) {
        List<Transport> transports = transportXML("202204_SistemaSudeste.xml", "FNCM", BigInteger.valueOf(-1));
        Optional<Transport> transportById = transports.stream()
                .filter(transport -> transport.getId().equals(id))
                .findFirst();
        return transportById;
    }
}
