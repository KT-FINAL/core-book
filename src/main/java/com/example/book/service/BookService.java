package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.util.JwtUtil;
import com.example.book.util.TokenInfo;

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

    public Book registerBook(String jwtToken, Book book) {
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(jwtToken);
        book.setUserId(tokenInfo.getUserId());
        return bookRepository.save(book);
    }


    @Transactional 
    public void deleteBook(String jwtToken, Long id) {
        // JWT에서 사용자 정보 추출
        TokenInfo tokenInfo = jwtUtil.extractTokenInfo(jwtToken);

        // 권한 검사
        if (isUserAuthorized(tokenInfo, id)) {
            bookRepository.deleteById(id);
        } else {
            // 권한이 없는 경우 예외 처리
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorized to delete this book");
        }
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
    

    private boolean isUserAuthorized(TokenInfo tokenInfo, Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> book.getUserId().equals(tokenInfo.getUserId()))
                .orElse(false);
    }
}