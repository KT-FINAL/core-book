package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.domain.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book registerBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title) {
        return bookRepository.findByTitleContaining(title);
    }
    public List<Book> findAllBook() {
        return bookRepository.findAllBook();
    }
}