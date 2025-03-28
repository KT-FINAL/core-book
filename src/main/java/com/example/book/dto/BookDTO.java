package com.example.book.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private Long userId;
    private String title;
    private String author;
    private Long createdAt;
    private Long updatedAt;
    private String memo;
    private String publish;
}