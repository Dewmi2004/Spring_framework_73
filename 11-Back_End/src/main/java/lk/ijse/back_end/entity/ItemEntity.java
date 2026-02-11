package lk.ijse.back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity {
    @Id
    private String i_id;

    private String i_name;
    private String price;
    private String quantity;
}
