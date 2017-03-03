package io.naren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.naren.model.Todo;
import io.naren.repo.TodoRepo;


@Controller
@RequestMapping("/todo")
public class TodoController {
    private TodoRepo todoRepository;

    @RequestMapping(method=RequestMethod.GET)
    public String todoList(Model model) {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        if (todos != null) {
            model.addAttribute("todolist", todos);
        }
        return "todos";
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView createTodo(Todo todo) {
        todoRepository.save(todo);
        return new ModelAndView("redirect:/successful");
    }
    
    @RequestMapping(value = "/successful" , method = RequestMethod.GET)
    public String registered(Model model) {
    	List<Todo> todos = (List<Todo>) todoRepository.findAll();
    	model.addAttribute("todolist",todos);
    	return "success";
    }
    
    @Autowired
    public TodoController(TodoRepo todoRepository) {
        this.todoRepository = todoRepository;
    }
}
