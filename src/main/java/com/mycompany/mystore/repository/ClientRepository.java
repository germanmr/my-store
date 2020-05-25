package com.mycompany.mystore.repository;


import com.mycompany.mystore.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
//public interface ClientRepository extends CrudRepository {

    Client findByExternalId(String externalId);
}