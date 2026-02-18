package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.OrderDTO;
import lk.ijse.back_end.service.OrderService;
import lk.ijse.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public APIResponse<String> saveOrder(@RequestBody OrderDTO orderDTO) {

        orderService.saveOrder(orderDTO);

        return new APIResponse<>(200, "Order Saved Successfully", null);
    }

    @PutMapping
    public APIResponse<String> updateOrder(@RequestBody OrderDTO orderDTO) {

        orderService.updateOrder(orderDTO);

        return new APIResponse<>(200, "Order Updated Successfully", null);
    }

    @DeleteMapping("/{id}")
    public APIResponse<String> deleteOrder(@PathVariable Integer id) {

        orderService.deleteOrder(id);

        return new APIResponse<>(200, "Order Deleted Successfully", null);
    }

    @GetMapping
    public APIResponse<List<OrderDTO>> getAllOrders() {

        return new APIResponse<>(
                200,
                "Order List Retrieved Successfully",
                orderService.getAllOrders()
        );
    }
}
