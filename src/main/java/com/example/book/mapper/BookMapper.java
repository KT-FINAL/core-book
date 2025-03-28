package com.example.book.mapper;

import com.example.book.entity.Book;
import com.example.book.dto.BookDTO;


public class BookMapper {

    // 엔티티를 DTO로 변환
    public static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(
            book.getId(),
            book.getUserId(),
            book.getTitle(),
            book.getAuthor(),
            book.getCreatedAt(),
            book.getUpdatedAt(),
            book.getMemo(),
            book.getPublish()
        );
    }

    // DTO를 엔티티로 변환
    public static Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        return new Book(
            bookDTO.getId(),
            bookDTO.getUserId(),
            bookDTO.getTitle(),
            bookDTO.getAuthor(),
            bookDTO.getCreatedAt(),
            bookDTO.getUpdatedAt(),
            bookDTO.getMemo(),
            bookDTO.getPublish()
        );
    }
}