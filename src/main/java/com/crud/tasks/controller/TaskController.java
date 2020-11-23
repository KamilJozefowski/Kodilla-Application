package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask")
    public List<TaskDto> getTask(Long taskId){
        Optional<Task> task = service.getTaskById(taskId);
        return taskMapper.mapToTaskDtoList(task);
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask(Long taskId){

    }

    @PutMapping(value = "updateTask")
    public TaskDto updateTask (TaskDto taskDto){
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @PostMapping(value = "createTask")
    public void createTask(TaskDto taskDto){

    }
}
