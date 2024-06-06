package br.edu.inteli.backend.services;

import inteli.places.startPlace.Suppliers;
import org.springframework.stereotype.Service;

import java.util.List;

import static inteli.dellvale.DataApp.suppliersXML;

/**
 * Serviço dedicado ao gerenciamento de operações relacionadas aos fornecedores (Suppliers).
 *
 * <p>Este serviço fornece funcionalidades para acessar e manipular informações sobre
 * fornecedores, oferecendo uma camada de abstração para o acesso aos dados dos fornecedores
 * armazenados em um arquivo XML. A abordagem facilita a integração e manutenção dos dados de fornecedores
 * em toda a aplicação.</p>
 */
@Service
public class SuppliersService {
    /**
     * Recupera a lista completa de fornecedores a partir de um arquivo XML.
     *
     * <p>Este método acessa os dados de fornecedores armazenados no arquivo XML especificado,
     * convertendo-os em uma lista de objetos Suppliers. É ideal para prover um acesso unificado
     * e simplificado aos dados dos fornecedores registrados no sistema.</p>
     *
     * @return Uma lista de objetos Suppliers representando todos os fornecedores cadastrados.
     */
    public List<Suppliers> getAllSuppliers() {
        List<Suppliers> suppliers = suppliersXML("202204_SistemaSudeste.xml");
        return suppliers;
    }
}
