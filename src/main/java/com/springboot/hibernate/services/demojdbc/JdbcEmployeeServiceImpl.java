package com.springboot.hibernate.services.demojdbc;

import com.springboot.hibernate.controllers.demojdbc.JdbcGetConnection;
import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.BankCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.CitizenIDCardInEmployeeDto;
import com.springboot.hibernate.enums.Gender;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JdbcEmployeeServiceImpl implements IJdbcEmployeeService {

  @Autowired
  private Environment env;

  @Override
  public EmployeeDto findById(Long id) throws SQLException {
    PreparedStatement preparedStatement = new JdbcGetConnection(env).getConnection().prepareStatement(
        "SELECT * FROM \"EMPLOYEE\" e\n"
            + "JOIN \"CITIZEN_ID_CARD\" c ON e.\"CITIZEN_ID_CARD_ID\"  = c.\"ID\" \n"
            + "JOIN \"BANK_CARD\" b ON b.\"EMPLOYEE_ID\"  = e.\"ID\" \n"
            + "WHERE e.\"ID\"  = ?;");
    preparedStatement.setLong(1, id);
    ResultSet rs = preparedStatement.executeQuery();
    EmployeeDto employeeDto = null;
    BankCardInEmployeeDto bankCardDto;
    List<BankCardInEmployeeDto> bankCardInEmployeeDtos = new ArrayList<>();
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
      bankCardDto = BankCardInEmployeeDto.builder()
//          .id(rs.getLong("ID"))
          .bankCardName(rs.getString("BANK_CARD_NAME"))
          .bankCardNo(rs.getString("BANK_CARD_NO"))
          .bankCardSerial(rs.getString("BANK_CARD_SERIAL"))
          .build();
      bankCardInEmployeeDtos.add(bankCardDto);
      employeeDto = EmployeeDto.builder()
          .id(rs.getLong("CITIZEN_ID_CARD_ID"))
          .fullName(rs.getString("FULL_NAME"))
          .phoneNumber(rs.getString("PHONE_NUMBER"))
          .email(rs.getString("EMAIL"))
          .gender(Gender.fromCode(rs.getString("GENDER").toCharArray()[0]).name())
          .citizenIDCard(citizenIDCardInEmployeeDto)
          .bankCards(bankCardInEmployeeDtos)
          .build();

    }
    return employeeDto;
  }
}
