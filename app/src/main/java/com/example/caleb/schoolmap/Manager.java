package com.example.caleb.schoolmap;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Manager
{
    public ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Room> rooms = new ArrayList<Room>();

    private String[] teachersSorted;
    private String[] roomsSorted;

    public Manager(String[] teachersUnsorted, String[] roomsUnsorted)
    {
        teachersSorted = ArrayProcessor.inOrder(ArrayProcessor.noDoubles(teachersUnsorted));
        roomsSorted = ArrayProcessor.inOrder(ArrayProcessor.noDoubles(roomsUnsorted));
    }


    public Teacher getTeacherByRoom(Room room, int index)
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

    public Room getRoomByTeacher(Teacher teacher, int index)
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
        Log.d("teacherval", "New entry: " + name + ", " + room);

        if(teacherExists(name))
        {
            getTeacherByName(name).addRoom(room);
        }

        else
        {
            teachers.add(new Teacher(name, room, getSortedTeacherIndex(name)));
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
                Log.d("teacherval", "Adding room to existing teacher");
                rooms.add(new Room(name, teacher, getSortedRoomIndex(name)));
            }
        }
    }

    public boolean teacherExists(String name)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            Log.d("teacherval","Iterating again!");
            if (teachers.get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }


    public int getSortedTeacherIndex(String name)
    {
        for(int i = 0; i < teachersSorted.length; i++)
        {
            if(teachersSorted[i].equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    public int getSortedRoomIndex(String name)
    {
        for (int i = 0; i < roomsSorted.length; i++)
        {
            if(roomsSorted[i].equals(name))
            {
                return i;
            }
        }
        return -1;

    }

    public Teacher getTeacherByName(String name)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            if(teachers.get(i).getName().equals(name))
            {
                return teachers.get(i);
            }
        }
        return null;
    }

    public Room getRoomByName(String name)
    {
        for(Room room : rooms)
        {
            if(room.getName().equals(name))
            {
                return room;
            }
        }
        return null;
    }


}
