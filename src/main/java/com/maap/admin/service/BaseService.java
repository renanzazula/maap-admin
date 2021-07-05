package com.maap.admin.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    T save(T obj);

    T update(UUID uuid, T objToUpdate) throws Exception;

    void deleteById(UUID uuid);

    List<T> findAll();

    T getBy(UUID uuid) throws Exception;

}
