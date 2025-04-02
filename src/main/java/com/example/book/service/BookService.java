package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.util.JwtUtil;
import com.example.book.util.TokenInfo;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.example.book.domain.BookRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional 
    public Book registerBook(String jwtToken, Book book) {
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(jwtToken);
        book.setUserId(tokenInfo.getUserId());
        return bookRepository.save(book);
    }


    @Transactional 
    public void deleteBook(String jwtToken, Long id) {
        // JWT 토큰에서 사용자 정보 추출
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(jwtToken);

        // Book 엔티티 조회
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        // 사용자 권한 확인
        if (!isUserAuthorized(tokenInfo, book)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorized to delete this book");
        }

        // Book 엔티티와 AllBook 엔티티 간의 관계 끊기
        book.setAllBook(null);

        // Book 엔티티 삭제
        bookRepository.delete(book);
    }

    // public List<Book> searchBooks(String jwtToken, String title) {
    //     TokenInfo tokenInfo = JwtUtil.extractTokenInfo(jwtToken);
    //     return bookRepository.findByTitleId(tokenInfo.getUserId());
    // }
    public List<Book> searchBooksByUser(String jwtToken) {
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(jwtToken);
        return bookRepository.findByUserId(tokenInfo.getUserId());
    }
    // public List<Book> findAllBook() {
    //     return bookRepository.findAllBook();
    // }
    

    private boolean isUserAuthorized(TokenInfo tokenInfo, Book book) {
        return book.getUserId().equals(tokenInfo.getUserId());
    }
}