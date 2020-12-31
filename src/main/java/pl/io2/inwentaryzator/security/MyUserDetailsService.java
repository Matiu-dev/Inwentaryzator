package pl.io2.inwentaryzator.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.io2.inwentaryzator.worker.Worker;
import pl.io2.inwentaryzator.worker.WorkerRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Worker> workers = workerRepository.findByLogin(s);

        workers.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        return workers.map(MyUserDetails::new).get();
    }
}
