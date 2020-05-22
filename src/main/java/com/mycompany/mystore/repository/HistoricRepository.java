package com.mycompany.mystore.repository;

import com.mycompany.mystore.model.Historic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Repository
public interface HistoricRepository extends CrudRepository<Historic, Long> {

    List findByFromItemId(Long fromItemId);

    List findByToItemId(Long toItemId);
}