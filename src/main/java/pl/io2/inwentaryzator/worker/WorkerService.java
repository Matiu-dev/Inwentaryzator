package pl.io2.inwentaryzator.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> findAllWorkers(){
        return workerRepository.findAllWorkers();
    }

    public Optional<Worker> findByLogin(String login){
        return workerRepository.findByLogin(login);

    }

}
