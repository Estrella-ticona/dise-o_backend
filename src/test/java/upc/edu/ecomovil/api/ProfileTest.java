package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import upc.edu.ecomovil.api.iam.domain.model.aggregates.User;
import upc.edu.ecomovil.api.user.domain.model.aggregates.Profile;

public class ProfileTest {
    @Test
    public void testProfileUpdateEmail() {
        // Arrange
        User user = new User("juanito1234", "password123", "juan_asdasd@hotmail.com");
        Profile profile = new Profile(user, "Juan", "Pérez", "juan_asdasd@hotmail.com", "987654321", "12345678901");

        // Act
        profile.updateEmail("juan_perez1998@hotmail.com");

        // Assert
        assertEquals("juan_perez1998@hotmail.com", profile.getEmail(),
                "El correo electronico se actualizó correctamente");

    }

    @Test
    public void testProfileUpdateFullName() {
        // Arrange
        User user = new User("juanito1234", "password123", "juan_asdasd@hotmail.com");
        Profile profile = new Profile(user, "Juan", "Pérez", "juan_asdasd@hotmail.com", "987654321", "12345678901");

        // Act
        profile.updateName("Oscar", "Gonzales");

        // Assert
        assertEquals("Oscar Gonzales", profile.getFullName(), "El nombre se actualizó correctamente");

    }
}
