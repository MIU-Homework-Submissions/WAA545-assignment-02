package com.merhawifissehaye.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Builder
public class Book {
    private int id;
    private String title;
    private String isbn;
    private String author;
    private double price;
}
