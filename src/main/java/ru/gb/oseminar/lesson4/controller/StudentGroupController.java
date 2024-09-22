package ru.gb.oseminar.lesson4.controller;

import ru.gb.oseminar.lesson4.data.Student;
import ru.gb.oseminar.lesson4.data.Teacher;
import ru.gb.oseminar.lesson4.service.StudentGroupService;
import ru.gb.oseminar.lesson4.service.StudentService;
import ru.gb.oseminar.lesson4.service.TeacherService;

import java.util.List;

public class StudentGroupController {
    private final StudentGroupService groupService = new StudentGroupService();
    private final TeacherService teacherService = new TeacherService();
    private final StudentService studentService = new StudentService();

    public void createGroup(List<Long> studentIds, Long teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        List<Student> students = studentService.findByIds(studentIds);
        groupService.createStudentGroup(teacher, students);
    }
}
