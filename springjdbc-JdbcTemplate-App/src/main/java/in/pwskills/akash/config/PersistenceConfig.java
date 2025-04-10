package in.pwskills.akash.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfig {
	
	 @Bean
	    public DataSource dataSource() {
	        // Load HikariCP config from application.properties file
	        String location = "D:\\OctBatchMicroservices\\SpringBoot\\springjdbc-JdbcTemplate-App\\src\\main\\java\\in\\pwskills\\akash\\config\\application.properties";
	        HikariConfig config = new HikariConfig(location);
	        return new HikariDataSource(config);
	    }
	 
	@Bean
	public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate nmJdbcTemplate(@Autowired DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
}
