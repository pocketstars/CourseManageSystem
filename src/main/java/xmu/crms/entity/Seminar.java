package xmu.crms.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * 
* <p>Title: Course.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2018<／p>
 * @author Jackey
 * @date 2018年1月3日
 */
public class Seminar {
    private BigInteger id;
    private String name;
    private String description;
    private Course course;
    private Boolean fixed;
    private Date startTime;
    private Date endTime;


    public Seminar(BigInteger seminarId) {
        this.id = seminarId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Seminar() {
    }

    public Seminar(BigInteger id, String name, String description, Course course, Boolean fixed, Date startTime,
                   Date endTime) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = course;
        this.fixed = fixed;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Seminar [id=" + id + ", name=" + name + ", description=" + description + ", course=" + course
                + ", fixed=" + fixed + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }
}
