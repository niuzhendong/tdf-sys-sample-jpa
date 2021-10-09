package com.sample.tdf.service.impl;


import cn.com.taiji.common.base.BaseServiceImpl;
import com.sample.tdf.domain.Student;
import com.sample.tdf.domain.StudentRepository;
import com.sample.tdf.dto.StudentDTO;
import com.sample.tdf.exception.TDFSampleException;
import com.sample.tdf.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentRepository, Student, StudentDTO> implements IStudentService {

    @Override
    public StudentDTO beforeCreate(StudentDTO dto) {
        if (StringUtils.isEmpty(dto.getStudentClass())) {
            throw new TDFSampleException("学生班级不能为空");
        }
        if (StringUtils.isEmpty(dto.getStudentName())) {
            throw new TDFSampleException("学生姓名不能为空");
        }
        if (StringUtils.isEmpty(dto.getStudentSex())) {
            throw new TDFSampleException("学生性别不能为空");
        }
        return super.beforeCreate(dto);
    }

    @Override
    public List<StudentDTO> findByStudentClass(String studentClass) {
        List<Student> students = iBaseRepository.findByStudentClass(studentClass);
        return domainListToDTOList(students);
    }
}
