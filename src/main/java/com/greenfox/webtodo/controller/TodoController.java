package com.greenfox.webtodo.controller;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import com.greenfox.webtodo.model.Todo;
import com.greenfox.webtodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  TodoRepository todoRepo;

  @RequestMapping(value = "/")
  public String todo(Model model) {
    model.addAttribute("todolist", todoRepo.findAll());
    return "index";
  }

  @RequestMapping(value = "/addtodo")
  public String addTodo(@RequestParam(name = "newTodo") String newTodo) {
    todoRepo.save(new Todo(newTodo));
    return "redirect:/todo/";
  }

  @RequestMapping(value = "/deleteTodo")
  public String deleteTodo(@RequestParam(name = "delete") long id) {
    todoRepo.delete(id);
    return "redirect:/todo/";
  }

  @RequestMapping(value = "/{id}/edit")
  public String edit(Model model, @PathVariable("id") Long id) {
    model.addAttribute("todo", todoRepo.findOne(id));
    return "editTodo";
  }

  @RequestMapping(value = "/{id}/edit/update")
  public String updated(@PathVariable("id") Long id, @RequestParam("text") String text,
      @RequestParam(value = "urgent", defaultValue = "unchecked",  required = false) String urgent,
      @RequestParam(value = "done", defaultValue = "unchecked",  required = false) String done) {

    Todo todo = todoRepo.findOne(id);
    todo.setText(text);
    boolean isUrgent = urgent.equals("checked");
    todo.setUrgent(isUrgent);
    boolean isDone = done.equals("checked");
    todo.setDone(isDone);

    todoRepo.save(todo);

    return "redirect:/todo/";
  }
}
