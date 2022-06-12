package com.mtit.user.repos;

import com.mtit.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<User,Integer> {
}
