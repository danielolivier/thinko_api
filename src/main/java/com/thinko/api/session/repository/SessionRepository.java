package com.thinko.api.session.repository;

import com.thinko.api.session.model.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    @Query(value = "SELECT * FROM SESSIONS s WHERE s.course_id = :courseId ", nativeQuery = true)
    List<Session> findByCourseId(@Param("courseId") String courseId);
}
