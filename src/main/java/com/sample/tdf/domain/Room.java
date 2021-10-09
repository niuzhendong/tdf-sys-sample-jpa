package com.sample.tdf.domain;

import cn.com.taiji.common.domain.CommonDomain;
import cn.com.taiji.common.util.CommonJpaQueryWord;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 教室管理实体类, 继承CommonXXX,弱约束方式
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "room")
@Where(clause = "flag=1")
public class Room extends CommonDomain {
    private static final long serialVersionUID = 7578292815543449813L;

    @Id
    private String pk;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String roomName;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String roomDesc;

    private Integer flag;
}
