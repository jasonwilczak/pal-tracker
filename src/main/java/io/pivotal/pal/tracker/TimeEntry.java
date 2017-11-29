package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(int projectId, int userId, LocalDate entryDate, int hours) {
        this.setProjectId(projectId);
        this.setUserId(userId);
        this.setDate(entryDate);
        this.setHours(hours);
    }
    public TimeEntry(long id, int projectId, int userId, LocalDate entryDate, int hours) {
        this.setId(id);
        this.setProjectId(projectId);
        this.setUserId(userId);
        this.setDate(entryDate);
        this.setHours(hours);
    }

    public TimeEntry() {

    }

    public void setId(long id) {
        this.id=id;
    }
    public long getId() {
        return this.id;
    }
    public void setProjectId(long id) {this.projectId=id;}
    public long getProjectId() {return this.projectId;}
    public void setUserId(long id) {this.userId=id;}
    public long getUserId() {return this.userId;}
    public void setDate(LocalDate date) {this.date=date;}
    public LocalDate getDate() {return this.date;}
    public void setHours(int hours) {this.hours=hours;}
    public int getHours() {return this.hours;}

    public TimeEntry update(TimeEntry dataToChange)
    {
        this.setProjectId(dataToChange.projectId);
        this.setUserId(dataToChange.userId);
        this.setDate(dataToChange.date);
        this.setHours(dataToChange.hours);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        TimeEntry comparisonObject = (TimeEntry)o;
        return comparisonObject != null && comparisonObject.getId()==this.getId();
    }
}
