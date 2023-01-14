package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.CitizenIDCardDto;
import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.CitizenIDCardServiceImpl;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CitizenIDCardDController {

  private final CitizenIDCardServiceImpl citizenIDCardDService;
  private final EmployeeServiceImpl employeeService;

  @GetMapping(value = "/citizenidcards/dto")
  public List<CitizenIDCardDto> listCitizenIDCardDto() {
    return MapStructMapper.INSTANCE.mapCitizenIDCardFromEntityToDtoList(
        citizenIDCardDService.findAll());
  }

  @GetMapping(value = "/citizenidcards")
  public List<CitizenIDCard> listCitizenIDCard() {
    return citizenIDCardDService.findAll();
  }

  @GetMapping(value = "/citizenidcards/{id}")
  public CitizenIDCard findById(@PathVariable Long id) {
    return citizenIDCardDService.findById(id);
  }

  @GetMapping(value = "/citizenidcards/dto/{id}")
  public CitizenIDCardDto findByIdDto(@PathVariable Long id) {
    return MapStructMapper.INSTANCE.mapCitizenIDCardFromEntityToDto(
        citizenIDCardDService.findById(id));
  }
}
