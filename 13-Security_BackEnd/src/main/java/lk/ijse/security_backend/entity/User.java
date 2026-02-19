package lk.ijse.security_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder //
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
