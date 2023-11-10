package lk.ijse.todo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDto {
    private String username;
    private String password;
}
