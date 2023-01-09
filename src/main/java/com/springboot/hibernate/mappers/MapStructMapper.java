package com.springboot.hibernate.mappers;


import com.springboot.hibernate.dtos.AddressDto;
import com.springboot.hibernate.dtos.AddressDto.EmployeeInAddressDto;
import com.springboot.hibernate.dtos.BankCardDto;
import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.AddressInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.BankCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.JobInEmployeeDto;
import com.springboot.hibernate.dtos.JobDto;
import com.springboot.hibernate.dtos.JobDto.EmployeeInJobDto;
import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.entities.Job;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {
  MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

  // I.Entity -> Dto
  // 1.Address
  AddressDto mapAddressFromEntityToDto(Address address);

  List<AddressDto> mapAddressFromEntityToDtoList(List<Address> address);
  EmployeeInAddressDto mapEmployeeFromEntityToDto_InAddress(Employee employee);

  // 2.Employee
  EmployeeDto mapEmployeeFromEntityToDto(Employee employee);
  List<EmployeeDto> mapEmployeeFromEntityToDtoList(List<Employee> employee);

  AddressInEmployeeDto mapAddressFromEntityToDto_InEmployee(Address address);
  JobInEmployeeDto mapJobFromEntityToDto_InEmployee(Job job);
  List<JobInEmployeeDto> mapJobFromEntityToDto_InEmployee(List<Job> job);
  BankCardInEmployeeDto mapBankCardDtoFromEntityToDto_InEmployee(BankCard bankCard);
  List<BankCardInEmployeeDto> mapBankCardDtoFromEntityToDto_InEmployee(List<BankCard> bankCard);

  // 3.Job
  JobDto mapJobFromEntityToDto(Job job);
  EmployeeInJobDto mapJobFromEntityToDto_InJob(Job job);
  List<EmployeeInJobDto> mapJobFromEntityToDto_InJob(List<Job> job);
  List<JobDto> mapJobFromEntityToDtoList(List<Job> job);

  //4.Bank card
  BankCardDto mapBankCardFromEntityToDto(BankCard bankCard);
  List<BankCardDto> mapBankCardFromEntityToDtoList(List<BankCard> bankCard);

  // II.Dto -> entity

  // III.Others
}
