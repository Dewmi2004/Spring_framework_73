package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.CartDTO;
import lk.ijse.back_end.service.OrderService;
import lk.ijse.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public APIResponse<String> placeOrder(@RequestBody CartDTO cartDTO) {

        orderService.placeOrder(cartDTO);

        return new APIResponse<>(200, "Order Placed Successfully", null);
    }
}
