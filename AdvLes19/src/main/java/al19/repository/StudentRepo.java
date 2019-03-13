package al19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import al19.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String>{

}
