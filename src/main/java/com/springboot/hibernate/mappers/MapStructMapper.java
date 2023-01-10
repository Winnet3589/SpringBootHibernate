package com.springboot.hibernate.mappers;


import com.springboot.hibernate.dtos.BankCardDto.EmployeeInBankCardDto;
import com.springboot.hibernate.dtos.CitizenIDCardDto;
import com.springboot.hibernate.dtos.CitizenIDCardDto.EmployeeInCitizenIDCardDto;
import com.springboot.hibernate.dtos.BankCardDto;
import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.CitizenIDCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.BankCardInEmployeeDto;
import com.springboot.hibernate.dtos.EmployeeDto.JobInEmployeeDto;
import com.springboot.hibernate.dtos.JobDto;
import com.springboot.hibernate.dtos.JobDto.EmployeeInJobDto;
import com.springboot.hibernate.entities.CitizenIDCard;
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
  // 1.CitizenIDCard
  CitizenIDCardDto mapCitizenIDCardFromEntityToDto(CitizenIDCard citizenIDCard);

  List<CitizenIDCardDto> mapCitizenIDCardFromEntityToDtoList(List<CitizenIDCard> citizenIDCards);
  EmployeeInCitizenIDCardDto mapEmployeeFromEntityToDto_InCitizenIDCard(Employee employee);

  // 2.Employee
  EmployeeDto mapEmployeeFromEntityToDto(Employee employee);
  List<EmployeeDto> mapEmployeeFromEntityToDtoList(List<Employee> employee);

  CitizenIDCardInEmployeeDto mapCitizenIDCardFromEntityToDto_InEmployee(CitizenIDCard citizenIDCard);
  JobInEmployeeDto mapJobFromEntityToDto_InEmployee(Job job);
  List<JobInEmployeeDto> mapJobFromEntityToDto_InEmployee(List<Job> job);
  BankCardInEmployeeDto mapBankCardDtoFromEntityToDtoList_InEmployee(BankCard bankCard);
  List<BankCardInEmployeeDto> mapBankCardDtoFromEntityToDtoList_InEmployee(List<BankCard> bankCard);

  // 3.Job
  JobDto mapJobFromEntityToDto(Job job);
  EmployeeInJobDto mapJobFromEntityToDtoList_InJob(Job job);
  List<EmployeeInJobDto> mapJobFromEntityToDtoList_InJob(List<Job> job);
  List<JobDto> mapJobFromEntityToDtoList(List<Job> job);

  //4.Bank card
  BankCardDto mapBankCardFromEntityToDto(BankCard bankCard);
  List<BankCardDto> mapBankCardFromEntityToDtoList(List<BankCard> bankCard);
  EmployeeInBankCardDto mapEmployeeFromEntityToDto_InBankCard(Job job);

  // II.Dto -> entity

  // III.Others
}
