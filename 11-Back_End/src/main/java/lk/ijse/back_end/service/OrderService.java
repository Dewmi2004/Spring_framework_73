package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.CartDTO;

public interface OrderService {
    void placeOrder(CartDTO cartDTO);
}
