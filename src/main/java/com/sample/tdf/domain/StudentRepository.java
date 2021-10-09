package com.sample.tdf.domain;

import cn.com.taiji.common.base.IBaseRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 学生表dao
 */
public interface StudentRepository extends IBaseRepository<Student> {
    List<Student> findByStudentClass(@Param("studentClass") String studentClass);
}
