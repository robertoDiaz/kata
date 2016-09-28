package org.roberto.diaz.drone.service;

import org.roberto.diaz.drone.model.Property;
import org.roberto.diaz.drone.persistence.PropertyPersistenceMock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roberto Díaz
 */
public class PropertyService {

    public List<Property> getVisitedProperties(
            double coordX, double coordY, int range) {

        Property baseProperty = getProperty(coordX, coordY);

        List<Property> properties = getAllProperties();

        return properties.stream().filter(
                prop-> _isInRange(prop, baseProperty, range)
            ).collect(Collectors.toList());
    }

    public Property getProperty(double coordX, double coordY) {
        List<Property> properties = getAllProperties();

        return properties.stream().filter(
                p -> (p.getXCoord() == (int)coordX) &&
                    (p.getYCoord() == (int)coordY)
            ).findFirst().get();
    }

    public List<Property> getAllProperties() {
        return PropertyPersistenceMock.getProperties();
    }

    private boolean _isInRange(
        Property currentProperty, Property baseProperty, int range) {

        return currentProperty.getXCoord() < (baseProperty.getXCoord() + range) &&
                currentProperty.getXCoord() > (baseProperty.getXCoord() - range) &&
                currentProperty.getYCoord() < (baseProperty.getYCoord() + range) &&
                currentProperty.getYCoord() > (baseProperty.getYCoord() - range);
    }

}
