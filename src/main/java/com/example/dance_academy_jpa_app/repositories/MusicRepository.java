package com.example.dance_academy_jpa_app.repositories;

import com.example.dance_academy_jpa_app.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
}
