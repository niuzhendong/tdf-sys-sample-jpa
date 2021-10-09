package com.sample.tdf.dto;

import cn.com.taiji.common.dto.BaseTreeDTO;
import lombok.Data;

@Data
public class SchoolGradeDTO extends BaseTreeDTO {

    private String gradeName;

    private String name;

    private String state;
}