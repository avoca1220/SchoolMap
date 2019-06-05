package com.example.caleb.schoolmap;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ArrayProcessor
{

    public static String[] inOrder(String[] old)
    {
        String[] arr = Arrays.copyOf(old, old.length);

        String[] result = new String[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            int index = i;

            for(int j = 0; j < arr.length; j++)
            {
                if(arr[index].compareToIgnoreCase(arr[j]) > 0 )
                {
                    index = j;
                }
            }

            result[i] = arr[index];

            arr[index] = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";



        }

        return result;
    }



    public static String[] noDoubles(String[] arr)
    {
        ArrayList<String> list =  new ArrayList<String>(Arrays.asList(arr));

        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(list.get(i).equals(list.get(j)))
                {
                    list.set(i, "");
                }
            }
        }

        for(int i = list.size() - 1; i >= 0; i--)
        {
            if(list.get(i).equals(""))
            {
                list.remove(i);
            }
        }

        return list.toArray(new String[list.size()]);
    }


    public static Manager initialize(String[] teachers, String[] rooms, int[] xCoords, int[] yCoords)
    {
        Manager manager = new Manager(teachers, rooms);


        for(int i = 0; i < teachers.length; i++)
        {
            manager.addTeacher(teachers[i], rooms[i]);
            manager.addRoom(rooms[i], teachers[i], xCoords[i], yCoords[i]);
        }


        return manager;
    }
}