package com.example.musicsite.repository;

import com.example.musicsite.model.entity.Artist;
import com.example.musicsite.model.entity.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {
    Artist findArtistByBrand(ArtistName name);
}
