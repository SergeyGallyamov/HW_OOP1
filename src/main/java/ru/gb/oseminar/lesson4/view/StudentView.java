package ru.gb.oseminar.lesson4.view;

import ru.gb.oseminar.lesson4.data.Student;
import ru.gb.oseminar.lesson4.data.StudentGroup;

import java.util.List;
import java.util.logging.Logger;

public class StudentView implements UserView<Student>{

    Logger logger = Logger.getLogger(StudentView.class.getName());

    @Override
    public void sendOnConsole(List<Student> students) {
        for(Student user: students){
            logger.info(user.toString());
        }
    }

    public void sendOnConsoleUserGroup(List<StudentGroup> studentGroupList) {
        for (StudentGroup studentGroup : studentGroupList) {
            logger.info(studentGroup.toString());
        }
    }
}
