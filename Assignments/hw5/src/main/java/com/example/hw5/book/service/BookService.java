package com.example.hw5.book.service;

import com.example.hw5.book.dto.BookCreateDto;
import com.example.hw5.book.dto.BookReadDto;
import com.example.hw5.book.entity.Book;
import com.example.hw5.book.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public void createBook(BookCreateDto dto){
        bookRepo.save(Book.toEntity(dto));
    }

    public List<BookReadDto> findAll(){
        return bookRepo.findAll()
                .stream()
                .map(book -> new BookReadDto(book))
                .collect(Collectors.toList());
    }

    public List<BookReadDto> deleteById(Long id) {
        bookRepo.deleteById(id);
        return findAll();
    }
}
