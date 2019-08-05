package io.pivotal.pal.tracker;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

//import javax.persistence.*;
import java.time.LocalDate;


//@Entity
@Getter
@Setter
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@ToString
//@Table(name = "time_entry")

public class TimeEntry {

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long id = 1L;
    private long timeEntryId;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;




    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate localDate, int hours) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = localDate;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate localDate, int hours) {
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
