package upc.edu.ecomovil.api.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String username, String password, String email, List<String> roles) {
}