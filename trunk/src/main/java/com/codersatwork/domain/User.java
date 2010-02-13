package com.codersatwork.domain;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * @author Saurabh Agrawal
 * @crated Feb 13, 2010
 */
public class User implements UserDetails {

    private Integer id;

    private String password;


    private String username;


    private boolean accountNonExpired = true;


    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;


    private GrantedAuthority[] authorities;


    public User(String username, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, GrantedAuthority[] authorities) {
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public GrantedAuthority[] getAuthorities() {
        return authorities;
    }
}
