package org.africalib.gallery.secondassignment.user.repository;

import org.africalib.gallery.secondseminar.user.User;
import org.africalib.gallery.secondseminar.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public void save(UserDto userDto) {
        int id = idCounter.incrementAndGet();
        User user = User.builder()
                .id(id)
                .name(userDto.getName())
                .price(userDto.getPrice())
                .build();
        userMap.put(id, user);
    }
    public UserDto findById(Integer id){
        User user = handong.get(id);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .price(user.getPrice())
                .build();
    }
    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user -> UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .price(user.getPrice())
                        .build()).toList();
    }

    public void update(Integer id, UserDto userDto){
        User user = handong.get(id);
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPrice(userDto.getPrice());
    }

    public void delete(Integer id){
        handong.remove(id);
    }
}
