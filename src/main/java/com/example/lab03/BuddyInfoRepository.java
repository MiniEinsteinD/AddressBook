package com.example.lab03;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    Optional<BuddyInfo> findById(Long id);
    Iterable<BuddyInfo> findAll();
}
