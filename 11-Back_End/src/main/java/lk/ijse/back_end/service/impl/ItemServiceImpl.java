package lk.ijse.back_end.service.impl;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.repository.ItemRepository;
import lk.ijse.back_end.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity entity = modelMapper.map(itemDTO, ItemEntity.class);
        itemRepository.save(entity);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        ItemEntity existingItem = itemRepository
                .findById(itemDTO.getI_id())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Item not found"
                ));

        modelMapper.map(itemDTO, existingItem);
        itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(ItemDTO itemDTO) {
        if (!itemRepository.existsById(itemDTO.getI_id())) {
            throw new RuntimeException("Item not found");
        }
        itemRepository.deleteById(itemDTO.getI_id());
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> list = itemRepository.findAll();
        return modelMapper.map(list, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    @Override
    public ItemDTO getItemById(Integer id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        return modelMapper.map(item, ItemDTO.class);
    }
}