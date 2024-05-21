package dev.alejandro.employee;

import java.io.Serializable;
import java.util.UUID;

public record ID(UUID id) implements Serializable {

    public boolean isValid() {
        return id != null;
    }

}
