package com.reportingSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String email;
    private String password;
    private String mobileNumber;
    private boolean status;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleModel> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isStatus();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isStatus();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isStatus();
    }

    @Override
    public boolean isEnabled() {
        return this.isStatus();
    }
}
