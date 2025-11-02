package com.example.lmsdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // 书名

    @Column(nullable = false)
    private String author; // 作者

    @Column(nullable = false)
    private Integer quantity; // 库存数量

    @Column(nullable = false)
    private Boolean available = true; // 是否可借
}
