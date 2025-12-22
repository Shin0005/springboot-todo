package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    // 全タスク取得
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    // IDでタスク取得
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    // 完了状態でフィルタリング
    public List<Task> getTasksByStatus(Boolean completed) {
        return taskRepository.findByCompleted(completed);
    }
    
    // タスク作成
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    
    // タスク更新
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("タスクが見つかりません: " + id));
        
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.getCompleted());
        
        return taskRepository.save(task);
    }
    
    // タスク削除
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("タスクが見つかりません: " + id));
        taskRepository.delete(task);
    }
    
    // タスク完了状態切り替え
    public Task toggleTaskCompletion(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("タスクが見つかりません: " + id));
        
        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }
}