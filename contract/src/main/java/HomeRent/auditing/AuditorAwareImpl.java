package HomeRent.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * Dummy implementation of {@link AuditorAware}. It will return the configured {@link AuditableUser} as auditor on every
 * call to {@link #getCurrentAuditor()}. Normally you would access the applications security subsystem to return the
 * current user.
 *
 */
public class AuditorAwareImpl implements AuditorAware<AuditableUser> {

    private Optional<AuditableUser> auditor = Optional.empty();

    /**
     * @param auditor the auditor to set
     */
    public void setAuditor(AuditableUser auditor) {
        this.auditor = Optional.of(auditor);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
     */
    public Optional<AuditableUser> getCurrentAuditor() {
        return auditor;
    }
}