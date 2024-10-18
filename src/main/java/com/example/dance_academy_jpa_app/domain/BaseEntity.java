package com.example.dance_academy_jpa_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @Column(
            updatable = false
            )
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    @Column(
            updatable = false
            )
    private String createdBy;
    private String lastModifiedBy;
}
