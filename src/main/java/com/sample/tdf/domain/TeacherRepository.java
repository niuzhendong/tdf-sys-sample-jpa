package com.sample.tdf.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teacher, String>, JpaSpecificationExecutor<Teacher> {

}
