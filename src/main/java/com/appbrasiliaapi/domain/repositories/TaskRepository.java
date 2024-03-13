package com.appbrasiliaapi.domain.repositories;

import com.appbrasiliaapi.domain.entities.TaskEntity;
import com.appbrasiliaapi.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByIdAndUser(Long id, UserEntity User);
    List<TaskEntity> findByUser(UserEntity user);
}
