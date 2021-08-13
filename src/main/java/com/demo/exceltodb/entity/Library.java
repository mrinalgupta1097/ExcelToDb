package com.demo.exceltodb.entity;

import lombok.Data;
import lombok.Getter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();


    public void setBooks(Set<Book> books){
        this.books = books;

        for(Book b : books){
            b.setLibrary(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
