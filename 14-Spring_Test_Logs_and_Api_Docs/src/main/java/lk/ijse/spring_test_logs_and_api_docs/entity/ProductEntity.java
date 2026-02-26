package lk.ijse.spring_test_logs_and_api_docs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    private int id;
    private String name;
    private String description;
}
