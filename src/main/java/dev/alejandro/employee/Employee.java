package dev.alejandro.employee;

import java.io.Serializable;
import java.util.Objects;

public record Employee(ID id, Name name, Address address, Sector sector) implements Serializable {
    public Employee addAddress(Address address) {
        Objects.requireNonNull(address, "Address is null");
        return new Employee(this.id, this.name, address, this.sector);
    }

    public Employee addSector(Sector sector) {
        Objects.requireNonNull(sector, "Sector is null");
        return new Employee(this.id, this.name, this.address, sector);
    }
}
