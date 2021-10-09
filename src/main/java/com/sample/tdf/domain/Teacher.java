package com.sample.tdf.domain;

import cn.com.taiji.common.util.CommonJpaQueryWord;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 不继承，JPA原始写法，老师管理实体类
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "teacher")
@Where(clause = "flag=1")
public class Teacher {
    private static final long serialVersionUID = 7578293434541249813L;

    @Id
    private String pk;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String teacherName;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String teacherSex;

    private Integer flag;
}
