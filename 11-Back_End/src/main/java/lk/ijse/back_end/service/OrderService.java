package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    void saveOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void deleteOrder(Integer orderId);

    List<OrderDTO> getAllOrders();
}
