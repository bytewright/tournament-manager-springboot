package org.bytewright.springbootvue.jpa.entities;

import org.bytewright.springbootvue.jpa.converter.DataProtectionConverter;
import org.bytewright.springbootvue.jpa.converter.RoleConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class AppUser extends BasicEntity {
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Convert(converter = DataProtectionConverter.class)
    private String email;
    @Column(columnDefinition = "CLOB")
    @Convert(converter = RoleConverter.class)
    private Set<String> roles;
    @Column(name = "disabled_account")
    private Boolean isDisabledAccount;

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isDisabledAccount() {
        return isDisabledAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setDisabledAccount(Boolean disabledAccount) {
        isDisabledAccount = disabledAccount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", isDisabledAccount=" + isDisabledAccount +
                '}';
    }
}
