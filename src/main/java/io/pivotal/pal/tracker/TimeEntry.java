package io.pivotal.pal.tracker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long id, long projectId, long userId, LocalDate localDate, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = localDate;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate localDate, int hours) {
        this.id = 1L;
        this.projectId = projectId;
        this.userId = userId;
        this.date = localDate;
        this.hours = hours;
    }

    public TimeEntry() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        return new EqualsBuilder()
                .append(id, timeEntry.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
