package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.CartDTO;
import lk.ijse.back_end.dto.CartItemDTO;
import lk.ijse.back_end.entity.CustomerEntity;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.entity.OrderEntity;
import lk.ijse.back_end.repository.CustomerRepository;
import lk.ijse.back_end.repository.ItemRepository;
import lk.ijse.back_end.repository.OrderRepository;
import lk.ijse.back_end.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new RuntimeException("Customer ID is required");
        }

        CustomerEntity customer = customerRepository
                .findById(cartDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        for (CartItemDTO cartItem : cartDTO.getItems()) {

            if (cartItem.getItemId() == null || cartItem.getQty() == null) {
                throw new RuntimeException("Invalid cart item");
            }

            ItemEntity item = itemRepository
                    .findById(cartItem.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item Not Found"));

            Integer availableQty;
            try {
                availableQty = Integer.parseInt(item.getQuantity());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format in DB");
            }

            if (availableQty < cartItem.getQty()) {
                throw new RuntimeException("Not enough stock for item: " + item.getI_name());
            }

            Double unitPrice;
            try {
                unitPrice = Double.parseDouble(item.getPrice());
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid price format in DB");
            }

            // Save Order Row (One row per item)
            OrderEntity order = new OrderEntity();
            order.setCustomer(customer);       // set the full CustomerEntity object
            order.setItem(item);               // set the full ItemEntity object
            order.setItemUnitPrice(unitPrice);
            order.setItemQty(cartItem.getQty());

            orderRepository.save(order);

            // Reduce Stock
            int newQty = availableQty - cartItem.getQty();
            item.setQuantity(String.valueOf(newQty));
            itemRepository.save(item);
        }
    }
}