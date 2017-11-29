package io.pivotal.pal.tracker;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntries.size() + 1);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
=======
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List _dataStore;

    public InMemoryTimeEntryRepository() {
        _dataStore = new ArrayList<TimeEntry>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(_dataStore.size()+1);
        _dataStore.add(timeEntry);
        if(_dataStore.size()<=0) return null;
        return (TimeEntry) _dataStore.get(_dataStore.size()-1);
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
    }

    @Override
    public TimeEntry find(Long id) {
<<<<<<< HEAD
        return timeEntries.get(id);
=======
        int dataStoreSize= _dataStore.size();
        if(dataStoreSize<=0) return null;
        for(int i=0;i<dataStoreSize;i++)
        {
            TimeEntry currentObject = (TimeEntry) _dataStore.get(i);
            if(currentObject.getId()==id) return currentObject;
        }
        return null;
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
    }

    @Override
    public List<TimeEntry> list() {
<<<<<<< HEAD
        return new ArrayList<>(timeEntries.values());
=======
        return _dataStore;
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
<<<<<<< HEAD
        timeEntries.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntry;
=======
        TimeEntry currentObject = find(id);
        if(currentObject==null) return null;
        return currentObject.update(timeEntry);
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
    }

    @Override
    public void delete(Long id) {
<<<<<<< HEAD
        timeEntries.remove(id);
    }
}
=======
        TimeEntry objectToDelete = find(id);
        if(objectToDelete==null) return;

        _dataStore.remove(objectToDelete);

    }
}
>>>>>>> b28134d5e6788ac6ef8ba5e82a8b4b7fbdfa62e7
