package lk.ijse.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    private String orderId;
    private String customerName;
    private String ItemName;
    private String ItemUnitPrice;
    private String ItemQty;
}
