package com.example.caleb.schoolmap;

import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.ortiz.touch.TouchImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner teacherSpinner;
    private Spinner classroomSpinner;
    private TouchImageView map;
    private final int WIDTH = 3840;
    private final int HEIGHT = 2160;
    private Manager mainManager;

    //Toggle on and off each time onItemSelected is called to ignore the call of the other, changed entry.
    boolean listenToChange = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mainManager = ArrayProcessor.initialize(getResources().getStringArray(R.array.teachers_array), getResources().getStringArray(R.array.room_array));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classroomSpinner = (Spinner)findViewById(R.id.classrooms_spinner);
        ArrayAdapter<String> classroomAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, ArrayProcessor.noDoubles(ArrayProcessor.inOrder(getResources().getStringArray(R.array.room_array))));

        classroomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classroomSpinner.setAdapter(classroomAdapter);
        classroomSpinner.setOnItemSelectedListener(this);

        teacherSpinner = (Spinner)findViewById(R.id.teachers_spinner);
        ArrayAdapter<String> teacherAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, ArrayProcessor.noDoubles(ArrayProcessor.inOrder(getResources().getStringArray(R.array.teachers_array))));

        teacherAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teacherSpinner.setAdapter(teacherAdapter);
        teacherSpinner.setOnItemSelectedListener(this);


        map = (com.ortiz.touch.TouchImageView)findViewById(R.id.map);
        map.setMaxZoom(20);

        for(Teacher teacher : mainManager.teachers)
        {
            Log.d("teacherval", teacher.getName());
        }

    }


    public void onItemSelected(AdapterView<?> parent, View v, int position, long id)
    {
        Log.d("tog", Boolean.toString(listenToChange));
        if(listenToChange)
        {
            if(parent == teacherSpinner)
            {
                teacherSelected(position);
            }
            if(parent == classroomSpinner)
            {
                classroomSelected(position);
            }
            listenToChange = false;
        }
        else
        {
            listenToChange = true;
        }

    }

    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    //Incorporate all of that object oriented bullshit into the actual spinner controllers
    public void teacherSelected(int val)
    {
        Teacher teacher = mainManager.getTeacherByName(getResources().getStringArray(R.array.teachers_array)[val]);


        classroomSpinner.setSelection(mainManager.getRoomByName(teacher.getRooms().get(0)).getIndex());
        //map.setZoom((float)20, (float)(getResources().getIntArray(R.array.x_coords)[val])/WIDTH, (float)(getResources().getIntArray(R.array.y_coords)[val])/HEIGHT);
    }


    public void classroomSelected(int val)
    {

        //Room room = mainManager.getRoomByName(getResources().getStringArray(R.array.room_array)[val]);
        //teacherSpinner.setSelection(mainManager.getTeacherByName(room.getTeachers().get(0)).getIndex());
        //map.setZoom((float)20, (float)(getResources().getIntArray(R.array.x_coords)[classroomsToTeachers[val]])/WIDTH, (float)(getResources().getIntArray(R.array.y_coords)[classroomsToTeachers[val]])/HEIGHT);
    }


}
