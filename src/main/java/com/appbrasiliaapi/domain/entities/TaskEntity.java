package com.appbrasiliaapi.domain.entities;

import com.appbrasiliaapi.dtos.StatusTask;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tasks")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, referencedColumnName = "id")
    private UserEntity user;
}
