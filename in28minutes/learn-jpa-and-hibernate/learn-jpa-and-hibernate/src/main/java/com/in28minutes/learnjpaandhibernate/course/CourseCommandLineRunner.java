package com.in28minutes.learnjpaandhibernate.course;

import com.in28minutes.learnjpaandhibernate.Course;
import com.in28minutes.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "learn aws now!", "in28minutes"));
//        repository.insert(new Course(2, "learn azure now!", "in28minutes"));
//        repository.insert(new Course(3, "learn devOps now!", "in28minutes"));
//
//        repository.deleteById(2);
//
//        System.out.println(repository.findById(1));
//    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "learn aws now!", "in28minutes"));
        repository.save(new Course(3, "learn devOps now!", "in28minutes"));
        repository.save(new Course(2, "learn azure now!", "in28minutes"));

        repository.deleteById(2l);

        System.out.println(repository.findById(1l));
    }


}
