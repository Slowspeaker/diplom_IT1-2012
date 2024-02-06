package kz.greetgo.xnkqionsbdarpbwmocho.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.sql.SQLException;

@Component
public class DataInitializerMongo {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataInitializerMongo(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void initData() {
        jdbcTemplate.execute("TRUNCATE TABLE telephony RESTART IDENTITY CASCADE;");

        Resource resource = new ClassPathResource("telephonyData.sql");
        try {
            ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute sql script.", e);
        }
    }
}
