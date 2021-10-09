package com.sample.tdf.domain;

import cn.com.taiji.common.base.IBaseTreeRepository;
import cn.com.taiji.sys.domain.DataItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolGradeRepository extends IBaseTreeRepository<SchoolGrade> {

}
