package lk.ijse.todo.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class SignUpDto {
    private String email;
    private String username;
    private String password;
}
