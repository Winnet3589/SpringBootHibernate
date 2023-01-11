package com.springboot.hibernate.controllers.demo_jdbc;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.services.demo_jdbc.JdbcEmployeeService;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JdbcEmployeeController {

  private final JdbcEmployeeService employeeService;
  @GetMapping(value = "jdbc/employees/dto/{id}")
  public EmployeeDto findById(@PathVariable Long id) throws SQLException {
    return employeeService.findById(id);
  }
}
