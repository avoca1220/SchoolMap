package com.example.caleb.schoolmap;

import java.util.ArrayList;

public class Room
{
    private String name;
    private ArrayList<String> teachers = new ArrayList<String>();

    //Used to fetch the corresponding entry in the array used for the spinnder
    private int indexInArray;

    public Room(String name, String room, int indexInArray)
    {
        this.name = name;
        teachers.add(room);
        this.indexInArray = indexInArray;
    }

    public int numTeachers()
    {
        return teachers.size();
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

    public int getIndex()
    {
        return indexInArray;
    }






}
