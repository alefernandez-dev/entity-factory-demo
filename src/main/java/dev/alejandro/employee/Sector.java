package dev.alejandro.employee;

import java.io.Serializable;

public record Sector(String sector) implements Serializable {

    public boolean isValid() {
        return sector != null
                && !sector.trim().isEmpty()
                && sector.trim().length() < 20;
    }

}
