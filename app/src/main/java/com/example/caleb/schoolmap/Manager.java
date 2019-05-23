package com.example.caleb.schoolmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Manager
{
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
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
        for(Teacher teacher : teachers)
        {

            if (teacher.getName().equals(name))
            {
                teacher.addRoom(room);
            }
            else
            {
                teachers.add(new Teacher(name, room, getSortedTeacherIndex(name)));
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
                rooms.add(new Room(name, teacher, getSortedRoomIndex(name)));
            }
        }
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
        for(Teacher teacher : teachers)
        {
            if(teacher.getName().equals(name))
            {
                return teacher;
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
