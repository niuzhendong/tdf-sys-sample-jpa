package com.sample.tdf.dto;

import cn.com.taiji.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 * 课程DTO对象
 **/
@ApiModel(value = "Course DTO对象")
@Data
@NoArgsConstructor
public class CourseDTO extends BaseDTO {
    private static final long serialVersionUID = 2555428876699L;

    @Size(min = 2, max = 20, message = "课程名称长度只能在2-20之间")
    private String courseName;
}
