package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "must be not empty")
    private int id;
    @NotNull(message = "must be not empty")
    private String name;
    @NotNull(message = "must be not empty")
    private int salary;
}
