package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcTimeEntryRepository implements TimeEntryRepository {

    private JdbcTemplate jdbcTemplate;
private DataSource _dataSource;
    public JdbcTimeEntryRepository(DataSource dataSource) {
this._dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        String insertQuery = "INSERT INTO time_entries (project_id,user_id,date,hours) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertQuery, new String[] {"id"});
            ps.setString(1, String.valueOf(timeEntry.getProjectId()));
            ps.setString(2, String.valueOf(timeEntry.getUserId()));
            ps.setString(3, String.valueOf(timeEntry.getDate()));
            ps.setString(4, String.valueOf(timeEntry.getHours()));
            return ps;
        }, keyHolder);
        long id = keyHolder.getKey().longValue(); //now contains the generated key}
        return find(id);
    }

    @Override
    public TimeEntry find(Long id) {
        try {
            Map<String, Object> foundEntry = jdbcTemplate.queryForMap("Select * from time_entries where id = ?", id);

            return getTimeEntryFromDbRecord(foundEntry);
        }
        catch(Exception e) {
            return null;
        }

    }

    private TimeEntry getTimeEntryFromDbRecord(Map<String, Object> foundEntry) {
        long idFromDb = (long)foundEntry.get("id");
        long projectIdFromDb = ((long) foundEntry.get("project_id"));
        long userIdFromDb = (long)foundEntry.get("user_id");
        Date dateFromDb = (Date)foundEntry.get("date");
        LocalDate localDate = dateFromDb.toLocalDate();
        int hoursFromDb = (int)foundEntry.get("hours");
        return new TimeEntry(idFromDb,projectIdFromDb,userIdFromDb,localDate,hoursFromDb);
    }

    @Override
    public List<TimeEntry> list() {
        List<Map<String,Object>> foundEntries = jdbcTemplate.queryForList("select * from time_entries");
        List<TimeEntry> mappedTimeEntries = new ArrayList<>();
        for (Map<String,Object> item: foundEntries) {
            mappedTimeEntries.add(getTimeEntryFromDbRecord(item));
        }
        return mappedTimeEntries;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        String insertQuery = "UPDATE time_entries SET project_id = ?, user_id = ?, date = ?, hours = ? WHERE id = ?";
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertQuery);
            ps.setString(1, String.valueOf(timeEntry.getProjectId()));
            ps.setString(2, String.valueOf(timeEntry.getUserId()));
            ps.setString(3, String.valueOf(timeEntry.getDate()));
            ps.setString(4, String.valueOf(timeEntry.getHours()));
            ps.setString(5, String.valueOf(id));
            return ps;
        });
        return find(id);
    }

    @Override
    public void delete(Long id) {
        this.jdbcTemplate.execute("DELETE from time_entries WHERE id = "+id);
    }
}
