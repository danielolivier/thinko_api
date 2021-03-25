package com.thinko.api.session.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = Session.TABLE_NAME)
public class Session {
    public static final String TABLE_NAME = "Sessions";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_english")
    private String nameEnglish;

    @Column(name = "trimester")
    private Long trimester;

    @Column(name = "seen")
    private boolean seen;

    @Column(name = "course_id")
    private Long courseId;
}
