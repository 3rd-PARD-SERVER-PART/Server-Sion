package org.example.fourthseminar.book.controller;

import lombok.RequiredArgsConstructor;
import org.example.fourthseminar.book.dto.BookCreateDTO;
import org.example.fourthseminar.book.dto.BookReadDTO;
import org.example.fourthseminar.book.entity.Book;
import org.example.fourthseminar.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("")
    public String createBook(@RequestBody BookCreateDTO dto) {
        bookService.createBook(dto);
        return "추가됨";
    }

    @GetMapping("")
    public List<BookReadDTO> findAll() {
        return bookService.findById();
    }

    @GetMapping("/{id}")
    public BookReadDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody BookCreateDTO dto) {
        bookService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    public List<BookReadDTO> deleteById(@PathVariable Long id) {
        return bookService.deleteById(id);
    }
}
