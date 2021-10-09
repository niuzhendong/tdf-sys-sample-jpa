package com.sample.tdf.api;

import cn.com.taiji.common.api.BaseJoinController;
import cn.com.taiji.common.dto.PageDTO;
import cn.com.taiji.common.dto.ResultDTO;
import com.sample.tdf.dto.CourseStudentScoreJoinDTO;
import com.sample.tdf.dto.ScoreWithNamesDTO;
import com.sample.tdf.service.ICourseStudentScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = {"203.学生和课程关联、分数操作接口"})
@RequestMapping("/sample/course-student-score")
public class CourseStudentScoreController extends BaseJoinController<ICourseStudentScoreService, CourseStudentScoreJoinDTO> {

    @ApiOperation(value = "JPA多表关联动态分页查询示例，分页查询分数，包含课程名称和学生名称等")
    @PostMapping(value = "/query")
    @Valid
    public ResultDTO<PageDTO> findScoreWithNamesPageable(@RequestBody PageDTO<ScoreWithNamesDTO> pageDTO) {
        log.info("findScoreWithNamesPageable：{}", pageDTO);
        pageDTO = iBaseService.findScoreWithNamesPageable(pageDTO);
        return new ResultDTO<PageDTO>(pageDTO);
    }
}
