package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.entity.ItemEntity;
import lk.ijse.back_end.service.impl.ItemServiceImpl;
import lk.ijse.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    private final ItemServiceImpl itemService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("save Item");
        itemService.saveItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<>(200,"Item Saved",null), HttpStatus.CREATED);

    }
    @PutMapping
    public ResponseEntity<APIResponse<String>> UpdateItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("Update Item");
        itemService.updateItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<> (200,"Item Updated",null),HttpStatus.OK);

    }
    @DeleteMapping
    public ResponseEntity<APIResponse<String>> DeleteItem(@RequestBody ItemDTO itemDTO) {
        System.out.println("Delete Item");
        itemService.deleteItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<> (200,"Item Deleted",null),HttpStatus.OK);

    }
    @GetMapping
    public List<ItemEntity> getAllItems() {
        return itemService.getAllItems();

    }
}
