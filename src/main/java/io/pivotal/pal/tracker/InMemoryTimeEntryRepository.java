package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private List _dataStore;

    public InMemoryTimeEntryRepository() {
        _dataStore = new ArrayList<TimeEntry>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) throws Exception {
        timeEntry.setId(_dataStore.size()+1);
        _dataStore.add(timeEntry);
        if(_dataStore.size()<=0) throw new Exception("No data was added!");
        return (TimeEntry) _dataStore.get(_dataStore.size()-1);
    }

    @Override
    public TimeEntry find(Long id) {
        int dataStoreSize= _dataStore.size();
        if(dataStoreSize<=0) return null;
        for(int i=0;i<dataStoreSize;i++)
        {
            TimeEntry currentObject = (TimeEntry) _dataStore.get(i);
            if(currentObject.getId()==id) return currentObject;
        }
        return null;
    }

    @Override
    public List<TimeEntry> list() {
        return _dataStore;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry currentObject = find(id);
        if(currentObject==null) return null;
        return currentObject.update(timeEntry);
    }

    @Override
    public void delete(Long id) {
        TimeEntry objectToDelete = find(id);
        if(objectToDelete==null) return;

        _dataStore.remove(objectToDelete);

    }
}
