package com.study.TddCleanArch.domain.repository;

import java.util.Optional;

import com.study.TddCleanArch.domain.entity.Item;

public interface ItemRepository {
    Optional<Item> findById(String idItem);

}
