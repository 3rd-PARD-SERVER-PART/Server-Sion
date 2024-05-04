package org.example.fourthseminar.user.service;

import lombok.RequiredArgsConstructor;
import org.example.fourthseminar.book.dto.BookReadDTO;
import org.example.fourthseminar.book.repo.BookRepo;
import org.example.fourthseminar.user.dto.UserDTO;
import org.example.fourthseminar.user.entity.User;
import org.example.fourthseminar.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    public void createUser(UserDTO.Create dto) {
        userRepo.save(User.toEntity(dto));
        /*
            save()는 파라미터로 entity를 가져가야 하는데,
            dto 자체를 파라미터로 보낼 수 없기 때문에
            User의 toEntity()로 dto를 보내서 entoty 형태로 변환한 후에, 보내준다.
        */
    }

    public List<UserDTO.Read> readAll() {
        return userRepo.findAll() // 모든 사용자를 데이터베이스에서 가져온다.
                .stream() // 사용자 목록을 스트림으로 변환한다.
                .map(user -> new UserDTO.Read(user, // 각 사용자를 UserDTO.Read 형태로 변환한다.
                        user.getBooks() // 사용자의 책 목록을 가져온다.
                                .stream() // 책 목록을 스트림으로 변환한다.
                                .map(BookReadDTO::new) // 각 책을 BookReadDTO 형태로 변환한다. "클래스이름::메서드이름"
                                // -> 각각의 책에 대해 BookReadDTO의 생성자를 호출하여 새로운 BookReadDTO 객체를 생성하는 역할을 한다.
                                .collect(Collectors.toList()))) // 책 목록을 리스트로 변환하여 UserDTO.Read 객체와 함께 반환한다.
                .collect(Collectors.toList()); // 사용자 목록을 리스트로 변환하여 반환한다.
    }

    /*

    findAll()로 유저들의 여러 리스트를 가져옴. (1, 2, 3, 4, 5)
    스트림으로 하나씩 나눔 (1 / 2 / 3 / 4 / 5) (for문 처럼)
    map (1 ->
    User user
     */

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
