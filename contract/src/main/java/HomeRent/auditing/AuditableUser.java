package HomeRent.auditing;


import lombok.Data;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * User domain class that uses auditing functionality of Spring Data that can either be aquired implementing
 * {@link Auditable} or extend {@link AbstractAuditable}.
 *
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AuditableUser {

    private @Id @GeneratedValue Long id;
    private String username;

    private @CreatedDate LocalDateTime createDate;
    private @LastModifiedDate LocalDateTime updateDate;

    private @ManyToOne @CreatedBy AuditableUser createUser;
    private @ManyToOne @LastModifiedBy AuditableUser updateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public AuditableUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(AuditableUser createUser) {
        this.createUser = createUser;
    }

    public AuditableUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(AuditableUser updateUser) {
        this.updateUser = updateUser;
    }

    public AuditableUser() {}
    public AuditableUser(Long id, String username, LocalDateTime createDate, LocalDateTime updateDate, AuditableUser createUser, AuditableUser updateUser) {
        this.id = id;
        this.username = username;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }
}