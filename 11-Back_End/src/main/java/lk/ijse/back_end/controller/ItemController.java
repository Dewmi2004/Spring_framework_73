package lk.ijse.back_end.controller;

import lk.ijse.back_end.dto.ItemDTO;
import lk.ijse.back_end.service.ItemService;
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

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<APIResponse<String>> saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Item Saved", null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<APIResponse<String>> updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Item Updated", null), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<APIResponse<String>> deleteItem(@RequestBody ItemDTO itemDTO) {
        itemService.deleteItem(itemDTO);
        return new ResponseEntity<>(new APIResponse<>(200, "Item Deleted", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ItemDTO>>> getAllItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return new ResponseEntity<>(new APIResponse<>(200, "Success", items), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ItemDTO>> getItemById(@PathVariable Integer id) {
        ItemDTO item = itemService.getItemById(id);
        return new ResponseEntity<>(new APIResponse<>(200, "Success", item), HttpStatus.OK);
    }
}