package org.roberto.diaz.drone.persistence;

import org.roberto.diaz.drone.model.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roberto Díaz
 */
public class PropertyPersistenceMock {

    public static List<Property> getProperties() {
        return _properties;
    }

    private static List<Property> _properties;

    public static void generateScenario() {
        _properties = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                _properties.add(new Property(i, j));
            }
        }
    }

}
