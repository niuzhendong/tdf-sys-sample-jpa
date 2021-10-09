package com.sample.tdf.api;

import cn.com.taiji.common.api.BaseController;
import com.sample.tdf.dto.CourseDTO;
import com.sample.tdf.service.ICourseService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"202.课程操作接口"})
@RequestMapping("/sample/course")
public class CourseController extends BaseController<ICourseService, CourseDTO> {

}
