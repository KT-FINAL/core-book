package com.example.book.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.book.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{


  // @Query(value = "SELECT * FROM book", nativeQuery = true)
  // List<Book> findAllBook();

  // @Query(value = "SELECT * FROM book WHERE title LIKE CONCAT('%', :title, '%') AND user_id =:userId", nativeQuery = true)
  // List<Book> findByTitleId(@Param("title") String title, @Param("userId") Long userId);
  @Query(value = "SELECT b.id, b.user_id, b.allbook_id, a.title, a.author, a.book_url, a.cover_url, a.publish, a.created_at, a.updated_at " +
               "FROM allbook a " +
               "JOIN book b ON a.id = b.allBook_id " +
               "WHERE b.user_id::bigint = :userId", nativeQuery = true)
  List<Book> findByUserId(@Param("userId") Long userId);
}