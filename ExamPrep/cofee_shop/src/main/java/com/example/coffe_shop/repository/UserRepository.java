package com.example.coffe_shop.repository;

import com.example.coffe_shop.models.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsernameAndPassword(String username,String password);

    @Query("SELECT u FROM Users u ORDER BY size(u.orders) DESC")
    Optional<Users> findAllByOrdersDesc();
}
