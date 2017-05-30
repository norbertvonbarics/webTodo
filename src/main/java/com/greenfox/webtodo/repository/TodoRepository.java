package com.greenfox.webtodo.repository;

import com.greenfox.webtodo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
