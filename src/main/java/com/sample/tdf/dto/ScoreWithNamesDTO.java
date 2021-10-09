package com.sample.tdf.dto;

import cn.com.taiji.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "演示复合查询DTO，分数，包含课程名称和学生名称等 DTO对象")
@Data
@NoArgsConstructor
public class ScoreWithNamesDTO extends BaseDTO {
    private static final long serialVersionUID = 2533428876699L;

    private String score;
    private String studentId;
    private String studentName;
    private String studentClass;
    private String studentSex;
    private String courseId;
    private String courseName;

    public ScoreWithNamesDTO(String id,
                             String score,String studentId,String studentName,String studentClass,String studentSex,String courseId,String courseName){
        super.setId(id);
        this.score = score;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentSex = studentSex;
        this.courseId = courseId;
        this.courseName = courseName;

    }

}
