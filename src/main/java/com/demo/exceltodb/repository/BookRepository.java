package com.demo.exceltodb.repository;


import com.demo.exceltodb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
