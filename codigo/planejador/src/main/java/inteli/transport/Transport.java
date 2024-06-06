package inteli.transport;

/**
 * Representa os diferentes tipos de transporte utilizados para deslocamento de cargas ou pessoas.
 * A classe inclui atributos para identificar o transporte, descrição, status operacional, capacidade de carga, e tempo estimado de viagem.
 */
public class Transport {
    private String id;
    private String description;
    private boolean status;
    private String capacity;
    private int time;

    /**
     * Constrói uma instância de Transport com atributos específicos.
     *
     * @param id Identificador único do transporte.
     * @param description Descrição do transporte.
     * @param status Status operacional do transporte (ativo/inativo).
     * @param capacity Capacidade de carga do transporte.
     * @param time Tempo estimado de viagem em minutos.
     */
    public Transport(String id, String description, boolean status, String capacity, int time) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.capacity = capacity;
        this.time = time;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
