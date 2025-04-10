package in.pwskills.akash.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(PersistenceConfig.class)
public class AppConfig {

}
