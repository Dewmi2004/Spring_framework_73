package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.service.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    private final ItemServiceImpl itemService;

    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("save Item");
        itemService.saveItem(itemDTO);
    }
    @PutMapping
    public void UpdateItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("Update Item");
        itemService.updateItem(itemDTO);
    }
    @DeleteMapping
    public void DeleteItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("Delete Item");
        itemService.deleteItem(itemDTO);
    }
    @GetMapping
    public List<ItemEntity> getAllItems() {
        return itemService.getAllItems();

    }
}
