package com.example.habittracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HabitRequestDTO {

    @NotBlank(message = "Habit name is required")
    @Size(max = 100, message = "Habit name should not exceed 100 characters")
    private String name;

    @Size(max = 500, message = "Habit description should not exceed 500 characters")
    private String description;

    private boolean active;
}
