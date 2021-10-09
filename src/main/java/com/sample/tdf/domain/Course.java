package com.sample.tdf.domain;

import cn.com.taiji.common.base.BaseDomain;
import cn.com.taiji.common.util.CommonJpaQueryWord;
import cn.com.taiji.common.util.CommonJpaQueryWord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 课程实体类
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
@Where(clause = "flag=1")
public class Course extends BaseDomain {
    private static final long serialVersionUID = 7578292815541249813L;
    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String courseName;
}
