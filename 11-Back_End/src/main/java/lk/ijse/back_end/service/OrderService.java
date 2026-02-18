package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.CartDTO;
import lk.ijse.back_end.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void placeOrder(CartDTO cartDTO);

}
