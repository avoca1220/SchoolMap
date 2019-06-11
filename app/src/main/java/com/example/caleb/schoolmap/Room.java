package com.example.caleb.schoolmap;

import java.util.ArrayList;

public class Room
{
    private String name;
    private ArrayList<String> teachers = new ArrayList<String>();
    private int xCoord;
    private int yCoord;


    //Used to fetch the corresponding entry in the array used for the spinnder
    private int indexInArray;

    public Room(String name, String room, int indexInArray, int xCoord, int yCoord)
    {
        this.name = name;
        teachers.add(room);
        this.indexInArray = indexInArray;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
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

    public int getXCoord()
    {
        return this.xCoord;
    }

    public int getYCoord()
    {
        return this.yCoord;
    }

    public String toString()
    {
        return name + ", " + teachers.toArray().toString();
    }






}
