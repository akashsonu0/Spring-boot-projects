package in.pwskills.akash.config;

import javax.sql.DataSource;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration

public class PersistenceConfig {

    @Bean
    DataSource dataSource() {
        // Load HikariCP config from application.properties file
        String location = "D:\\OctBatchMicroservices\\SpringBoot\\springjdbc-JdbcTemplate-App\\src\\main\\java\\in\\pwskills\\akash\\config\\application.properties";
        HikariConfig config = new HikariConfig(location);
        return new HikariDataSource(config);
    }

    @Bean
    @DependsOnDatabaseInitialization
    SimpleJdbcInsert jdbcInsert(DataSource dataSource) {
		return new SimpleJdbcInsert(dataSource);
    }
}
 
