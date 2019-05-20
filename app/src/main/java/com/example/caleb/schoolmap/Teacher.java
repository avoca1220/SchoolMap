package com.example.caleb.schoolmap;

import java.util.ArrayList;

public class Teacher
{
    private String name;
    private ArrayList<String> rooms = new ArrayList<String>();

    public Teacher(String name, String room)
    {
        this.name = name;
        rooms.add(room);
    }

    public boolean multipleRooms()
    {
        return (rooms.size() > 1);
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



}
