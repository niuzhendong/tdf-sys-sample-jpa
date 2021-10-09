package com.sample.tdf.domain;

import cn.com.taiji.common.base.BaseDomain;
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
 * 学生管理实体类
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
@Where(clause = "flag=1")
public class Student extends BaseDomain {
    private static final long serialVersionUID = 7578292815543449813L;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String studentName;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.equal)
    private String studentSex;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String studentClass;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.equal)
    private String classId;
}
