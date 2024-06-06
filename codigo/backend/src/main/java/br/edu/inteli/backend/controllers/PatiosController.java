package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.PatiosService;
import inteli.places.intermediaryPlace.Warehouse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que gerencia as operações relacionadas aos pátios (Warehouses).
 *
 * <p>Este controlador expõe endpoints para operações CRUD básicas de pátios,
 * permitindo a consulta de pátios existentes no sistema e a busca de um pátio
 * específico por seu identificador.</p>
 */
@RestController
@RequestMapping("/warehouses")
public class PatiosController {
    private final PatiosService patiosService;

    /**
     * Construtor com injeção de dependência para o serviço de pátios.
     *
     * <p>Permite a manipulação de dados e operações de lógica de negócio relacionadas
     * aos pátios através do serviço PatiosService.</p>
     *
     * @param patiosService Serviço responsável pelas operações e lógica de negócio de pátios.
     */
    public PatiosController(PatiosService patiosService) {
        this.patiosService = patiosService;
    }

    /**
     * Endpoint para obter uma lista de todos os pátios disponíveis.
     *
     * <p>Este método responde a requisições GET para "/warehouses", retornando uma lista
     * de todos os pátios cadastrados no sistema. Os pátios são obtidos através do serviço
     * PatiosService, e a resposta é encapsulada em uma ResponseEntity com status HTTP OK.</p>
     *
     * @return ResponseEntity contendo uma lista de pátios e o status HTTP OK.
     */
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = patiosService.getAllWarehouses();
        return ResponseEntity.ok(warehouses);
    }

    /**
     * Endpoint para obter um pátio específico pelo seu identificador.
     *
     * <p>Este método responde a requisições GET para "/warehouses/{id}", onde {id} é o
     * identificador único de um pátio. Utiliza o PatiosService para buscar o pátio pelo
     * seu ID. Se o pátio for encontrado, retorna-o com status HTTP OK; caso contrário,
     * retorna um status HTTP Not Found.</p>
     *
     * @param id O identificador único do pátio a ser buscado.
     * @return ResponseEntity contendo o pátio buscado ou um status HTTP Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable String id) {
        Optional<Warehouse> warehouse = patiosService.getWarehouseById(id);
        return warehouse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
