package com.example.lab03;


import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, String> {

    AddressBook findByOwner(String owner);
    Iterable<AddressBook> findAll();
}
