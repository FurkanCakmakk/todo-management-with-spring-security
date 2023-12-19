package com.cakmak.todov2.domain.auth.authorities.impl;

import com.cakmak.todov2.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = Authorities.TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Authorities extends AbstractEntity {
    public static final String TABLE = "authorities";
    private static final String USERNAME = "username";
    private static final String AUTHORITY = "authority";

    @Column(name = USERNAME)
    private String username;

    @Column(name = AUTHORITY)
    private String authority;


}
