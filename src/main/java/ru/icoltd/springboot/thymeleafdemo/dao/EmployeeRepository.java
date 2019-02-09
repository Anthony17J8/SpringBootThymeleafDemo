package ru.icoltd.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.icoltd.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
