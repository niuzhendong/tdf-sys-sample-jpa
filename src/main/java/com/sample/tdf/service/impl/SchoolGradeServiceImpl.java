package com.sample.tdf.service.impl;

import cn.com.taiji.common.base.BaseTreeServiceImpl;
import com.sample.tdf.domain.SchoolGrade;
import com.sample.tdf.domain.SchoolGradeRepository;
import com.sample.tdf.dto.SchoolGradeDTO;
import com.sample.tdf.service.ISchoolGradeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 学校年纪组织架构
 */
@Service
public class SchoolGradeServiceImpl extends BaseTreeServiceImpl<SchoolGradeRepository, SchoolGrade, SchoolGradeDTO> implements ISchoolGradeService<SchoolGrade> {

    @Override
    public List<SchoolGradeDTO> findTree() {
        List<SchoolGrade> all = iBaseRepository.findAll();
        List<SchoolGradeDTO> gradeDTOS = this.domainListToDTOList(all);
        List<SchoolGradeDTO> gradeDTOS1 = this.listToTree(gradeDTOS, null);
        return gradeDTOS1;
    }

}
