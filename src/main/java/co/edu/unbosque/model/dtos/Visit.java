package co.edu.unbosque.model.dtos;
/**
 * Objeto que contiene los parametros de la tabla Visit.
 */
public final class Visit {
    private final int visit_id;
    private final String created_at, type, description, vet_id;
    private final int pet_id;

    public Visit(int visit_id, String created_at, String type, String description, String vet_id, int pet_id) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.vet_id = vet_id;
        this.pet_id = pet_id;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visit_id=" + visit_id +
                ", created_at='" + created_at + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", vet_id='" + vet_id + '\'' +
                ", pet_id=" + pet_id +
                '}';
    }
}
