package org.example.fourthseminar.book.repo;

import org.example.fourthseminar.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {
}
