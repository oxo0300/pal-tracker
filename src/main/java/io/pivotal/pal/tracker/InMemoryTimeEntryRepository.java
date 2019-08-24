package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List<TimeEntry> timeEntries;
    private Long id;

    public InMemoryTimeEntryRepository(){
        timeEntries = new ArrayList<>();
        id = 1L;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId() > 0) {
            timeEntry.setId(id++);
        }
        timeEntries.add(timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        TimeEntry timeEntryData = null;
        for(TimeEntry timeEntry: timeEntries) {
            if(timeEntry.getId() == timeEntryId) {
                timeEntryData = timeEntry;
                break;
            }
        }
        return timeEntryData;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntry1 = null;
        Integer index = 0;
        Boolean found = false;
        for(TimeEntry timeEntry2: timeEntries) {
            if(timeEntry2.getId() == id) {
                found = true;
                timeEntry1 = timeEntry2;
                break;
            }
            index++;
        }
        if(found) {
            if(timeEntry.getDate() != null) {
                timeEntry1.setDate(timeEntry.getDate());
            }
            if(timeEntry.getHours() >= 0) {
                timeEntry1.setHours(timeEntry.getHours());
            }
            if(timeEntry.getProjectId() >= 0) {
                timeEntry1.setProjectId(timeEntry.getProjectId());
            }
            if(timeEntry.getUserId() >= 0) {
                timeEntry1.setUserId(timeEntry.getUserId());
            }
            if(timeEntry.getId() >= 0) {
                timeEntry1.setId(timeEntry.getId());
            }
            timeEntries.set(index, timeEntry1);
            return timeEntry1;
        } else {
            return null;
        }
    }

    @Override
    public TimeEntry delete(long timeEntryId) {
        TimeEntry timeEntryData = null;
        Boolean found = false;
        for(TimeEntry timeEntry: timeEntries) {
            if(timeEntry.getId() == timeEntryId) {
                found = true;
                timeEntryData = timeEntry;
                break;
            }
        }

        if(found) {
            timeEntries.remove(timeEntryData);
        }
        return timeEntryData;
    }
}
