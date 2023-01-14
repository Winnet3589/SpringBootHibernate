package com.springboot.hibernate.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.hibernate.dtos.DepartmentDto;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.DepartmentServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentServiceImpl departmentService;

//  @GetMapping(value = "/departments/dto")
//  public List<DepartmentDto> listDepartmentDto() {
//    return MapStructMapper.INSTANCE.mapDepartmentFromEntityToDtoList(
//        DepartmentService.findAll());
//  }

  @GetMapping(value = "/departments")
  public List<Department> listDepartment() {
    return departmentService.findAll();
  }

  @GetMapping(value = "/departments/{id}")
  public Department findById(@PathVariable Long id) throws JsonProcessingException {
    return departmentService.findById(id);
  }

  @PostMapping(value = "/departments/save")
  public Department insert(@RequestBody DepartmentDto departmentDto) {
    return departmentService.save(
        MapStructMapper.INSTANCE.mapDepartmentFromDtoToEntity(departmentDto));
  }

//  @GetMapping(value = "/departments/dto/{id}")
//  public DepartmentDto findByIdDto(@PathVariable Long id) {
//    return MapStructMapper.INSTANCE.mapDepartmentFromEntityToDto(DepartmentService.findById(id));
//  }
}
