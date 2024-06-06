package inteli.places.endPlace;

import inteli.places.Place;

/**
 * Classe Port estende Place para representar portos no sistema.
 * Inclui atributos como status para indicar se o porto está ativo ou não e o tipo de carga ou serviço oferecido.
 */
public class Port extends Place {
    private boolean status; // Indica se o porto está ativo (true) ou inativo (false).
    private String type; // Tipo de carga ou serviço oferecido pelo porto.

    /**
     * Constrói uma nova instância de Port com parâmetros específicos.
     *
     * @param id Identificador único do porto.
     * @param description Descrição do porto.
     * @param status Status operacional do porto (ativo ou inativo).
     * @param type Tipo de carga ou serviço disponível no porto.
     */
    public Port(String id, String description, boolean status, String type) {
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
