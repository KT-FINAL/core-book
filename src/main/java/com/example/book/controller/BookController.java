package com.example.book.controller;

import com.example.book.domain.AllBookRepository;
import com.example.book.dto.BookDTO;
import com.example.book.entity.AllBook;
import com.example.book.entity.Book;
import com.example.book.service.BookService;
import com.example.book.util.JwtUtil;
import com.example.book.util.TokenInfo;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AllBookRepository allBookRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // @GetMapping("/all")
    // public List<Book> allBooks() {
    //     return bookService.findAllBook();
    // }
    @PostMapping("/register")
    public Book registerBook(@RequestHeader("Authorization") String token, @RequestBody Book book) {
        if (book.getAllBook() != null && book.getAllBook().getId() != null) {
           AllBook managedAllBook = allBookRepository.findById(book.getAllBook().getId())
               .orElseThrow(() -> new EntityNotFoundException("AllBook not found"));
           book.setAllBook(managedAllBook);
        }
        return bookService.registerBook(token, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long id) {
        bookService.deleteBook(token, id);
    }

    // @GetMapping("/user/search")
    // public List<Book> searchBooks(@RequestHeader("Authorization") String token, 
    //                             @RequestParam(name = "title") String title) {
    //     return bookService.searchBooks(token, title);
    // }

    @GetMapping("/user")
    public List<Book> searchBooksByUser(@RequestHeader("Authorization") String token) {
        return bookService.searchBooksByUser(token);
    }

    // @GetMapping("/test")
    // public void searchBooksByUser(@RequestHeader("Authorization") String token) {
    //     TokenInfo userId = jwtUtil.extractTokenInfo(token);
    //     System.out.println("Extracted User ID: " + userId);
    // }
}
