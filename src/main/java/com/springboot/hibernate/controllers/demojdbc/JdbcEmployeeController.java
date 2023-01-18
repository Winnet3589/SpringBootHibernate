package com.springboot.hibernate.controllers.demojdbc;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.services.demojdbc.JdbcEmployeeServiceImpl;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JdbcEmployeeController {

  private final JdbcEmployeeServiceImpl employeeService;
  @GetMapping(value = "jdbc/employees/dto/{id}")
  public ResponseEntity findById(@PathVariable Long id) throws SQLException {
    EmployeeDto e = employeeService.findById(id);
    return e != null ? ResponseEntity.ok(e): ResponseEntity.ok("Not found with id = "+ id);
  }
}
