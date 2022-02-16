package Battleships.repository;

import Battleships.models.entity.Ship;
import Battleships.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findAllByUserNot(User user);
    List<Ship> findAllByUser(User user);
    Optional<Ship> findByName(String name);
    @Transactional
    @Modifying
    @Query("UPDATE Ship s SET s.health= :health WHERE s.id= :id")
    void setShipHealth(@Param(value = "health") long health,@Param(value = "id") long id);
}
