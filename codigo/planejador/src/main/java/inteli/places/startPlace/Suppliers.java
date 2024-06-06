package inteli.places.startPlace;

import inteli.places.Place;

/**
 * Representa fornecedores no sistema, estendendo a classe Place.
 * Inclui detalhes específicos dos fornecedores, como o tipo de elo e o status operacional.
 */
public class Suppliers extends Place {
    private String eloType; // Tipo de elo com o fornecedor, como fábrica ou fazenda.
    private boolean status; // Status operacional do fornecedor (ativo/inativo).

    /**
     * Constrói uma nova instância de Suppliers com parâmetros específicos.
     *
     * @param id Identificador único do fornecedor.
     * @param description Descrição do fornecedor.
     * @param eloType Tipo de elo do fornecedor.
     * @param status Status operacional do fornecedor.
     */
    public Suppliers(String id, String description, String eloType, boolean status) {
        super(id, description);
        this.eloType = eloType;
        this.status = status;
    }

    // Métodos Getters e Setters

    public String getEloType() {
        return eloType;
    }

    public void setEloType(String eloType) {
        this.eloType = eloType;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
