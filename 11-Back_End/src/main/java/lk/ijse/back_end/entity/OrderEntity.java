package lk.ijse.back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String orderId;

    private String customerId;
    private String ItemId;
    private String ItemUnitPrice;
    private String ItemQty;
}
