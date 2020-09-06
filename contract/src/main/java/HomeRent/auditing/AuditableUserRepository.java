package HomeRent.auditing;

import org.springframework.data.repository.CrudRepository;
//@EnableJpaRepositories
public interface AuditableUserRepository extends CrudRepository<AuditableUser, Long> {}
