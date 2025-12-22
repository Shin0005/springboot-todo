package com.example.todo.repository;

import com.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // 完了状態でフィルタリング
    List<Task> findByCompleted(Boolean completed);
    
    // タイトルで部分一致検索
    List<Task> findByTitleContaining(String keyword);
}