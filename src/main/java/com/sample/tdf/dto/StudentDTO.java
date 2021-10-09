package com.sample.tdf.dto;

import cn.com.taiji.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * 类描述：学生管理Dto对象
 **/
@ApiModel(value = "Student对象")
@Data
@NoArgsConstructor
public class StudentDTO extends BaseDTO {
    private static final long serialVersionUID = 2558887945428876699L;

    @ApiModelProperty(value = "学生姓名")
    @Size(min = 2, max = 20, message = "学生姓名长度只能在2-20之间")
    private String studentName;

    @ApiModelProperty(value = "学生班级")
    @Size(min = 2, max = 20, message = "学生班级长度只能在1-100之间")
    private String studentClass;

    @ApiModelProperty(value = "学生性别")
    private String studentSex;

    @ApiModelProperty(value = "班级Id")
    private String classId;


}
