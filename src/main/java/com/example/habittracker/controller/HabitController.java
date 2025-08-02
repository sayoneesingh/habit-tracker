package com.example.habittracker.controller;

import com.example.habittracker.dto.HabitRequestDTO;
import com.example.habittracker.dto.HabitResponseDTO;
import com.example.habittracker.model.Habit;
import com.example.habittracker.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping
    public List<HabitResponseDTO> getAllHabits() {
        return habitService.getAllHabits();
    }

    @PostMapping
    public HabitResponseDTO createHabit(@RequestBody @Valid HabitRequestDTO dto) {
        return habitService.createHabit(dto);
    }

    @PutMapping("/{id}")
    public HabitResponseDTO updateHabit(@PathVariable Long id, @RequestBody @Valid HabitRequestDTO dto) {
        return habitService.updateHabit(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
