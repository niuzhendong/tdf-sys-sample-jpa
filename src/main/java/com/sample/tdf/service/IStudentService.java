package com.sample.tdf.service;

import cn.com.taiji.common.service.IBaseService;
import com.sample.tdf.domain.Student;
import com.sample.tdf.dto.StudentDTO;

import java.util.List;

public interface IStudentService extends IBaseService<StudentDTO, Student> {

    List<StudentDTO> findByStudentClass(String studentClass);
}