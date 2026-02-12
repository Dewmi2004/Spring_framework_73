//package lk.ijse.back_end.controller;
//
//import lk.ijse.back_end.dto.ItemDTO;
//import lk.ijse.back_end.dto.OrderDTO;
//import lk.ijse.back_end.entity.ItemEntity;
//import lk.ijse.back_end.entity.OrderEntity;
//import lk.ijse.back_end.service.impl.OrderServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/order")
//@CrossOrigin
//public class OrderController {
//
//
//    private final OrderServiceImpl orderService;
//
//    @PostMapping
//    public void saveOrder(@RequestBody OrderDTO orderDTO) {
//        System.out.println("save Order");
//        orderService.saveOrder(orderDTO);
//    }
//    @PutMapping
//    public void UpdateOrder(@RequestBody OrderDTO orderDTO) {
//        System.out.println("Update Order");
//        orderService.updateOrder(orderDTO);
//    }
//    @DeleteMapping
//    public void DeleteOrder(@RequestBody OrderDTO orderDTO) {
//        System.out.println("Delete Order");
//        orderService.deleteOrder(orderDTO);
//    }
//    @GetMapping
//    public List<OrderEntity> getAllOrders() {
//        return orderService.getAllOrders();
//
//    }
////    @GetMapping
////    public void setOrderId(@RequestBody OrderDTO orderDTO) {
////        orderService.setOrderId(orderDTO.getOrderId());
////    }
////    @GetMapping
////    public void setCustomerName(@RequestBody OrderDTO orderDTO) {
////        orderService.setCustomerName(orderDTO.getCustomerName());
////    }
////    @GetMapping
////    public void setItemName(@RequestBody OrderDTO orderDTO) {
////        orderService.setItemName(orderDTO.getItemName());
////    }
////    @GetMapping
////    public void setItemPrice(@RequestBody OrderDTO orderDTO) {
////        orderService.setItemPrice(orderDTO.getItemUnitPrice());
////    }
////    @GetMapping
////    public void setItemQuantity(@RequestBody OrderDTO orderDTO) {
////        orderService.setItemQuantity(orderDTO.getItemQty());
////    }
//}
