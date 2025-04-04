package com.example.book.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.book.entity.AllBook;

@Repository
public interface AllBookRepository extends CrudRepository<AllBook, Long>{


  @Query(value = "SELECT * FROM allbook", nativeQuery = true)
  List<AllBook> findAllBook();

}