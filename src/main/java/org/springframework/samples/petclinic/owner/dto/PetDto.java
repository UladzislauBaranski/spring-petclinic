package org.springframework.samples.petclinic.owner.dto;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDto {
	private Integer id;
	private String name;
	private String model;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDate birthDate;
	OwnerDto ownerDto;
	PetTypeDto petTypeDto;
}
