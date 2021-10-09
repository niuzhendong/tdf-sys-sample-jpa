package com.sample.tdf.service.impl;

import cn.com.taiji.common.base.BaseServiceImpl;
import com.sample.tdf.domain.Course;
import com.sample.tdf.domain.CourseRepository;
import com.sample.tdf.dto.CourseDTO;
import com.sample.tdf.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseRepository, Course, CourseDTO> implements ICourseService {

}
