package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.CompanyDto;
import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.CompanyServiceImpl;
import com.springboot.hibernate.utils.InvalidPayloadException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyController {

  private final CompanyServiceImpl companyService;

  @PostMapping(value = "/companies/save")
  public Company insert(@Valid @RequestBody CompanyDto departmentDto) throws InvalidPayloadException {
    return companyService.save(
        MapStructMapper.INSTANCE.mapCompanyFromDtoToEntity(departmentDto));
  }

  @GetMapping(value = "/companies/dto")
  public List<CompanyDto> listCompanyDto() {
    return MapStructMapper.INSTANCE.mapCompanyFromEntityToDtoList(
        companyService.findAll());
  }

  @GetMapping(value = "/companies")
  public List<Company> listCompany() {
    return companyService.findAll();
  }

  @GetMapping(value = "/companies/{id}")
  public Company findById(@PathVariable Long id)  {
    Company rs = companyService.findById(id);

    // Demo Lazy
    List<Department> departments = rs.getDepartments();
    return rs;
  }

  @GetMapping(value = "/companies/findByIdLazyEx/{id}")
  public Company findByIdLazyEx(@PathVariable Long id)  {
    Company rs = companyService.findByIdLazyEx(id);

    // Demo Lazy
    List<Department> departments = rs.getDepartments();
    return rs;
  }

  @GetMapping(value = "/companies/dto/{id}")
  public CompanyDto findByIdDto(@PathVariable Long id) {
    return MapStructMapper.INSTANCE.mapCompanyFromEntityToDto(companyService.findById(id));
  }

  //Cascade
  @GetMapping(value = "/companies/delete/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    int rt = companyService.delete(id);
    return ResponseEntity.ok(rt > 0 ? "Delete successful!" : "Delete failed!");
  }
}
