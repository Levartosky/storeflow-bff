package br.com.storeflow.bff.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
        Long id,
        String name,
        LocalDateTime createdAt
) {
}