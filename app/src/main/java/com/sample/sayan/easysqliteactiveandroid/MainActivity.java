package com.sample.sayan.easysqliteactiveandroid;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.sample.sayan.easysqliteactiveandroid.models.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "sayanDB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Student.deleteAllRows();
//        Student.deleteStudentByRoll("A11");
        saveDataToDB();
//        Student.updateStudentNameByRoll("A2", "Amit");
        List<Student> students = Student.getAllStudents();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    private void saveDataToDB() {
        ActiveAndroid.beginTransaction();
        try {
            for (int i = 0; i < 20; i++) {
                Student student = new Student();
                student.name = "Sayan" + i;
                student.roll = "A" + i;
                student.className = "class" + i;
                student.sectionName = "section" + i;
                student.phone = "9863252141" + i;
                student.address = "abcx" + i;
                student.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}
