package inteli.places.intermediaryPlace;

import inteli.places.Place;

/**
 * Representa armazéns no sistema, estendendo a classe Place.
 * Inclui atributos adicionais específicos para um armazém, como capacidade total de armazenamento e quantidade atual de estoque.
 */
public class Warehouse extends Place {
    private boolean status;
    private String type;

    /**
     * Constrói uma instância de Warehouse com atributos específicos do armazém.
     *
     * @param id Identificador único do armazém.
     * @param description Descrição do armazém.
     * @param status Status do Pátio (Ativo ou Inativo)
     * @param  type Tipo de Pátio
     */
    public Warehouse(String id, String description, boolean status, String type) {
        super(id, description);
        this.status = status;
        this.type = type;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
