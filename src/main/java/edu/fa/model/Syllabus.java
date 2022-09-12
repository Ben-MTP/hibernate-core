package edu.fa.model;

import javax.persistence.Embeddable;

/**
 * @author ManhKM on 9/12/2022
 * @project hibernate-fpt
 * -----
 * Làm thế nào có thể nhúng một Object vào một Object
 * Sử dụng @Embeddable: có thể nhúng
 *         @Embedded: đã được nhúng
 */
@Embeddable
public class Syllabus {
    private String content;
    private int duration;

    public Syllabus() {
    }

    public Syllabus(String content, int duration) {
        this.content = content;
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
