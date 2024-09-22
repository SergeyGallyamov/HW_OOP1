package ru.gb.oseminar.lesson4.view;

import ru.gb.oseminar.lesson4.data.User;

import java.util.List;

public interface UserView<T extends User>{
    void sendOnConsole(List<T> list);
}
