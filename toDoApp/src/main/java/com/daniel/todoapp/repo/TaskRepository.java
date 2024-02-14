package com.daniel.todoapp.repo;

import com.daniel.todoapp.entity.taskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface TaskRepository extends MongoRepository<taskEntity, String> {
}
