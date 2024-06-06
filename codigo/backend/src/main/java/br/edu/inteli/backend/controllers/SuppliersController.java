package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.SuppliersService;
import inteli.places.startPlace.Suppliers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gerenciamento de fornecedores (Suppliers).
 *
 * <p>Este controlador disponibiliza endpoints para operações relacionadas aos fornecedores,
 * permitindo a obtenção de uma lista com todos os fornecedores cadastrados no sistema.</p>
 */
@RestController
@RequestMapping("/suppliers") // Mapeia todas as requisições HTTP para "/suppliers" para este controlador.
public class SuppliersController {

    private final SuppliersService suppliersService;

    /**
     * Constrói uma instância de SuppliersController com uma injeção de dependência do SuppliersService.
     *
     * <p>Isso permite ao controlador acessar os métodos e a lógica de negócio fornecidos pelo SuppliersService,
     * facilitando as operações relacionadas aos fornecedores.</p>
     *
     * @param suppliersService O serviço responsável pelas operações de negócio envolvendo fornecedores.
     */
    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    /**
     * Endpoint para obter uma lista de todos os fornecedores.
     *
     * <p>Este método responde a requisições GET para "/suppliers", utilizando o SuppliersService
     * para recuperar todos os fornecedores disponíveis. A lista de fornecedores é então retornada
     * ao cliente encapsulada em uma ResponseEntity com status HTTP OK.</p>
     *
     * @return ResponseEntity contendo a lista de fornecedores e o status HTTP OK.
     */
    @GetMapping // Mapeia requisições GET para este método.
    public ResponseEntity<List<Suppliers>> getAllSuppliers() {
        List<Suppliers> suppliers = suppliersService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
}
