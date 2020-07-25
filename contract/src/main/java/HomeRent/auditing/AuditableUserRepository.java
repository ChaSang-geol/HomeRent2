package HomeRent.auditing;

import org.springframework.data.repository.CrudRepository;

public interface AuditableUserRepository extends CrudRepository<AuditableUser, Long> {}
