package com.example.habittracker.service;

import com.example.habittracker.dto.HabitRequestDTO;
import com.example.habittracker.dto.HabitResponseDTO;
import com.example.habittracker.exception.ResourceNotFoundException;
import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public List<HabitResponseDTO> getAllHabits() {
        return habitRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public HabitResponseDTO createHabit(HabitRequestDTO dto) {
        Habit newHabit = new Habit();
        newHabit.setName(dto.getName());
        newHabit.setDescription(dto.getDescription());
        newHabit.setActive(dto.isActive());
        return toResponseDTO(habitRepository.save(newHabit));
    }

    public HabitResponseDTO updateHabit(Long id, HabitRequestDTO updatedHabit) {
        return habitRepository.findById(id).map(habit -> {
            habit.setName(updatedHabit.getName());
            habit.setDescription(updatedHabit.getDescription());
            habit.setActive(updatedHabit.isActive());
            return toResponseDTO(habitRepository.save(habit));
        }).orElseThrow(() -> new ResourceNotFoundException("Invalid id : " + id));
    }

    public void deleteHabit(Long id) {
        if (!habitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Invalid id :" + id);
        }

        habitRepository.deleteById(id);
    }

    private HabitResponseDTO toResponseDTO(Habit habit) {
        return new HabitResponseDTO(habit.getId(), habit.getName(), habit.getDescription(), habit.isActive());
    }
}
