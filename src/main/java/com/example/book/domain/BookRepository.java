package com.example.book.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.book.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{


  @Query(value = "SELECT * FROM book", nativeQuery = true)
  List<Book> findAllBook();

  @Query(value = "SELECT * FROM book WHERE title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
  List<Book> findByTitleContaining(@Param("title") String title);

  @Query(value = "SELECT * FROM book WHERE user_id LIKE CONCAT('%', :user_id, '%')", nativeQuery = true)
  List<Book> findByUserId(@Param("user_id") String userId);
  
}