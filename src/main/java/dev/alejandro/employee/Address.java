package dev.alejandro.employee;

import java.io.Serializable;

public record Address(String address, Integer number, String city) implements Serializable {
    public boolean isValid() {
        if(address != null) {
            if(address.trim().isEmpty() || address.trim().length() > 20) {
                return false;
            }
        }else {
            return false;
        }
        if(number != null) {
            if(number <= 0) {
                return false;
            }
        }else {
            return false;
        }
        if(city != null) {
            return !city.trim().isEmpty() && city.trim().length() <= 20;
        }else {
            return false;
        }
    }
}
