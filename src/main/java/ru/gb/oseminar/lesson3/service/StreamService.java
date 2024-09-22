package ru.gb.oseminar.lesson3.service;

import ru.gb.oseminar.lesson3.data.Stream;
import ru.gb.oseminar.lesson3.data.StreamComparator;

import java.util.ArrayList;
import java.util.List;

public class StreamService {
    private final List<Stream> streams = new ArrayList<>();

    public List<Stream> getSortedByStudentGroupSize(){
        streams.sort(new StreamComparator());
        return streams;
    }

    public void createStreams(List<Stream> streamList) {
        streams.addAll(streamList);
    }
}
