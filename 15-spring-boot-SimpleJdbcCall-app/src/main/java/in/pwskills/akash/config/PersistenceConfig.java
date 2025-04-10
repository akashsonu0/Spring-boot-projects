package in.pwskills.akash.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Configuration

public class PersistenceConfig {

    @Bean
    SimpleJdbcInsert jdbcInsert(DataSource dataSource) {
		return new SimpleJdbcInsert(dataSource);
    }
    
    @Bean
    SimpleJdbcCall jdbcCall(DataSource dataSource) {
    	return new SimpleJdbcCall(dataSource);
    }
}
 
