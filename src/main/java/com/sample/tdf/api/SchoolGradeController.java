package com.sample.tdf.api;

import cn.com.taiji.common.api.BaseTreeController;
import cn.com.taiji.common.dto.ResultDTO;
import cn.com.taiji.sys.dto.DeptInfoDTO;
import com.sample.tdf.dto.SchoolGradeDTO;
import com.sample.tdf.service.ISchoolGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"204.学校年级架构"})
@RestController
@RequestMapping("/sample/schoolgrade")
public class SchoolGradeController extends BaseTreeController<ISchoolGradeService, SchoolGradeDTO> {

    @Autowired
    private ISchoolGradeService iSchoolGradeService;

    @GetMapping("/find-all-tree")
    @ApiOperation(value = "全量查询，并且拼接为树结构")
    public ResultDTO findTree() {
        List<SchoolGradeDTO> gradeDTOS = iSchoolGradeService.findTree();
        return new ResultDTO(gradeDTOS);
    }

}
