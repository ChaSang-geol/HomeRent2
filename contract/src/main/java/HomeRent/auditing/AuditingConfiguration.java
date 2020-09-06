package HomeRent.auditing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

class AuditingConfiguration {

    @Bean
    AuditorAwareImpl auditorAware() {
        return new AuditorAwareImpl();
    }
}