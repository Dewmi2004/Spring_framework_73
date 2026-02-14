package lk.ijse.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String customerId;
    private String ItemId;
    private String ItemUnitPrice;
    private String ItemQty;
}
