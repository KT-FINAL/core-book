package com.example.book.mapper;

import com.example.book.dto.AllBookDTO;
import com.example.book.entity.AllBook;

public class AllBookMapper {
    
    // 엔티티를 DTO로 변환
    public static AllBookDTO toDTO(AllBook allbook) {
        if (allbook == null) {
            return null;
        }
        return new AllBookDTO(
            allbook.getId(),
            allbook.getTitle(),
            allbook.getAuthor(),
            allbook.getCreatedAt(),
            allbook.getUpdatedAt(),
            allbook.getMemo(),
            allbook.getPublish()
        );
    }

    // DTO를 엔티티로 변환
    public static AllBook toEntity(AllBookDTO allbookDTO) {
        if (allbookDTO == null) {
            return null;
        }
        return new AllBook(
            allbookDTO.getId(),
            allbookDTO.getTitle(),
            allbookDTO.getAuthor(),
            allbookDTO.getCreatedAt(),
            allbookDTO.getUpdatedAt(),
            allbookDTO.getMemo(),
            allbookDTO.getPublish(),
            null
        );
    }
}