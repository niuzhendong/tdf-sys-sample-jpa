package com.sample.tdf.domain;

import cn.com.taiji.common.base.BaseTreeDomain;
import cn.com.taiji.common.util.CommonJpaQueryWord;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "school_grade")
@Where(clause = "flag=1")
public class SchoolGrade extends BaseTreeDomain {

    private static final long serialVersionUID = -98516053380975909L;

    @Column(name = "grade_name")
    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String gradeName;

    @Column(name = "name")
    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String name;

    @Column(name = "state")
    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String state;
}