package io.chris.reactiveuserreactor.repository;

import io.chris.reactiveuserreactor.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
