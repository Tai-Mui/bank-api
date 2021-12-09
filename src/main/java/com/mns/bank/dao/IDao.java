package com.mns.bank.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

	Optional<T> get(long id);
    
    List<T> getAll();
    
    Long save(T t);
    
    void update(T t);
    
    void delete(T t);
}
