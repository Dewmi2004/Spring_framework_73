//package lk.ijse.back_end.service.impl;
//
//import lk.ijse.back_end.dto.OrderDTO;
//import lk.ijse.back_end.entity.CustomerEntity;
//import lk.ijse.back_end.entity.ItemEntity;
//import lk.ijse.back_end.entity.OrderEntity;
//import lk.ijse.back_end.repository.CustomerRepository;
//import lk.ijse.back_end.repository.ItemRepository;
//import lk.ijse.back_end.repository.OrderRepository;
//import lk.ijse.back_end.service.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepository orderRepository;
//    private final ItemRepository itemRepository;
//    private final CustomerRepository customerRepository;
//
////    @Override
////    public void setOrderId(String orderId) {
////
////    }
////
////    @Override
////    public void setCustomerName(String customerName) {
////
////    }
////
////    @Override
////    public void setItemName(String ItemName) {
////
////    }
////
////    @Override
////    public void setItemPrice(String ItemPrice) {
////
////    }
////
////    @Override
////    public void setItemQuantity(String quantity) {
////
////    }
//    @Transactional
//    @Override
//    public void saveOrder(OrderDTO orderDTO) {
//        if(!orderRepository.existsById(orderDTO.getOrderId())) {
//            throw new RuntimeException("Order Not Found");
//        }
//
//        if(!customerRepository.existsById(orderDTO.getCustomerId())) {
//            throw new RuntimeException("Customer Not Found");
//        }
//        if(!itemRepository.existsById(orderDTO.getItemId())) {
//            throw new RuntimeException("Item Not Found");
//        }
//
//        CustomerEntity customerId = customerRepository.findById(orderDTO.getCustomerId()).get();
//        ItemEntity itemId= itemRepository.findById(orderDTO.getItemId()).get();
//        ItemEntity itemUnitPrice = itemRepository.findById(itemId.getPrice()).get();
//        ItemEntity itemAvailable = itemRepository.findById(itemId.getQuantity()).get();
//    }
//
//    @Override
//    public void updateOrder(OrderDTO orderDTO) {
//    }
//
//    @Override
//    public void deleteOrder(OrderDTO orderDTO) {
//        orderRepository.deleteById(orderDTO.getOrderId());
//    }
//
//    @Override
//    public List<OrderEntity> getAllOrders() {
//        return orderRepository.findAll();
//    }
//}
