package ru.gb.oseminar.lesson4.service;

import java.time.LocalDate;
import java.util.List;

public interface UserService<T> {
    List<T> getAll();
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}
