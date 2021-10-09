package com.sample.tdf.service.impl;


import cn.com.taiji.common.base.CommonServiceImpl;
import cn.com.taiji.common.exception.CommonException;
import cn.com.taiji.common.util.CommonBeanUtil;
import cn.com.taiji.sys.exception.SysException;
import cn.hutool.core.util.StrUtil;
import com.sample.tdf.domain.Room;
import com.sample.tdf.domain.RoomRepository;
import com.sample.tdf.dto.RoomDTO;
import com.sample.tdf.service.IRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class RoomServiceImpl  extends CommonServiceImpl<RoomRepository, Room, RoomDTO> implements IRoomService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoomDTO create(RoomDTO roomDTO) {
        roomDTO = beforeCreate(roomDTO);
        Room t = dtoToDomain(roomDTO, true);
        t = iBaseRepository.saveAndFlush(t);

        return domainToDTO(t, true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(String id) {
        beforeRemove(Arrays.asList(id));
        RoomDTO dto = new RoomDTO();
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
        List<Room> allById = iBaseRepository.findAllById(ids);
        if (!CollectionUtils.isEmpty(allById)) {
            allById.forEach(entity -> {
                entity.setFlag(0);
            });
            iBaseRepository.saveAll(allById);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchCreate(List<RoomDTO> teacherDTOList) {
        List<Room> ts = new ArrayList();
        teacherDTOList.forEach(dto -> {
            dto = beforeCreate(dto);
            Room t = dtoToDomain(dto, true);
            ts.add(t);
        });
        iBaseRepository.saveAll(ts);
        iBaseRepository.flush();

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoomDTO update(RoomDTO roomDTO) {
        if (StrUtil.isBlank(roomDTO.getPk())) {
            throw new SysException("ID不能为空");
        }
        Room t = dtoToDomain(roomDTO, false);

        String id = t.getPk();
        Optional<Room> old = iBaseRepository.findById(id);
        if (old.isPresent()) {
            Room oldDomain = old.get();
            CommonBeanUtil.updateCopy(t, oldDomain);
            return domainToDTO(iBaseRepository.saveAndFlush(oldDomain), true);
        }
        throw new CommonException("没有找到此对象，无法更新");
    }

    @Override
    public RoomDTO findById(String id) {
        Optional<Room> t = iBaseRepository.findById(id);
        if (!t.isPresent()) {
            return null;
        }
        return domainToDTO(t.get(), true);
    }

    @Override
    public List<RoomDTO> findByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList();
        }
        List<Room> ts = iBaseRepository.findAllById(ids);
        List<RoomDTO> dtos = domainListToDTOList(ts, true);
        return dtos;
    }
}
