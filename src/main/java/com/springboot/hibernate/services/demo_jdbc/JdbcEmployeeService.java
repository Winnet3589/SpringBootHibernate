package com.springboot.hibernate.services.demo_jdbc;

import com.springboot.hibernate.controllers.demo_jdbc.JdbcGetConnection;
import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.CitizenIDCardInEmployeeDto;
import com.springboot.hibernate.enums.Gender;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JdbcEmployeeService implements IJdbcEmployeeService {

  @Autowired
  private Environment env;

  @Override
  public EmployeeDto findById(Long id) throws SQLException {
    PreparedStatement preparedStatement = new JdbcGetConnection(env).getConnection().prepareStatement(
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
}
