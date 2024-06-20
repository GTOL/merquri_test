import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
    }

    public void createStudent(String name, String gender) {
        template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)",
                null, name, gender);
    }

    public List<Student> findStudentByName(String nameStartsWith) {
        return template.query("SELECT * FROM student WHERE name LIKE '?%'",
                (rs, rowNum) -> new Student(rs.getString("name"), rs.getString("gender")),
                nameStartsWith);
    }
}
