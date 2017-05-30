package com.greenfox.webtodo.controller;

import com.greenfox.webtodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TodoController {

  @Autowired
  TodoRepository todoRepo;

  @RequestMapping(value= "/",  method = RequestMethod.GET)
  public String todo() {
    return "index";
  }
}
