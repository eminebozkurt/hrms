package com.hrms.hrms.entity.users;


import com.hrms.hrms.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable=false, length = 100)
    private String email;

    @Column(nullable=false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private LocalDateTime createdTime;

    public User(String email, String password, LocalDateTime createdTime) {
        this.email = email;
        this.password = password;
        this.createdTime = createdTime;
    }

}
