package ma.emsi.main.repositories;

import jakarta.transaction.Transactional;
import lombok.Data;
import ma.emsi.main.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@Transactional
public interface StudentRepositories extends JpaRepository<Student , Integer> {
    List<Student> findByRegistrationNumber(String registrationNumber);
    List<Student> findByStillActivate(Boolean stillActive);
    List<Student> findByBirthday(Date Birthday);
    List<Student>  findByFullName(String fullName);
    List<Student>  findByLastConnection(Date lastConnection);
    List<Student> deleteByFullName(String ls);
    long deleteByStillActivate(Boolean stillActive);

    List<Student> findByIdIsLessThan(Integer id);
    List<Student> findByBirthdayLessThanEqual(Integer id);
}

