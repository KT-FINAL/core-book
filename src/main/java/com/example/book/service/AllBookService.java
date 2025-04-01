package com.example.book.service;

import com.example.book.entity.AllBook;
import com.example.book.domain.AllBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllBookService {

    @Autowired
    private AllBookRepository allBookRepository;

    public List<AllBook> findAllBook() {
        // 모든 책을 조회하는 로직
        return allBookRepository.findAllBook();
    }

    public AllBook registerBook(AllBook book) {
        // 새로운 책을 등록하는 로직
        return allBookRepository.save(book);
    }

    public void deleteBook(Long id) {
        allBookRepository.deleteById(id);
    }

}
