package org.roberto.diaz.drone;

import org.roberto.diaz.drone.model.Property;
import org.roberto.diaz.drone.persistence.PropertyPersistenceMock;
import org.roberto.diaz.drone.service.PropertyService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Roberto Díaz
 */
public class DroneManager {

    public static void main(String [ ] args) {
        PropertyPersistenceMock.generateScenario();

        DroneManager droneManager = new DroneManager();

        droneManager.init();
    }

    private void init() {
        Scanner inputReader = new Scanner(System.in);

        String coordX = null;
        String coordY = null;

        do {
            System.out.println("Introduce coordenada X:");

            coordX = inputReader.nextLine();

            System.out.println("Introduce coordenada Y:");

            coordY = inputReader.nextLine();
        }
        while (!isValidInput(coordX, coordY));

        System.out.println(
            "Correcto, ahora introduce el rango de busqueda del dron:");

        String range = null;

        do {
            range = inputReader.nextLine();
        }
        while (!isValidInput(range));

        List<Property> visitableProperties = _propertyService.getVisitedProperties(
                Double.valueOf(coordX), Double.valueOf(coordY), Integer.valueOf(range));

        System.out.println(
            "El dron debe visitar un total de " +  visitableProperties.size() +
                " propiedades. Son las siguientes:");

        visitableProperties.forEach(p -> System.out.println(p.toString()));
    }

    private static boolean isValidInput(String... coords) {
        try {
            Arrays.asList(coords).forEach(
                    (coord) -> Integer.valueOf(coord));
        }
        catch (Exception e) {
            System.out.println("Error vuelve a introducir el valor en forma numerica:");

            return false;
        }

        return true;
    }

    private PropertyService _propertyService = new PropertyService();

}
