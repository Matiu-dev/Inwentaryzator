package pl.io2.inwentaryzator.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import pl.io2.inwentaryzator.worker.Worker;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class WorkerDetails implements UserDetails {

    private Worker worker;

    public WorkerDetails(Worker worker){
        this.worker = worker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(worker.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return worker.getPassword();
    }

    @Override
    public String getUsername() {
        return worker.getLogin();
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

    public Worker getWorker() {
        return worker;
    }

    @Override
    public String toString() {
        return "CustomUserDetails [worker=" + worker + "]";
    }
}
