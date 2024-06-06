package inteli.places.startPlace;

import inteli.places.Place;

/**
 * Classe Usine representa fábricas no sistema, estendendo a classe Place.
 * Incorpora atributos específicos de fábricas, como o tipo e a quantidade de produção.
 */
public class Usine extends Place {
    private String productionType;
    private int productionQuantity;

    /**
     * Constrói uma instância de Usine com atributos específicos de fábricas.
     *
     * @param id Identificador único da fábrica.
     * @param description Descrição da fábrica.
     * @param productionType Tipo de produto fabricado.
     * @param productionQuantity Quantidade de produtos fabricados.
     */
    public Usine(String id, String description, String productionType, int productionQuantity) {
        super(id, description);
        this.productionType = productionType;
        this.productionQuantity = productionQuantity;
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }

    public int getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(int productionQuantity) {
        this.productionQuantity = productionQuantity;
    }
}
