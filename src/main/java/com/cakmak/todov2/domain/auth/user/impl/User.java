package com.cakmak.todov2.domain.auth.user.impl;

import com.cakmak.todov2.domain.auth.user.impl.enums.Role;
import com.cakmak.todov2.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Entity
@Table(name = User.TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
public class User extends AbstractEntity implements UserDetails {
    public static final String TABLE = "users";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ACCOUNT_NON_EXPIRED = "account_non_expired";
    private static final String ENABLED = "enabled";
    private static final String ACCOUNT_NON_LOCKED = "account_non_locked";
    private static final String CREDENTIALS_NON_EXPIRED = "credentials_non_expired";
    private static final String ROLES = "roles";


    @Column(name = USERNAME)
    private String username;
    @Column(name = PASSWORD)
    private String password;
    @Column(name = ACCOUNT_NON_EXPIRED)
    private boolean accountNonExpired;
    @Column(name = ENABLED)
    private boolean enabled;
    @Column(name = ACCOUNT_NON_LOCKED)
    private boolean accountNonLocked;
    @Column(name = CREDENTIALS_NON_EXPIRED)
    private boolean credentialsNonExpired;
    @Column(name = ROLES , nullable = false)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "authorities" , joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;

//    Yukarıdaki kod ile birlikte ben aslında herhangi bir kullanıcının almış olduğu rolleri ayrı bir tabloda liste olarak tutuyorum
//    FetchType.EAGER sayesinde ne zaman bir User çekersem o zaman verileri almış olucam



}
