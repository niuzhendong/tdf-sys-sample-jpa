package com.sample.tdf.domain;


import cn.com.taiji.common.annotation.BaseJoinId;
import cn.com.taiji.common.base.BaseJoinDomain;
import cn.com.taiji.common.util.CommonJpaQueryWord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 学生和课程关联表，附带成绩
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "CourseStudentScore")
public class CourseStudentScore extends BaseJoinDomain {
    private static final long serialVersionUID = 7578292815541249813L;

    @BaseJoinId(index=BaseJoinId.Index.first)
    private String studentId;

    @BaseJoinId(index=BaseJoinId.Index.second)
    private String courseId;

    @CommonJpaQueryWord(func = CommonJpaQueryWord.MatchType.like)
    private String score;
}
