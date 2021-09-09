package org.springframework.samples.petclinic.owner.dto;

import lombok.Data;

@Data
public class OwnerDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;

}
