package ru.gb.oseminar.lesson4.service;

import ru.gb.oseminar.lesson4.data.Teacher;
import ru.gb.oseminar.lesson4.data.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {
    private final List<Teacher> teacherList;

    public TeacherService() {
        this.teacherList = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teacherList;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Teacher teacherInList : teacherList) {
            if (teacherInList.getTeacherId() > countMaxId) {
                countMaxId = teacherInList.getTeacherId();
            }
        }
        countMaxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        teacherList.add(teacher);
    }

    @Override
    public Teacher findById(Long userId) {
        Teacher result = null;
        for (Teacher teacher : teacherList) {
            if (userId.equals(teacher.getTeacherId())) {
                result = teacher;
                break;
            }
        }
        return result;
    }

    public void update(Long teacherId, User updatedTeacher) {
        for (Teacher teacher : teacherList) {
            if (teacherId.equals(teacher.getTeacherId())) {
                teacher.setFirstName(updatedTeacher.getFirstName());
                teacher.setSecondName(updatedTeacher.getSecondName());
                teacher.setPatronymic(updatedTeacher.getPatronymic());
                teacher.setDateOfBirth(updatedTeacher.getDateOfBirth());
            }
        }
    }
}
