package lk.ijse.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer orderId;
    private Integer customerId;
    private Integer itemId;
    private Double itemUnitPrice;
    private Integer itemQty;
}