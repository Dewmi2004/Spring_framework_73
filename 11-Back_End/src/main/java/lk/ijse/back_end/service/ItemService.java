package lk.ijse.back_end.service;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    public void saveItem(ItemDTO itemDTO);
    public void updateItem(ItemDTO itemDTO);
    public void deleteItem(ItemDTO itemDTO);
    public List<ItemEntity> getAllItems();
}
