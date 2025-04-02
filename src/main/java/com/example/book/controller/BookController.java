package com.example.book.controller;

import com.example.book.domain.AllBookRepository;
import com.example.book.entity.AllBook;
import com.example.book.entity.Book;
import com.example.book.service.BookService;
import com.example.book.dto.AllBookIdRequestDto;
import com.example.book.util.JwtUtil;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.book.util.TokenInfo;

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

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<Book> registerBook(@RequestHeader("Authorization") String token, @RequestBody AllBookIdRequestDto allBookIdRequestDto) {
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(token);
        Long userId = tokenInfo.getUserId();
        Book book = new Book();
        book.setUserId(userId);

        if (allBookIdRequestDto.getAllbookId() != null) {
            Long allbookId = allBookIdRequestDto.getAllbookId();
            AllBook managedAllBook = allBookRepository.findById(allbookId)
                .orElseThrow(() -> new EntityNotFoundException("AllBook not found"));
            book.setAllBook(managedAllBook);
        }

        Book registeredBook = bookService.registerBook(book);
        return ResponseEntity.ok(registeredBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Long id) {
        bookService.deleteBook(token, id);
    }

    @GetMapping("/user")
    public List<Book> searchBooksByUser(@RequestHeader("Authorization") String token) {
        return bookService.searchBooksByUser(token);
    }
}
