package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceImpl itemServiceImpl;

    @GetMapping
    public List<Item> get(@RequestHeader("X-Later-User-Id") long userId) {
        return itemServiceImpl.getItems(userId);
    }

    @PostMapping
    public Item add(@RequestHeader("X-Later-User-Id") Long userId,
                    @RequestBody Item item) {
        return itemServiceImpl.addNewItem(userId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable long itemId) {
        itemServiceImpl.deleteItem(userId, itemId);
    }
}
