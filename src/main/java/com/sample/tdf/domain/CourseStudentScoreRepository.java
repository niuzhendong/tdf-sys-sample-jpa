package com.sample.tdf.domain;

import cn.com.taiji.common.base.IBaseJoinRepository;
import com.sample.tdf.dto.ScoreWithNamesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentScoreRepository extends IBaseJoinRepository<CourseStudentScore> {
    String findScoreWithNamesPageableJPQL = " from CourseStudentScore t " +
            " left join Student s on t.studentId=s.id " +
            " left join Course c on t.courseId=c.id " +
            " where (:#{#scoreWithNamesDTO.studentName} is null or s.studentName LIKE CONCAT('%',:#{#scoreWithNamesDTO.studentName},'%')) " +
            " and (:#{#scoreWithNamesDTO.courseName} is null or c.courseName  LIKE CONCAT('%',:#{#scoreWithNamesDTO.courseName},'%')) " +
            " and (:#{#scoreWithNamesDTO.studentId} is null or s.id = :#{#scoreWithNamesDTO.studentId}) " +
            " and (:#{#scoreWithNamesDTO.courseId} is null or c.id = :#{#scoreWithNamesDTO.courseId}) ";

    @Query(value = "select new com.sample.tdf.dto.ScoreWithNamesDTO(t.id, " +
            "t.score,s.id,s.studentName,s.studentClass,s.studentSex,c.id,c.courseName) " + findScoreWithNamesPageableJPQL,
            countQuery = " select count(t.id) " + findScoreWithNamesPageableJPQL)
    Page<ScoreWithNamesDTO> findScoreWithNamesPageable(@Param("scoreWithNamesDTO") ScoreWithNamesDTO scoreWithNamesDTO, Pageable pageable);

}
