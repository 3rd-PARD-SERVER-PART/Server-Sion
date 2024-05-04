package org.example.fourthseminar.book.service;

import lombok.RequiredArgsConstructor;
import org.example.fourthseminar.book.dto.BookCreateDTO;
import org.example.fourthseminar.book.dto.BookReadDTO;
import org.example.fourthseminar.book.entity.Book;
import org.example.fourthseminar.book.repo.BookRepo;
import org.example.fourthseminar.user.dto.UserDTO;
import org.example.fourthseminar.user.entity.User;
import org.example.fourthseminar.user.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    // final을 쓰는 이유 : final을 안 쓰면 bookRepo를 인식 못함.
    // final에 해당하는 메서드를 불러오기는 가능, 하지만 메서드의 이름 수정 등은 불가능

    public void createBook(BookCreateDTO dto) {
//        User user = userRepo.findById(dto.getUserId()).orElseThrow());

        bookRepo.save(new Book(dto,
                userRepo.findById(dto.getUserId()).orElseThrow()));
        /*
        "dto.getUserId()":
        dto 객체에서 사용자 ID를 가져온다.

        "findById":
        해당 ID에 해당하는 사용자를 데이터베이스에서 찾아온다.

        "orElseThrow()":
        findById()는 해당 ID가 존재하지 않을 경우 Optional<User> 형태로 결과를 반환한다.
        orElseThrow() 메서드는 Optional 객체가 비어있을 경우 지정된 예외를 발생시킨다.
        여기서는 사용자를 찾지 못한 경우에 대한 예외를 처리한다.

        "new Book":
        가져온 사용자 정보와 책의 정보를 사용하여 새로운 Book 객체를 생성한다.

        */

    }

    public List<BookReadDTO> findAll() {
        return bookRepo.findAll() // 리스트들을 찾고
                .stream() // 스트림을 사용해서 나누고
                .map(book -> new BookReadDTO(book,
                    new UserDTO.Read(book.getUser())
                ))
//                .map(BookReadDTO::new)
                .collect(Collectors.toList());
    }
    /*
        findAll()로 책의 여러 리스트를 가져옴. (ex. 1, 2, 3, 4, 5)
        스트림으로 하나씩 나눔 (1 / 2 / 3 / 4 / 5) (for문 처럼)
        map으로 얘가 할 행동들을 설명해준다. map은 객체 하나하나를 만들어내서,
        map (1 -> bookReadDTO가 되고, 2-> bookReadDTO가 되고, ...)
        ".collect(Collectors.toList());": 그 다음에 리스트로 만들어준다.

        BookReadDTO에는 book과 UserDTO.Read라는 두 변수가 있다.
        Book entity?에서 user를 가져와서 UserDTO의 Read에 넣어준다.
    */

    public BookReadDTO findById(Long id) {
        return new BookReadDTO(bookRepo.findById(id).orElseThrow());
    }
    public List<BookReadDTO> findById() {
        return bookRepo.findAll()
                .stream()
                .map(book -> new BookReadDTO(book,
                        new UserDTO.Read(book.getUser())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateById(Long id, BookCreateDTO dto) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.update(dto, userRepo.findById(dto.getUserId()).orElseThrow());
    }

    public List<BookReadDTO> deleteById(Long id) {
        bookRepo.deleteById(id);
        return findAll();
    }

}

