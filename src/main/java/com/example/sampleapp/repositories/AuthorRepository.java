package com.example.sampleapp.repositories;

import com.example.sampleapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
