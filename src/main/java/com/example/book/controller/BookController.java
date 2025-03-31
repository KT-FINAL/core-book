package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> allBooks() {
        return bookService.findAllBook();
    }
    @PostMapping
    public Book registerBook(@RequestBody Book book) {
        return bookService.registerBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(name = "title") String title) {
        return bookService.searchBooks(title);
    }
}
// package com.example.book.controller;

// import com.example.book.entity.Book;
// import com.example.book.dto.BookDTO;
// import com.example.book.mapper.BookMapper;
// import com.example.book.service.BookService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/books")
// public class BookController {

//     @Autowired
//     private BookService bookService;

//     @PostMapping
//     public BookDTO registerBook(@RequestBody BookDTO bookDTO) {
//         Book book = BookMapper.toEntity(bookDTO);
//         Book savedBook = bookService.registerBook(book);
//         return BookMapper.toDTO(savedBook);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteBook(@PathVariable int id) {
//         bookService.deleteBook(id);
//     }

//     @GetMapping
//     public List<Book> searchBooks(@RequestParam String title) {
//         return bookService.searchBooks(title);
//     }
// }