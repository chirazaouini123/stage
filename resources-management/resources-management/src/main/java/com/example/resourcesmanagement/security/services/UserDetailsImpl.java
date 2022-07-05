package com.example.resourcesmanagement.security.services;

import com.example.resourcesmanagement.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private Long id;

    //private String username;

    private String email;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public  static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities=user.getRoles().stream().
                map(role -> new SimpleGrantedAuthority(role.getLibellé().name()))
                .collect(Collectors.toList());
        return  new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }
 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
     return authorities;
 }
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

}
