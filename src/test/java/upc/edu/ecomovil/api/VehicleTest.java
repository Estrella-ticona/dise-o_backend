package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import upc.edu.ecomovil.api.vehicles.domain.model.aggregates.Vehicle;

public class VehicleTest {
        @Test
        public void testVehicleUpdateDetails() {
                // Arrange
                Vehicle vehicle = new Vehicle(
                                "Sedan", // type
                                "Toyota Corolla", // name
                                2022, // year
                                4, // review
                                150.0, // pricerent
                                25000.0, // pricesell
                                true, // isAvailable
                                "https://autoland.com.pe/wp-content/uploads/2023/10/tipo-auto-coupe-autoland.png", // imageUrl
                                -12.0464f, // lat
                                -77.0428f, // lng
                                "Auto en excelente estado, poco uso" // description
                );

                // Act
                vehicle.updateDetails("Honda", "Civic", 2021);

                // Assert
                assertEquals("Honda", vehicle.getType(), "El fabricante se actualizó correctamente");
                assertEquals("Civic", vehicle.getName(), "El nombre se actualizó correctamente");
                assertEquals(Integer.valueOf(2021), vehicle.getYear(), "El año se actualizó correctamente");

        }

        @Test
        public void testVehicleUpdatePrices() {
                // Arrange
                Vehicle vehicle = new Vehicle(
                                "Sedan", // type
                                "Toyota Corolla", // name
                                2022, // year
                                4, // review
                                150.0, // pricerent
                                25000.0, // pricesell
                                true, // isAvailable
                                "https://autoland.com.pe/wp-content/uploads/2023/10/tipo-auto-coupe-autoland.png", // imageUrl
                                -12.0464f, // lat
                                -77.0428f, // lng
                                "Auto en excelente estado, poco uso" // description
                );

                // Act
                vehicle.updatePrices(200.0, 30000.0);

                // Assert
                assertEquals(Double.valueOf(200.0),
                                vehicle.getPriceRent(), "El precio de renta se actualizó correctamente");
                assertEquals(Double.valueOf(30000.0),
                                vehicle.getPriceSell(), "El precio de venta se actualizó correctamente");
        }

}
