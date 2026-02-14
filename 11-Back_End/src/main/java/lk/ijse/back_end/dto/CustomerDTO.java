package lk.ijse.back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @NotNull
    private Integer id;
    @NotBlank(message = "Customer name is mandatory")
    private String name;
    private String age;
    @NotBlank(message = "Customer address is mandatory")
    @Size(min = 10,message = "customer address should be at least 10 characters")
    private String address;

}
