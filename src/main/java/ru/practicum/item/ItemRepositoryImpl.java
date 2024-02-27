package ru.practicum.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ItemRepositoryImpl implements ItemRepository {

    private final Map<Long, Item> storage = new HashMap<>();

    private final AtomicLong count = new AtomicLong(0);


    @Override
    public List<Item> findByUserId(long userId) {
        return storage.values().stream()
                .filter(i -> i.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Item save(Item item) {
        item.setId(count.incrementAndGet());
        storage.putIfAbsent(item.getId(), item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Item item = storage.get(itemId);
        if (item != null && item.getUserId().equals(userId)) {
            storage.remove(itemId);
        }
    }
}
