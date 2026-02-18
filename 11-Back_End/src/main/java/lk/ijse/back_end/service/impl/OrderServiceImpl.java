package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.OrderDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.entity.OrderEntity;
import lk.ijse.back_end.repository.CustomerRepository;
import lk.ijse.back_end.repository.ItemRepository;
import lk.ijse.back_end.repository.OrderRepository;
import lk.ijse.back_end.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveOrder(OrderDTO orderDTO) {

        // ✅ NULL VALIDATION (Prevents "id must not be null")
        if (orderDTO == null) {
            throw new RuntimeException("Order data is missing");
        }

        if (orderDTO.getCustomerId() == null) {
            throw new RuntimeException("Customer ID cannot be null");
        }

        if (orderDTO.getItemId() == null) {
            throw new RuntimeException("Item ID cannot be null");
        }

        if (orderDTO.getItemQty() == null || orderDTO.getItemQty() <= 0) {
            throw new RuntimeException("Invalid item quantity");
        }

        // ✅ Check Customer
        CustomerEntity customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        // ✅ Check Item
        ItemEntity item = itemRepository.findById(orderDTO.getItemId())
                .orElseThrow(() -> new RuntimeException("Item Not Found"));

        // ✅ Convert quantity (String → Integer)
        Integer availableQty;
        try {
            availableQty = Integer.parseInt(item.getQuantity());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid item quantity format in database");
        }

        Integer orderedQty = orderDTO.getItemQty();

        if (availableQty < orderedQty) {
            throw new RuntimeException("Not enough stock available");
        }

        // ✅ Convert price (String → Double)
        Double unitPrice;
        try {
            unitPrice = Double.parseDouble(item.getPrice());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid item price format in database");
        }

        // ✅ Map DTO → Entity
        OrderEntity order = modelMapper.map(orderDTO, OrderEntity.class);
        order.setCustomerId(customer.getId());   // use correct getter
        order.setItemId(item.getI_id());         // use correct getter
        order.setItemUnitPrice(unitPrice);

        orderRepository.save(order);

        // ✅ Reduce stock
        Integer newQty = availableQty - orderedQty;
        item.setQuantity(String.valueOf(newQty));
        itemRepository.save(item);
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {

        if (orderDTO.getOrderId() == null) {
            throw new RuntimeException("Order ID cannot be null");
        }

        OrderEntity existingOrder = orderRepository.findById(orderDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        existingOrder.setItemQty(orderDTO.getItemQty());
        existingOrder.setItemUnitPrice(orderDTO.getItemUnitPrice());

        orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Integer orderId) {

        if (orderId == null) {
            throw new RuntimeException("Order ID cannot be null");
        }

        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order Not Found");
        }

        orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }
}
