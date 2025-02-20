package com.study.TddCleanArch.infra.repository.memory;

import java.util.List;
import java.util.Optional;

import com.study.TddCleanArch.domain.entity.Item;
import com.study.TddCleanArch.domain.repository.ItemRepository;

public class InMemoryItemRepository implements ItemRepository {
    List<Item> items;

    public InMemoryItemRepository() {
        this.items = List.of(
                new Item(1, "Música", "CD", 30.00),
                new Item(2, "Vídeo", "DVD", 50.00),
                new Item(3, "Vídeo", "VHS", 10.00));
    }

    @Override
    public Optional<Item> findById(String idItem) {
        for (Item item : this.items) {
            if (item.id().toString().equals(idItem)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
