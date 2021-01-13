package com.sanshao.redis.repositroy;

import com.sanshao.redis.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
