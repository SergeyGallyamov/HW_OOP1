package ru.gb.oseminar.lesson4.controller;

import ru.gb.oseminar.lesson4.data.Student;
import ru.gb.oseminar.lesson4.data.Teacher;
import ru.gb.oseminar.lesson4.service.StudentGroupService;
import ru.gb.oseminar.lesson4.service.StudentService;
import ru.gb.oseminar.lesson4.view.StudentView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class StudentController implements UserController<Student>{

    private final StudentService dataService = new StudentService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final StudentView studentView = new StudentView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        studentView.sendOnConsole(dataService.getAll());
    }

    public void createStudentGroup(Teacher teacher, List<Student> students){
        studentGroupService.createStudentGroup(teacher, students);
        studentView.sendOnConsoleUserGroup(studentGroupService.getStudentGroupList());
    }

    public void getStudentInStudentGroup(String firstName, String secondName){
        Student student = studentGroupService.getStudentFromStudentGroup(firstName, secondName);
        studentView.sendOnConsole(Collections.singletonList(student));
    }

    public void getSortedListStudentFromStudentGroup(Long groupId){
        List<Student> students = studentGroupService.getSortedStudentGroup(groupId);
        studentView.sendOnConsole(students);
    }

    public void getSortedListByFIOStudentFromStudentGroup(Long groupId){
        List<Student> students = studentGroupService.getSortedByFIOStudentGroup(groupId);
        studentView.sendOnConsole(students);
    }
}
