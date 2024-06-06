package br.edu.inteli.backend.services;

import inteli.places.intermediaryPlace.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static inteli.dellvale.DataApp.patioXML;

/**
 * Serviço para gerenciamento de operações relacionadas aos pátios (Warehouses).
 *
 * <p>Este serviço fornece funcionalidades para acessar e manipular informações sobre
 * os pátios, oferecendo uma camada de abstração para o acesso aos dados dos pátios
 * armazenados em um arquivo XML.</p>
 */
@Service
public class PatiosService {

    /**
     * Recupera a lista completa de pátios a partir de um arquivo XML.
     *
     * <p>Este método acessa os dados de pátios armazenados em um arquivo XML especificado,
     * e os retorna como uma lista de objetos Warehouse, representando todos os pátios cadastrados
     * no sistema.</p>
     *
     * @return Uma lista de objetos Warehouse representando todos os pátios cadastrados.
     */
    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = patioXML("202204_SistemaSudeste.xml");
        return warehouses;
    }

    /**
     * Busca um pátio específico pelo seu identificador.
     *
     * <p>Este método procura um pátio por seu ID em uma lista de pátios carregada a partir de
     * um arquivo XML. O método retorna um {@link Optional<Warehouse>}, que estará vazio caso
     * o pátio não seja encontrado, ou conterá o objeto Warehouse correspondente ao ID, se existir.</p>
     *
     * @param id O identificador único do pátio a ser buscado.
     * @return Um Optional contendo o pátio encontrado, ou um Optional vazio se nenhum pátio
     *         for encontrado com o ID fornecido.
     */
    public Optional<Warehouse> getWarehouseById(String id) {
        List<Warehouse> warehouses = patioXML("202204_SistemaSudeste.xml");
        Optional<Warehouse> warehouseById = warehouses.stream()
                .filter(warehouse -> warehouse.getId().equals(id))
                .findFirst();
        return warehouseById;
    }
}
