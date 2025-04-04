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
    private Long allBookId;
}