package ru.gb.oseminar.lesson3.data;

import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup>{
    private final List<StudentGroup> studyGroups;

    public Stream(List<StudentGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return studyGroups.iterator();
    }

    public List<StudentGroup> getStudyGroups() {
        return studyGroups;
    }
}
