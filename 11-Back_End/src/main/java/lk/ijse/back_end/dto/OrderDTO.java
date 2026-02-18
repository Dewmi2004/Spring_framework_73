package lk.ijse.back_end.dto;

import lombok.*;

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
