package com.example.habittracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="habits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean active;

}