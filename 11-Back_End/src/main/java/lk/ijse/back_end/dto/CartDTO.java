package lk.ijse.back_end.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Integer customerId;
    private List<CartItemDTO> items;
}
