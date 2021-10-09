package com.sample.tdf.dto;

import cn.com.taiji.common.dto.BaseJoinDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "学生和课程DTO，附带成绩")
@Data
@NoArgsConstructor
public class CourseStudentScoreJoinDTO extends BaseJoinDTO {
    private static final long serialVersionUID = 2558887145428876699L;

    private String studentId;
    private String courseId;
    private String score;
}
