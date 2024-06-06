package inteli.places;

/**
 * Representa um local genérico dentro de um sistema, servindo como superclasse para diferentes tipos de locais.
 * Inclui atributos essenciais como identificador e descrição do local.
 */
public class Place {
    private String id; // Identificador único do local.
    private String description; // Descrição breve do local.

    /**
     * Constrói uma nova instância de Place com os parâmetros especificados.
     *
     * @param id O identificador único do local.
     * @param description Descrição do local.
     */
    public Place(String id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters e Setters

    /**
     * Retorna o identificador único do local.
     *
     * @return O identificador do local.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador único do local.
     *
     * @param id O novo identificador do local.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna a descrição do local.
     *
     * @return A descrição do local.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do local.
     *
     * @param description A nova descrição do local.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
