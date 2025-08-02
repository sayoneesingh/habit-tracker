package com.example.habittracker.dto;

import lombok.Data;

@Data
public class HabitResponseDTO {

    private Long id;
    private String name;
    private String description;
    private boolean active;

    public HabitResponseDTO(Long id, String name, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }
}