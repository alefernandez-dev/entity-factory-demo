package dev.alejandro.employee;

import dev.alejandro.util.Result;

import java.util.HashSet;
import java.util.Set;

public final class EmployeeFactory {
    private EmployeeFactory() {
    }

    public static Result<Set<String>, Employee> create(ID id, Name name, Address address, Sector sector) {

        Set<String> messages = new HashSet<>();

        if(id != null) {
            if(!id.isValid()) {
                messages.add("Id has a invalid state [Possible causes: Id null]");
            }
        }else {
            messages.add("Id is null");
        }
        if(name != null) {
            if(!name.isValid()) {
                messages.add("Name has a invalid state [Possible causes: Name null, empty or has more than 30 characters]");
            }
        }else {
            messages.add("Name is null");
        }
        if(address != null) {
            if(!address.isValid()) {
                messages.add("Address has a invalid state [Possible causes: Address null, empty or more has more than 20 characters. Number null or less than 0. City null, empty or has more than 20 characters]");
            }
        } else {
            messages.add("Address is null");
        }
        if(sector != null) {
            if(!sector.isValid()) {
                messages.add("Sector has a invalid state [Possible causes: Sector null, empty or has more than 20 characters]");
            }
        }else {
            messages.add("Sector is null");
        }

        if(!messages.isEmpty()) {
            return Result.failure(messages);
        }

        return Result.success(new Employee(id, name, address, sector));

    }

    public static Result<Set<String>, Employee> create(ID id, Name name, Sector sector) {
        Set<String> messages = new HashSet<>();

        if(id != null) {
            if(!id.isValid()) {
                messages.add("Id has a invalid state [Possible causes: Id null]");
            }
        }else {
            messages.add("Id is null");
        }
        if(name != null) {
            if(!name.isValid()) {
                messages.add("Name has a invalid state [Possible causes: Name null, empty or has more than 30 characters]");
            }
        }else {
            messages.add("Name is null");
        }
        if(sector != null) {
            if(!sector.isValid()) {
                messages.add("Sector has a invalid state [Possible causes: Sector null, empty or has more than 20 characters]");
            }
        }else {
            messages.add("Sector is null");
        }

        if(!messages.isEmpty()) {
            return Result.failure(messages);
        }

        return Result.success(new Employee(id, name, null, sector));

    }

    public static Result<Set<String>, Employee> create(ID id, Name name) {
        Set<String> messages = new HashSet<>();

        if(id != null) {
            if(!id.isValid()) {
                messages.add("Id has a invalid state [Possible causes: Id null]");
            }
        }else {
            messages.add("Id is null");
        }
        if(name != null) {
            if(!name.isValid()) {
                messages.add("Name has a invalid state [Possible causes: Name null, empty or has more than 30 characters]");
            }
        }else {
            messages.add("Name is null");
        }

        if(!messages.isEmpty()) {
            return Result.failure(messages);
        }

        return Result.success(new Employee(id, name, null, null));

    }

}
