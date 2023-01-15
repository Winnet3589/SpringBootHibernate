package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.DepartmentDto;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.DepartmentServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentServiceImpl departmentService;

  @GetMapping(value = "/departments/dto")
  public List<DepartmentDto> listDepartmentDto() {
    return MapStructMapper.INSTANCE.mapDepartmentFromEntityToDtoList(
        departmentService.findAll());
  }

  @GetMapping(value = "/departments")
  public List<Department> listDepartment() {
    return departmentService.findAll();
  }

  @GetMapping(value = "/departments/{id}")
  public Department findById(@PathVariable Long id) {
    return departmentService.findById(id);
  }

  @GetMapping(value = "/departments/delete/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    int rt = departmentService.delete(id);
    return ResponseEntity.ok(rt > 0 ? "Delete successful!" : "Delete failed!");
  }


  @GetMapping(value = "/departments/dto/{id}")
  public DepartmentDto findByIdDto(@PathVariable Long id) {
    return MapStructMapper.INSTANCE.mapDepartmentFromEntityToDto(departmentService.findById(id));
  }

  // Casecade
  @PostMapping(value = "/departments/save")
  public Department insert(@RequestBody DepartmentDto departmentDto) {
    return departmentService.save(
        MapStructMapper.INSTANCE.mapDepartmentFromDtoToEntity(departmentDto));
  }

  // Batch process
  @PostMapping(value = "/departments/save/batch")
  public int insertBatch(@RequestBody DepartmentDto departmentDto,
      @RequestParam int numberOfRecords) {
    return departmentService.insertBatch(
        MapStructMapper.INSTANCE.mapDepartmentFromDtoToEntity(departmentDto), numberOfRecords);
  }

  @PostMapping(value = "/departments/save/notbatch")
  public int insertNotBatch(@RequestBody DepartmentDto departmentDto,
      @RequestParam int numberOfRecords) {
    return departmentService.insertNotBatch(
        MapStructMapper.INSTANCE.mapDepartmentFromDtoToEntity(departmentDto), numberOfRecords);
  }

  // Cache
  @GetMapping(value = "/departments/firstLevelCacheSameSession/{id}")
  public ResponseEntity firstLevelCacheSameSession(@PathVariable Long id) {
    departmentService.firstLevelCacheSameSession(id);
    return ResponseEntity.ok("OK");
  }

  @GetMapping(value = "/departments/firstLevelCacheDiffSession/{id}")
  public ResponseEntity firstLevelCacheDiffSession(@PathVariable Long id) {
    departmentService.firstLevelCacheDiffSession(id);
    return ResponseEntity.ok("OK");
  }
}
