package com.example.book.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.book.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{


  @Query(value = "SELECT * FROM book", nativeQuery = true)
  List<Book> findAllBook();

  @Query(value = "SELECT * FROM book WHERE title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
  List<Book> findByTitleContaining(String title);
}