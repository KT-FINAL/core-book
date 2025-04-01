package com.example.book.controller;

import com.example.book.entity.AllBook;
import com.example.book.service.AllBookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class AllBookController {

    @Autowired
    private AllBookService allbookService;

    @GetMapping("/all")
    public List<AllBook> allBooks() {
        return allbookService.findAllBook();
    }
    @PostMapping
    public AllBook registerBook(@RequestBody AllBook book) {
        return allbookService.registerBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name = "id") Long id) {
        allbookService.deleteBook(id);
    }
}