package com.example.book.mapper;

import com.example.book.entity.AllBook;
import com.example.book.entity.Book;
import com.example.book.dto.BookDTO;


public class BookMapper {

    // 엔티티를 DTO로 변환
    public static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        Long allBookId = book.getAllBook() != null ? book.getAllBook().getId() : null;
        return new BookDTO(
            book.getId(),
            book.getUserId(),
            allBookId
        );
    }

    // DTO를 엔티티로 변환
    public static Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setUserId(bookDTO.getUserId());
        if(bookDTO.getAllBookId() != null) {
            AllBook allBook = new AllBook();
            allBook.setId(bookDTO.getAllBookId());
            book.setAllBook(allBook);
        }
        return book;
    }
}