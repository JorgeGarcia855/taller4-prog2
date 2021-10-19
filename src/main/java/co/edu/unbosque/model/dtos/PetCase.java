package co.edu.unbosque.model.dtos;

public final class PetCase {
    private final String created_at, type, description;
    private final int pet_id;

    public PetCase(String created_at, String type, String description, int pet_id) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getPet_id() {
        return pet_id;
    }
}
