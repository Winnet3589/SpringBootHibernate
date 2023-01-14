package com.springboot.hibernate.services.demojdbc;

import com.springboot.hibernate.dtos.EmployeeDto;
import java.sql.SQLException;

public interface IJdbcEmployeeService {
  EmployeeDto findById(Long id) throws SQLException;
}
