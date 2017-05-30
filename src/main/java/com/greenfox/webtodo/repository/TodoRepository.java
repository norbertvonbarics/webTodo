package com.greenfox.webtodo.repository;

import com.greenfox.webtodo.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  public List<Todo> findFirst10ByOrderByTimestampDesc();
}
