package com.example.caleb.schoolmap;

import java.util.ArrayList;

public class Teacher
{
    private String name;
    private ArrayList<String> rooms = new ArrayList<String>();

    ////Used to fetch the corresponding entry in the array used for the spinnder
    private int indexInArray;

    public Teacher(String name, String room, int indexInArray)
    {
        this.name = name;
        rooms.add(room);
        this.indexInArray = indexInArray;
    }

    public int numRooms()
    {
        return rooms.size();
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<String> getRooms()
    {
        return rooms;
    }

    public void addRoom(String room)
    {
        rooms.add(room);
    }

    public int getIndex()
    {
        return indexInArray;
    }

}
