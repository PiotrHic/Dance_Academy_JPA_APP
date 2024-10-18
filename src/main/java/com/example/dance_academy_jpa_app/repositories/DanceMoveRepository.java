package com.example.dance_academy_jpa_app.repositories;

import com.example.dance_academy_jpa_app.domain.DanceMove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceMoveRepository extends JpaRepository<DanceMove,Integer> {
}
