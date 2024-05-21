package dev.alejandro.employee;

import java.io.Serializable;

public record Name(String name) implements Serializable {

    public boolean isValid() {
        return name != null
                && !name.trim().isEmpty()
                && name.trim().length() < 30;
    }
}
