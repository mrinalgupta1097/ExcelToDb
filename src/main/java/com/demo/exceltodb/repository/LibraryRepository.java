package com.demo.exceltodb.repository;

import com.demo.exceltodb.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Integer> {
}
