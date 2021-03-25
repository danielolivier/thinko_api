package com.thinko.api.session.model.DTO;

import com.thinko.api.session.model.Session;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SessionResponse {
    private Long id;
    private String name;
    private String nameEnglish;
    private Long trimester;
    private boolean seen;
    private Long courseId;

    public SessionResponse (Session session) {
        this.id = session.getId();
        this.name = session.getName();
        this.nameEnglish = session.getNameEnglish();
        this.trimester = session.getTrimester();
        this.seen = session.isSeen();
        this.courseId = session.getCourseId();
    }

}
