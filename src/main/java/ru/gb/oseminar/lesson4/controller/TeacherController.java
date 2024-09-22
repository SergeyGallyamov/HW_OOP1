package ru.gb.oseminar.lesson4.controller;

import ru.gb.oseminar.lesson4.data.Teacher;
import ru.gb.oseminar.lesson4.data.User;
import ru.gb.oseminar.lesson4.service.TeacherService;
import ru.gb.oseminar.lesson4.view.TeacherView;

import java.time.LocalDate;

public class TeacherController implements UserController<Teacher>{

    TeacherService teacherService = new TeacherService();
    TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
    }

    public void updateTeacher(Long teacherId, User updatedTeacher){
        teacherService.update(teacherId, updatedTeacher);
    }

    public void sendTeacherOnConsole(){
        teacherView.sendOnConsole(teacherService.getAll());
    }
}
