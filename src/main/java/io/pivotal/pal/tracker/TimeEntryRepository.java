package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(Long id);
    List<TimeEntry> list();
    TimeEntry update(Long id, TimeEntry timeEntry);
    void delete(Long id);
<<<<<<< HEAD
}
=======
}
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
