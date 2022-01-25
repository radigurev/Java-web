package com.example.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;

@Repository
public interface RouteRepository extends JpaRepository<RouteMatcher.Route,Long> {
}
