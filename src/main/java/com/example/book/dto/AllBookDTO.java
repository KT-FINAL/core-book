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
public class AllBookDTO {
    private Long id;
    private String title;
    private String author;
    private String publish;
    private String bookUrl;
    private String coverUrl;
    private Long createdAt;
    private Long updatedAt;
}