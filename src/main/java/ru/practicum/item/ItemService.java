package ru.practicum.item;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ItemService {

    Item addNewItem(long userId, Item item);

    List<Item> getItems(long userId);

    void deleteItem(long userId, long itemId);
}
