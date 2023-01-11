package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.BankCardDto;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.BankCardServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BankCardController {

	private final BankCardServiceImpl bankCardService;

	@GetMapping(value= "/bankcards/dto")
	public List<BankCardDto> listBankCardDto() {
		return MapStructMapper.INSTANCE.mapBankCardFromEntityToDtoList(bankCardService.findAll());
	}

	@GetMapping(value= "/bankcards")
	public List<BankCard> listBankCard() {
		return bankCardService.findAll();
	}
}
