package com.springboot.hibernate.controllers;

import com.springboot.hibernate.services.impl.AddressServiceImpl;
import com.springboot.hibernate.dtos.AddressDto;
import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.mappers.MapStructMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {

	private final AddressServiceImpl addressService;

	@GetMapping(value= "/addresses/dto")
	public List<AddressDto> listJobDto() {
		return MapStructMapper.INSTANCE.mapAddressFromEntityToDtoList(addressService.findAll());
	}

	@GetMapping(value= "/addresses")
	public List<Address> listAddress() {
		return addressService.findAll();
	}

	@PostMapping(value= "/addresses/save")
	public Address insert(@RequestBody AddressDto addressDto) {
		return addressService.save(MapStructMapper.INSTANCE.mapAddressFromDtoToEntity(addressDto));
	}

	@PostMapping(value= "/addresses/flusing/auto/priortocommitting")
	public ResponseEntity autoFlushingPriorToCommiting(@RequestBody AddressDto addressDto) {
		 addressService.autoFlushingPriorToCommiting(MapStructMapper.INSTANCE.mapAddressFromDtoToEntity(addressDto));
		 return ResponseEntity.ok("OK");
	}

	@PostMapping(value= "/addresses/flusing/auto/hqlquery")
	public ResponseEntity autoFlushingHqlQuery(@RequestBody AddressDto addressDto) {
		addressService.autoFlushingHqlQuery(MapStructMapper.INSTANCE.mapAddressFromDtoToEntity(addressDto));
		return ResponseEntity.ok("OK");
	}

	@PostMapping(value= "/addresses/flusing/auto/nativesql")
	public ResponseEntity autoFlushingNativeSql(@RequestBody AddressDto addressDto) {
		addressService.autoFlushingNativeSql(MapStructMapper.INSTANCE.mapAddressFromDtoToEntity(addressDto));
		return ResponseEntity.ok("OK");
	}

	@PostMapping(value= "/addresses/flusing/commit/hqlquery")
	public ResponseEntity commitFlushingHqlQuery(@RequestBody AddressDto addressDto) {
		addressService.commitFlushingHqlQuery(MapStructMapper.INSTANCE.mapAddressFromDtoToEntity(addressDto));
		return ResponseEntity.ok("OK");
	}

}
