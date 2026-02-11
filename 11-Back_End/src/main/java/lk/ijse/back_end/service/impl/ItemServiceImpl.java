package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.repository.ItemRepository;
import lk.ijse.back_end.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemRepository.save(new ItemEntity(itemDTO.getI_id(), itemDTO.getI_name(),itemDTO.getPrice(),itemDTO.getQuantity()));

    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        itemRepository.save(new ItemEntity(itemDTO.getI_id(), itemDTO.getI_name(),itemDTO.getPrice(),itemDTO.getQuantity()));

    }

    @Override
    public void deleteItem(ItemDTO itemDTO) {
        itemRepository.deleteById(itemDTO.getI_id());
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }
}
