package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private List<String> roles;
    private String token;
}
