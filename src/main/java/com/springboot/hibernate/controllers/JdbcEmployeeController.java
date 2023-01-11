package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.CitizenIDCardInEmployeeDto;
import com.springboot.hibernate.enums.Gender;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JdbcEmployeeController {

  @Autowired
  private Environment env;

  @GetMapping(value = "jdbc/employees/dto/{id}")
  public EmployeeDto findById(@PathVariable Long id) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement preparedStatement = conn.prepareStatement(
        "SELECT * FROM \"EMPLOYEE\" e\n"
            + "JOIN \"CITIZEN_ID_CARD\" c ON e.\"CITIZEN_ID_CARD_ID\"  = c.\"ID\" \n"
            + "WHERE e.\"ID\"  = ?;");
    preparedStatement.setLong(1, id);
    ResultSet rs = preparedStatement.executeQuery();
    EmployeeDto employeeDto = null;
    CitizenIDCardInEmployeeDto citizenIDCardInEmployeeDto;
    while (rs.next()) { // will traverse through all rows

      citizenIDCardInEmployeeDto = CitizenIDCardInEmployeeDto.builder()
          .id(rs.getLong("ID"))
          .citizenIdNo(rs.getString("CITIZEN_ID_NO"))
          .city(rs.getString("CITY"))
          .country(rs.getString("COUNTRY"))
          .state(rs.getString("STATE"))
          .dayOfBirth(rs.getDate("DAY_OF_BIRTH"))
          .build();
      employeeDto = EmployeeDto.builder()
          .id(rs.getLong("CITIZEN_ID_CARD_ID"))
          .fullName(rs.getString("FULL_NAME"))
          .phoneNumber(rs.getString("PHONE_NUMBER"))
          .email(rs.getString("EMAIL"))
          .gender(Gender.fromCode(rs.getString("GENDER").toCharArray()[0]).name())
          .citizenIDCard(citizenIDCardInEmployeeDto)
          .build();
    }
    return employeeDto;
  }


  private Connection getConnection() {
    try {
      return DriverManager
          .getConnection(Objects.requireNonNull(env.getProperty("spring.datasource.url")),
              env.getProperty("spring.datasource.username"),
              env.getProperty("spring.datasource.password"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
