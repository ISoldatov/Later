package ru.practicum.item;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getItems(long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Item addNewItem(long userId, Item item) {
        item.setUserId(userId);
        return repository.save(item);
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}
