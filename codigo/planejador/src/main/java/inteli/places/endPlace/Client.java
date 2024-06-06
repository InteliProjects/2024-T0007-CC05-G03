package inteli.places.endPlace;

import inteli.places.Place;

/**
 * A classe Client estende Place para representar clientes específicos.
 * Inclui características únicas, como a quantidade de demanda, essencial para atender às necessidades específicas de cada cliente.
 */
public class Client extends Place {
    private String demandQuantity;
    private String countryLocation;
    private String regionLocation;

    /**
     * Constrói uma nova instância de Client.
     *
     * @param id Identificador único do cliente.
     * @param description Descrição do cliente.
     * @param demandQuantity Quantidade da demanda do cliente.
     * @param countryLocation Localização do país do cliente.
     * @param regionLocation Localização da região do cliente.
     */
    public Client(String id, String description, String demandQuantity, String countryLocation, String regionLocation) {
        super(id, description);
        this.demandQuantity = demandQuantity;
        this.countryLocation = countryLocation;
        this.regionLocation = regionLocation;
    }

    public String getDemandQuantity() {
        return demandQuantity;
    }

    public String getCountryLocation() {
        return countryLocation;
    }

    public String getRegionLocation() {
        return regionLocation;
    }

    public void setDemandQuantity(String demandQuantity) {
        this.demandQuantity = demandQuantity;
    }

    public void setCountryLocation(String countryLocation) {
        this.countryLocation = countryLocation;
    }

    public void setRegionLocation(String regionLocation) {
        this.regionLocation = regionLocation;
    }

    // Considerar adicionar getters e setters para countryLocation e regionLocation, se necessário.
}
