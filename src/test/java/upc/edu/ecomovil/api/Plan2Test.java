package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import upc.edu.ecomovil.api.plan2.domain.model.aggregates.Plan2;

public class Plan2Test {
    @Test
    public void testPlan2UpdateDetails() {
        // Arrange
        Plan2 plan = new Plan2("Plan Básico", "Acceso limitado a funciones", 29.99);

        // Act
        plan.updateDetails("Plan Premium", "Acceso completo a todas las funciones", 49.99);

        // Assert
        assertEquals("Plan Premium", plan.getName(), "El plan se actualizó correctamente");
        assertEquals("Acceso completo a todas las funciones", plan.getDescription(),
                "La descripcion del plan se actualizó correctamente");

        assertEquals(49.99, plan.getPrice(), 0.01, "El precio del plan se actualizó correctamente");

    }
}
