package io.naren.repo;

import org.springframework.data.repository.CrudRepository;

import io.naren.model.Todo;

public interface TodoRepo extends CrudRepository<Todo,Long> {

}
