package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.OrderDTO;
import lk.ijse.back_end.entity.OrderEntity;

import java.util.List;

public interface OrderService {
//    public void setOrderId(String orderId);
//    public void setCustomerName(String customerName);
//    public void setItemName(String ItemName);
//    public void setItemPrice(String ItemPrice);
//    public void setItemQuantity(String quantity);
    public void saveOrder(OrderDTO orderDTO);
    public void updateOrder(OrderDTO orderDTO);
    public void deleteOrder(OrderDTO orderDTO);
    public List<OrderEntity> getAllOrders();
}
