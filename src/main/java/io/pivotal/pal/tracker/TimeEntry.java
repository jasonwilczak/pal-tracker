package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(int projectId, int userId, LocalDate entryDate, int hours) {
        this.projectId=projectId;
        this.userId=userId;
        this.date = entryDate;
        this.hours=hours;
    }
    public TimeEntry(long id, int projectId, int userId, LocalDate entryDate, int hours) {
        this.id=id;
        this.projectId=projectId;
        this.userId=userId;
        this.date = entryDate;
        this.hours=hours;
    }

    public void setId(long id) {
        this.id=id;
    }
    public long getId() {
        return this.id;
    }

    public TimeEntry update(TimeEntry dataToChange)
    {
        this.projectId = dataToChange.projectId;
        this.userId = dataToChange.userId;
        this.date = dataToChange.date;
        this.hours = dataToChange.hours;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        TimeEntry comparisonObject = (TimeEntry)o;
        return comparisonObject != null && comparisonObject.getId()==this.id;
    }
}
