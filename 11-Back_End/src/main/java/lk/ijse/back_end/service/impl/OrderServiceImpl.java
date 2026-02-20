package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.CartDTO;
import lk.ijse.back_end.dto.CartItemDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.entity.OrderEntity;
import lk.ijse.back_end.entity.OrderItemEntity;
import lk.ijse.back_end.exception.CustomerNotFoundException;
import lk.ijse.back_end.exception.InsufficientStockException;
import lk.ijse.back_end.exception.ItemNotFoundException;
import lk.ijse.back_end.repository.CustomerRepository;
import lk.ijse.back_end.repository.ItemRepository;
import lk.ijse.back_end.repository.OrderRepository;
import lk.ijse.back_end.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void placeOrder(CartDTO cartDTO) {

        if (cartDTO == null || cartDTO.getCustomerId() == null) {
            throw new IllegalArgumentException("Customer ID is required");
        }

        CustomerEntity customer = customerRepository
                .findById(cartDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer not found with ID: " + cartDTO.getCustomerId()));

        // Create ONE order header for the whole cart
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);

        List<OrderItemEntity> orderItems = new ArrayList<>();

        for (CartItemDTO cartItem : cartDTO.getItems()) {

            if (cartItem.getItemId() == null || cartItem.getQty() == null) {
                throw new IllegalArgumentException("Invalid cart item — itemId and qty are required");
            }

            ItemEntity item = itemRepository
                    .findById(cartItem.getItemId())
                    .orElseThrow(() -> new ItemNotFoundException(
                            "Item not found with ID: " + cartItem.getItemId()));

            Integer availableQty;
            try {
                availableQty = Integer.parseInt(item.getQuantity());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid quantity format for item: " + item.getI_name());
            }

            if (availableQty < cartItem.getQty()) {
                throw new InsufficientStockException(
                        "Not enough stock for item: " + item.getI_name() +
                                ". Available: " + availableQty + ", Requested: " + cartItem.getQty());
            }

            Double unitPrice;
            try {
                unitPrice = Double.parseDouble(item.getPrice());
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid price format for item: " + item.getI_name());
            }

            // Create one order item line per cart item
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setOrder(order);
            orderItem.setItem(item);
            orderItem.setItemUnitPrice(unitPrice);
            orderItem.setItemQty(cartItem.getQty());
            orderItems.add(orderItem);

            // Reduce Stock
            int newQty = availableQty - cartItem.getQty();
            item.setQuantity(String.valueOf(newQty));
            itemRepository.save(item);
        }

        // Attach all items to the order and save ONCE — cascade saves all order items
        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }
}