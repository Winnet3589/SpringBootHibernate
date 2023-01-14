package com.springboot.hibernate.controllers.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import org.springframework.core.env.Environment;

public class JdbcGetConnection {
  private Environment env;

  public JdbcGetConnection(Environment env) {
    this.env = env;
  }

  public Connection getConnection() {
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
