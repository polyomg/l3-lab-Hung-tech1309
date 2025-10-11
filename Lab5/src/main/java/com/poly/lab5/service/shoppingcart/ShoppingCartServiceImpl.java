package com.poly.lab5.service.shoppingcart;

import com.example.demo.model.DB;
import com.example.demo.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // dùng LinkedHashMap để giữ thứ tự thêm (tùy chọn)
    private final Map<Integer, Item> map = new LinkedHashMap<>();

    @Override
    public Item add(Integer id) {
        if (!DB.items.containsKey(id)) return null;
        Item item = map.get(id);
        if (item == null) {
            Item fromDb = DB.items.get(id);
            Item newItem = new Item(fromDb.getId(), fromDb.getName(), fromDb.getPrice(), 1);
            map.put(id, newItem);
            return newItem;
        } else {
            item.setQty(item.getQty() + 1);
            return item;
        }
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item == null) return null;
        if (qty <= 0) {
            map.remove(id);
            return null;
        }
        item.setQty(qty);
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
    }
}
