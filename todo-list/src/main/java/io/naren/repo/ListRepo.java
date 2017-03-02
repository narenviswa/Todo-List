package io.naren.repo;


import org.springframework.data.repository.CrudRepository;

import io.naren.model.Users;

public interface ListRepo extends CrudRepository<Users,Long>{
	Users findByUsername(String username);
}
