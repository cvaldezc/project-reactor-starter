package io.chris.reactorstudent.infraestructure.adapter.out.sql.repository;

import io.chris.reactorstudent.infraestructure.adapter.out.sql.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByActiveIsTrue();
}
