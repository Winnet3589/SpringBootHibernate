package com.springboot.hibernate.controllers.demojdbc;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.services.demojdbc.JdbcEmployeeServiceImpl;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JdbcEmployeeController {

  private final JdbcEmployeeServiceImpl employeeService;
  @GetMapping(value = "jdbc/employees/dto/{id}")
  public EmployeeDto findById(@PathVariable Long id) throws SQLException {
    return employeeService.findById(id);
  }
}
