package com.zakzackr.todomanagement.repository;

import com.zakzackr.todomanagement.entity.Todo;
import com.zakzackr.todomanagement.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // find todo task by userId and todoId
    Optional<Todo> findByIdAndUserId(Long todoId, Long userId);

    // find all tasks by userId
    List<Todo> findAllByUserId(Long userId);

    @Transactional
    void deleteByIdAndUserId(Long todoId, Long userId);
}
