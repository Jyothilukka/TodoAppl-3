/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.TodoJpaRepository;
import org.springframework.web.bind.annotation.*;

@Service
public class TodoJpaService implements TodoRepository{
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodoList() {

        List<Todo> todosList = todoJpaRepository.findAll();
        ArrayList<Todo> todo = new ArrayList<>(todosList);
        return todo;
    }

    @Override
    public Todo getTodoById(int id) {

      try{
            Todo todo = todoJpaRepository.findById(id).get();       
            return todo;
        }
      catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }     
    }

    @Override
    public Todo addTodo(Todo todo) {

        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo newTodo = todoJpaRepository.findById(id).get();
            if (todo.getTodo() != null) {
                newTodo.setTodo(todo.getTodo());
            }
            if (todo.getPriority() != null) {
                newTodo.setPriority(todo.getPriority());
            }
            if (todo.getStatus() != null) {
                newTodo.setStatus(todo.getStatus());
            }
            
            todoJpaRepository.save(newTodo);
            return newTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {

        try{
            todoJpaRepository.deleteById(id);;       
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }  
      
    }

}
