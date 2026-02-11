package lk.ijse.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDTO {
    private String i_id;
    private String i_name;
    private String price;
    private String quantity;

}
