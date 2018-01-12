package com.sample.sayan.easysqliteactiveandroid.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Admin on 12-01-2018.
 */

@Table(name = "Teacher")
public class Teacher extends Model {

    @Column(name = "name")
    public String name;

    @Column(name = "subject")
    public String subject;

    public Teacher() {
        super();
    }

    public Teacher(String name, String subject) {
        super();
        this.name = name;
        this.subject = subject;
    }
}
