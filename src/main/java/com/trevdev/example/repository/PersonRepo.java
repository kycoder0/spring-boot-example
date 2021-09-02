package com.trevdev.example.repository;

import com.trevdev.example.dao.PersonDataAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this gives us functionality to communicate and store/retrieve data from our postgres db
@Repository
public interface PersonRepo extends JpaRepository<PersonDataAccess, Integer> {}
