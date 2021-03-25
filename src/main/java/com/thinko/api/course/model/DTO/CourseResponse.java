package com.thinko.api.course.model.DTO;

import com.thinko.api.course.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String name;
    private String nameEnglish;

    public CourseResponse (Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.nameEnglish = course.getNameEnglish();
    }
}
