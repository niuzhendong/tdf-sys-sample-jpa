package com.sample.tdf.service.impl;

import cn.com.taiji.common.base.BaseJoinServiceImpl;
import cn.com.taiji.common.dto.PageDTO;
import cn.com.taiji.common.util.CommonJpaPageUtil;
import com.sample.tdf.domain.CourseStudentScore;
import com.sample.tdf.domain.CourseStudentScoreRepository;
import com.sample.tdf.dto.CourseStudentScoreJoinDTO;
import com.sample.tdf.dto.ScoreWithNamesDTO;
import com.sample.tdf.service.ICourseStudentScoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentScoreServiceImpl extends BaseJoinServiceImpl<CourseStudentScoreRepository, CourseStudentScore, CourseStudentScoreJoinDTO>
        implements ICourseStudentScoreService {

    /**
     * JPA多表关联动态分页查询示例
     * @param pageDTO
     * @return
     */
    @Override
    public PageDTO<ScoreWithNamesDTO> findScoreWithNamesPageable(PageDTO<ScoreWithNamesDTO> pageDTO) {
        PageRequest pageable = CommonJpaPageUtil.getInstance().toPageRequest(pageDTO);
        //获取查询参数
        Page<ScoreWithNamesDTO> pageList = iBaseRepository.findScoreWithNamesPageable(pageDTO.getFilters(), pageable);
        pageDTO.setTotal(pageList.getTotalElements());
        pageDTO.setList(pageList.getContent());
        return pageDTO;
    }
}