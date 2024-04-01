package org.africalib.gallery.secondassignment.user.service;

import lombok.RequiredArgsConstructor;
import org.africalib.gallery.secondseminar.user.dto.UserDto;
import org.africalib.gallery.secondseminar.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(UserDto userDto){
        userRepository.save(userDto);
    }
    public UserDto findById(Integer id){
        return userRepository.findById(id);
    }
    public List<UserDto> findAll(){
        return userRepository.findAll();
    }
    public void update(Integer id, UserDto userDto){
        userRepository.update(id, userDto);
    }
    public void delete(Integer id){
        userRepository.delete(id);
    }
}
