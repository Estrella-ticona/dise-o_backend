package upc.edu.ecomovil.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import upc.edu.ecomovil.api.iam.domain.model.aggregates.User;

public class UserTest {
    @Test
    public void testUserUpdateUsername() {
        // Arrange
        User user = new User("juanito1234", "password123", "juan_asdasd@hotmail.com");

        // Act
        user.setUsername("juan1234");

        // Assert
        assertEquals("juan1234", user.getUsername(), "El nombre de usuario se actualizó correctamente");
    }

}
