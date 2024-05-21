package dev.alejandro;

import dev.alejandro.employee.*;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var result1 = EmployeeFactory.create(new ID(UUID.randomUUID()), new Name("Roberto Fernández"));
        var result2 = EmployeeFactory.create(new ID(UUID.randomUUID()), new Name("Ángel Gómez"), new Address(" ", 2134, "Corrientes"), new Sector("Sistemas"));
        var result3 = EmployeeFactory.create(new ID(UUID.randomUUID()), new Name("Marcela Pérez"), new Sector("Contabilidad"));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
