package com.greenfox.webtodo.controller;

import com.greenfox.webtodo.model.Todo;
import com.greenfox.webtodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoController {

  @Autowired
  TodoRepository todoRepo;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String todo(Model model) {
    model.addAttribute("todolist", todoRepo.findAll());
    return "index";
  }

  @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
  public String addTodo(@RequestParam ( name = "todo") String todo){
    todoRepo.save(new Todo(todo));
  return "redirect:/";
  }
}
