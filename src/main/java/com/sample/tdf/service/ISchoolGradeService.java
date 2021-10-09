package com.sample.tdf.service;

import cn.com.taiji.common.domain.CommonDomain;
import cn.com.taiji.common.service.IBaseTreeService;
import cn.com.taiji.sys.dto.DataItemDTO;
import com.sample.tdf.dto.SchoolGradeDTO;

import java.util.List;


public interface ISchoolGradeService<D extends CommonDomain> extends IBaseTreeService<SchoolGradeDTO, D> {

    List<SchoolGradeDTO> findTree();

}
