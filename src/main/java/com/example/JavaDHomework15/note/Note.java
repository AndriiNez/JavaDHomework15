package com.example.JavaDHomework15.note;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
}
