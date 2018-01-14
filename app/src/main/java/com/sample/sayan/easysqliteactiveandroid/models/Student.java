package com.sample.sayan.easysqliteactiveandroid.models;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by Admin on 12-01-2018.
 */

@Table(name = "Student")
public class Student extends Model {

    @Column(name = "name")
    public String name;

    @Column(name = "roll")
    public String roll;

    @Column(name = "className")
    public String className;

    @Column(name = "sectionName")
    public String sectionName;

    @Column(name = "phone")
    public String phone;

    @Column(name = "address")
    public String address;

    public Student() {
        super();
    }

    public Student(String name, String roll, String className, String sectionName, String phone, String address) {
        super();
        this.name = name;
        this.roll = roll;
        this.className = className;
        this.sectionName = sectionName;
        this.phone = phone;
        this.address = address;
    }

    public static List<Student> getAllStudents() {
        return new Select().from(Student.class).orderBy("roll DESC").execute();
    }

    public static Student getStudentByRoll(String roll) {
        return new Select().from(Student.class).where("roll = ?", roll).executeSingle();
    }

    public static void updateStudentNameByRoll(String roll, String newName){
        new Update(Student.class).set("name = ?",newName).where("roll = ?", roll).execute();
    }

    public static void deleteAllRows(){
        ActiveAndroid.execSQL("DELETE FROM Student;");
    }

    public static void deleteStudentByRoll(String roll){
        new Delete().from(Student.class).where("roll = ?", roll).execute();
    }
}
