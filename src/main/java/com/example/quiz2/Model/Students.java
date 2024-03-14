package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Students {
    @NotNull(message = "must ber not empty")
    private int id;
    @NotNull(message = "must ber not empty")
    private String name;
    @NotNull(message = "must ber not empty")
    private int age;
    @NotNull(message = "must ber not empty")
    private String major;
}
