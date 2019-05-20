package com.example.caleb.schoolmap;

import java.util.ArrayList;

public class Room
{
    private String name;
    private ArrayList<String> teachers = new ArrayList<String>();

    public Room(String name, String room)
    {
        this.name = name;
        teachers.add(room);
    }

    public boolean multipleTeachers()
    {
        return (teachers.size() > 1);
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<String> getTeachers()
    {
        return teachers;
    }

    public void addTeacher(String teacher)
    {
        teachers.add(teacher);
    }






}
