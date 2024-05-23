package com.example.hw5.book.controller;

import com.example.hw5.book.dto.BookCreateDto;
import com.example.hw5.book.dto.BookReadDto;
import com.example.hw5.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
//dto를 받아서 bookService에 전달
    @PostMapping("")
    public String createBook(@RequestBody BookCreateDto dto){
        bookService.createBook(dto);
        return  "추가됨";
    }

    @GetMapping("")
    public List<BookReadDto> findAll(){
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public List<BookReadDto> deleteById(@PathVariable Long id) {
        return bookService.deleteById(id);
    }

}
