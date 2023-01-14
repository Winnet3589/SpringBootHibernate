package com.springboot.hibernate.mappers;


import com.springboot.hibernate.dtos.AddressDto;
import com.springboot.hibernate.dtos.BankCardDto;
import com.springboot.hibernate.dtos.BankCardDto.EmployeeInBankCardDto;
import com.springboot.hibernate.dtos.CitizenIDCardDto;
import com.springboot.hibernate.dtos.CitizenIDCardDto.EmployeeInCitizenIDCardDto;
import com.springboot.hibernate.dtos.CompanyDto;
import com.springboot.hibernate.dtos.CompanyDto.DepartmentInCompanyDto;
import com.springboot.hibernate.dtos.DepartmentDto;
import com.springboot.hibernate.dtos.DepartmentDto.CompanyInDepartmentDto;
import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.BankCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.CitizenIDCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.JobInEmployeeDto;
import com.springboot.hibernate.dtos.JobDto;
import com.springboot.hibernate.dtos.JobDto.EmployeeInJobDto;
import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.entities.Job;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {

  MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

  // 1.CitizenIDCard
  CitizenIDCardDto mapCitizenIDCardFromEntityToDto(CitizenIDCard citizenIDCard);

  List<CitizenIDCardDto> mapCitizenIDCardFromEntityToDtoList(List<CitizenIDCard> citizenIDCardList);

  EmployeeInCitizenIDCardDto mapEmployeeFromEntityToDto_InCitizenIDCard(Employee employee);

  // 2.Employee
  EmployeeDto mapEmployeeFromEntityToDto(Employee employee);

  List<EmployeeDto> mapEmployeeFromEntityToDtoList(List<Employee> employee);

  CitizenIDCardInEmployeeDto mapCitizenIDCardFromEntityToDto_InEmployee(
      CitizenIDCard citizenIDCard);

  JobInEmployeeDto mapJobFromEntityToDto_InEmployee(Job job);

  List<JobInEmployeeDto> mapJobFromEntityToDto_InEmployee(List<Job> jobList);

  BankCardInEmployeeDto mapBankCardDtoFromEntityToDtoList_InEmployee(BankCard bankCard);

  List<BankCardInEmployeeDto> mapBankCardDtoFromEntityToDtoList_InEmployee(
      List<BankCard> bankCardList);

  // 3.Job
  JobDto mapJobFromEntityToDto(Job job);

  EmployeeInJobDto mapJobFromEntityToDtoList_InJob(Job job);

  List<EmployeeInJobDto> mapJobFromEntityToDtoList_InJob(List<Job> jobList);

  List<JobDto> mapJobFromEntityToDtoList(List<Job> job);

  //4.Bank card
  BankCardDto mapBankCardFromEntityToDto(BankCard bankCard);

  List<BankCardDto> mapBankCardFromEntityToDtoList(List<BankCard> bankCardList);

  EmployeeInBankCardDto mapEmployeeFromEntityToDto_InBankCard(Job job);

  //5.Address
  AddressDto mapAddressFromEntityToDto(Address address);

  Address mapAddressFromDtoToEntity(AddressDto address);

  List<AddressDto> mapAddressFromEntityToDtoList(List<Address> address);

  List<Address> mapAddressFromDtoToEntityList(List<AddressDto> addressDtoList);

  //6.Company
  CompanyDto mapCompanyFromEntityToDto(Company company);

  List<CompanyDto> mapCompanyFromEntityToDtoList(List<Company> companyList);

  DepartmentInCompanyDto mapDepartmentDtoFromEntityToDtoList_InCompany(Department department);

  List<DepartmentInCompanyDto> mapDepartmentDtoFromEntityToDtoList_InCompany(List<Department> departmentList);

  // 7.Department
  DepartmentDto mapDepartmentFromEntityToDto(Department department);
  Department mapDepartmentFromDtoToEntity(DepartmentDto departmentDto);

  List<DepartmentDto> mapDepartmentFromEntityToDtoList(List<Department> departmentList);
  List<Department> mapDepartmentFromDtoToEntity(List<DepartmentDto> departmentDtoList);

  CompanyInDepartmentDto mapCompanyFromEntityToDto_InDepartment(Company company);
  Company mapCompanyFromDtoToEntity_InDepartment(CompanyInDepartmentDto company);

}
