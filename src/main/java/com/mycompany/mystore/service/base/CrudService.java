package com.mycompany.mystore.service.base;

import java.util.Set;

public interface CrudService<T, PK> {

    T getById(PK pk);

    Set<T> getAll();

    Set<T> getByFilter(String filter);
}
