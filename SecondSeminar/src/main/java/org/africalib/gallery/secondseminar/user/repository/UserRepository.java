package org.africalib.gallery.secondseminar.user.repository;

import org.africalib.gallery.secondseminar.user.User;
import org.africalib.gallery.secondseminar.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();
    public void save(UserDto userDto){
        User u = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .build();
        handong.put(userDto.getStudentId(), u);
    }
    public UserDto findById(Integer studentId){
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }
    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                        .studentId(user.getStudentId())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }
    public void update(Integer studentId, UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(user.getStudentName());
       // handong.put(user.getStudentId(),user);
    }
    public void delete(Integer studentId){
        handong.remove(studentId);
    }
}
