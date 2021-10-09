package com.sample.tdf.service.impl;


import cn.com.taiji.common.dto.CommonPageDTO;
import cn.com.taiji.common.exception.CommonException;
import cn.com.taiji.common.util.CommonBeanUtil;
import cn.com.taiji.common.util.CommonJpaPageUtil;
import cn.com.taiji.sys.exception.SysException;
import cn.hutool.core.util.StrUtil;
import com.sample.tdf.domain.Teacher;
import com.sample.tdf.domain.TeacherRepository;
import com.sample.tdf.dto.TeacherDTO;
import com.sample.tdf.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.*;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public CommonPageDTO<TeacherDTO> getPage(CommonPageDTO<TeacherDTO> commonPageDTO) {
        PageRequest pageable = CommonJpaPageUtil.getInstance().toPageRequest(commonPageDTO, "key");
        TeacherDTO dto = commonPageDTO.getFilters();
        Teacher domain = dtoToDomain(dto,true);
        Specification<Teacher> specification = CommonJpaPageUtil.getInstance().objToSpecWithLogicType(domain, "and");

        Page<Teacher> pageList = teacherRepository.findAll(specification, pageable);
        commonPageDTO.setTotal(pageList.getTotalElements());
        commonPageDTO.setList(domainListToDTOList(pageList.getContent(), true));
        return commonPageDTO;
    }

    private Specification<Teacher> toSpecWithLogicType(TeacherDTO teacherDTO) {
        return (root, criteriaQuery, cb) -> {
            //获取查询类Query的所有字段,包括父类字段
            List<Predicate> predicates = new ArrayList();

            //通过注解上func属性,构建路径表达式
            predicates.add(cb.like(root.get("teacherName"), "%" + teacherDTO.getTeacherName() + "%"));
            predicates.add(cb.like(root.get("teacherSex"), "%" + teacherDTO.getTeacherSex() + "%"));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));//and连接
        };
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherDTO create(TeacherDTO teacherDTO) {
        teacherDTO = beforeCreate(teacherDTO);
        Teacher t = dtoToDomain(teacherDTO, true);
        t = teacherRepository.saveAndFlush(t);

        return domainToDTO(t, true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(String id) {
        beforeRemove(Arrays.asList(id));
        TeacherDTO dto = new TeacherDTO();
        dto.setPk(id);
        dto.setFlag(0);
        update(dto);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(List<String> ids) {
        beforeRemove(ids);
        Set<String> cacheKeys = new HashSet<>();
        List<Teacher> allById = teacherRepository.findAllById(ids);
        if (!CollectionUtils.isEmpty(allById)) {
            allById.forEach(entity -> {
                entity.setFlag(0);
            });
            teacherRepository.saveAll(allById);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchCreate(List<TeacherDTO> teacherDTOList) {
        List<Teacher> ts = new ArrayList();
        teacherDTOList.forEach(dto -> {
            dto = beforeCreate(dto);
            Teacher t = dtoToDomain(dto, true);
            ts.add(t);
        });
        teacherRepository.saveAll(ts);
        teacherRepository.flush();

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TeacherDTO update(TeacherDTO teacherDTO) {
        if (StrUtil.isBlank(teacherDTO.getPk())) {
            throw new SysException("ID不能为空");
        }
        Teacher t = dtoToDomain(teacherDTO, false);

        String id = t.getPk();
        Optional<Teacher> old = teacherRepository.findById(id);
        if (old.isPresent()) {
            Teacher oldDomain = old.get();
            CommonBeanUtil.updateCopy(t, oldDomain);
            return domainToDTO(teacherRepository.saveAndFlush(oldDomain), true);
        }
        throw new CommonException("没有找到此对象，无法更新");
    }

    @Override
    public TeacherDTO findById(String id) {
        Optional<Teacher> t = teacherRepository.findById(id);
        if (!t.isPresent()) {
            return null;
        }
        return domainToDTO(t.get(), true);
    }

    @Override
    public List<TeacherDTO> findByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList();
        }
        List<Teacher> ts = teacherRepository.findAllById(ids);
        List<TeacherDTO> dtos = domainListToDTOList(ts, true);
        return dtos;
    }

    private TeacherDTO domainToDTO(Teacher domain, Boolean isCopyEmptyField) {
        if (domain == null) {
            return null;
        }
        TeacherDTO dto = new TeacherDTO();
        if (isCopyEmptyField) {
            CommonBeanUtil.saveCopy(domain, dto);
        } else {
            CommonBeanUtil.updateCopy(domain, dto);
        }
        return dto;
    }

    private Teacher dtoToDomain(TeacherDTO dto, Boolean isCopyEmptyField) {
        if (dto == null) {
            return null;
        }
        Teacher t = new Teacher();
        if (isCopyEmptyField) {
            CommonBeanUtil.saveCopy(dto, t);
        } else {
            CommonBeanUtil.updateCopy(dto, t);
        }
        return t;
    }

    private List<TeacherDTO> domainListToDTOList(List<Teacher> dList, Boolean isCopyEmptyField) {
        List<TeacherDTO> dtoList = new ArrayList();
        dList.forEach(d ->
                dtoList.add(domainToDTO(d, isCopyEmptyField))
        );
        return dtoList;
    }

    private List<Teacher> dtoListToDomainList(List<TeacherDTO> dtoList, Boolean isCopyEmptyField) {
        List<Teacher> dList = new ArrayList();
        dtoList.forEach(dto -> {
            dList.add(dtoToDomain(dto, isCopyEmptyField));
        });
        return dList;
    }
}
