package ma.emsi.main;

import ma.emsi.main.entities.Student;
import ma.emsi.main.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private StudentRepositories studentRepositories;
    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
    @Override
    public void run(String... args) throws  Exception{
        System.out.println("************** Insertion ************");

        studentRepositories.save(
                new Student(null, "A1","Amine", new Date(), true , null));
        studentRepositories.save(
                new Student(null, "A2","Ilyas", new Date(), true , null));
        studentRepositories.save(
                new Student(null, "A3","Saad", new Date(), false , null));
        studentRepositories.save(
                new Student(null, "A4","Arij", new Date(), true , null));
        studentRepositories.save(
                new Student(null, "A5","Lina", new Date(), false , null));

        System.out.println("************ Inserted rows ***********");
        System.out.println("Count: " + studentRepositories.count());

        System.out.println("******* Display ********");
        List<Student> students = studentRepositories.findAll();
        students.forEach(student -> { System.out.println(student.toString());});

        System.out.println("******* Get Element By ID ********");
        Student student = studentRepositories.findById(3).orElse(null);
        System.out.println(student.toString());

        System.out.println("*********** Update an Element *****");
        student.setRegistrationNumber("S3");
        studentRepositories.save(student);

        System.out.println("******* Delete an Element ******");
        studentRepositories.delete(student);
        System.out.println("Count:" +studentRepositories.count());

        studentRepositories.deleteById(5);
        System.out.println("Count: " +studentRepositories.count());

        System.out.println("****** Select active students *****");
        List<Student> activeStudents = studentRepositories.findByStillActivate(true);
        activeStudents.forEach(s -> {
            System.out.println(s.toString());
        });
    }
}
