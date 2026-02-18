package lk.ijse.back_end.repository;

import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderEntity,Integer> {
}
