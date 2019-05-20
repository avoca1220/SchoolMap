package com.example.caleb.schoolmap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Manager
{
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public Manager()
    {

    }


    public Teacher findMatchingTeacher(Room room, int index)
    {
        for(Teacher teacher : teachers)
        {
            if (teacher.getName().equals(room.getTeachers().get(index)))
            {
                return teacher;
            }
        }

        //If there is no match
        throw new NoSuchElementException();
    }

    public Room findMatchingRoom(Teacher teacher, int index)
    {
        for(Room room : rooms)
        {
            if (room.getName().equals(teacher.getRooms().get(index)))
            {
                return room;
            }
        }

        //If there is no match
        throw new NoSuchElementException();
    }

    public void addTeacher(String name, String room)
    {
        for(Teacher teacher : teachers)
        {
            if (teacher.getName().equals(name))
            {
                teacher.addRoom(room);
            }
            else
            {
                teachers.add(new Teacher(name, room));
            }
        }
    }

    public void addRoom(String name, String teacher)
    {
        for(Room room : rooms)
        {
            if(room.getName().equals(name))
            {
                room.addTeacher(teacher);
            }
            else
            {
                rooms.add(new Room(name, teacher));
            }
        }
    }

}
