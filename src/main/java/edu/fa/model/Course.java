package edu.fa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author ManhKM on 9/12/2022
 * @project hibernate-fpt
 * -----
 * Annotation Transient dùng với việc khi không muốn một trường trong Java code làm cột trong Database
 */

@Entity(name = "Course")    // Đặt trên cho Entity trong JPA
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Embedded
    private Syllabus syllabus;

    public Course() {
    }

    public Course(String name){
        this.name = name;
    }

    public Course(String name, Date createdDate){
        this.name = name;
        this.createdDate = createdDate;
    }

    public Course(String name, Date createdDate, Syllabus syllabus) {
        this.name = name;
        this.createdDate = createdDate;
        this.syllabus = syllabus;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
