package pl.io2.inwentaryzator.worker;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query(value = "SELECT * FROM worker", nativeQuery = true)
    List<Worker> findAllWorkers();

    @Query(value = "SELECT * FROM worker WHERE login = :login", nativeQuery = true)
    Optional<Worker> findByLogin(@Param("login") String login);

}
