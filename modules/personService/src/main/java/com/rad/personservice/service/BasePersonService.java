package com.rad.personservice.service;

import java.util.List;

public interface BasePersonService<T> {

    public T findById(long id);
    public List<T> findAll();
    public void create(T t);
    public void update(T t);
    public void deleteById(long id);
}
