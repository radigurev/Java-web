package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.UsersSongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersSongsRepository extends JpaRepository<UsersSongs, Long> {

    List<UsersSongs> findByUser(User user);

    @Transactional
    void deleteAllByUser(User user);
}
