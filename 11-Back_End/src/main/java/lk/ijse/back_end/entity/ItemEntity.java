package lk.ijse.back_end.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_id")
    private Integer i_id;

    @Column(name = "i_name", nullable = false)
    private String i_name;

    @Column(name = "price")
    private String price;

    @Column(name = "quantity")
    private String quantity;
}