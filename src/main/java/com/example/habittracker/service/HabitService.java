package com.example.habittracker.service;

import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id,Habit updatedHabit){
        return habitRepository.findById(id).map(habit -> {
            habit.setName(updatedHabit.getName());
            habit.setDescription(updatedHabit.getDescription());
            habit.setActive(updatedHabit.isActive());
            return habitRepository.save(habit);
        }).orElseThrow(() -> new RuntimeException("Invalid id : "+id));
    }

    public void deleteHabit(Long id){
        if(!habitRepository.existsById(id)){
            throw new RuntimeException("Invalid id :"+id);
        }

        habitRepository.deleteById(id);
    }
}
