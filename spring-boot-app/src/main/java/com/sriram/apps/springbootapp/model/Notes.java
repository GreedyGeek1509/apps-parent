package com.sriram.apps.springbootapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notes {
    @Id
    @SequenceGenerator(name = "notes_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "notes")
    private String notes;
}
