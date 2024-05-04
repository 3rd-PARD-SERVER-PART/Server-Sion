package org.example.fourthseminar.user.repo;

import org.example.fourthseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
