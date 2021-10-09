package com.sample.tdf.service;


import cn.com.taiji.common.dto.PageDTO;
import cn.com.taiji.common.service.IBaseJoinService;
import com.sample.tdf.domain.CourseStudentScore;
import com.sample.tdf.dto.CourseStudentScoreJoinDTO;
import com.sample.tdf.dto.ScoreWithNamesDTO;

public interface ICourseStudentScoreService extends IBaseJoinService<CourseStudentScoreJoinDTO, CourseStudentScore> {
    /**
     * JPA多表关联动态分页查询示例
     */
    PageDTO<ScoreWithNamesDTO> findScoreWithNamesPageable(final PageDTO<ScoreWithNamesDTO> pageDTO);
}
