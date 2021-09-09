package org.springframework.samples.petclinic.converters;


import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.dto.OwnerDto;
import org.springframework.samples.petclinic.owner.dto.PetDto;
import org.springframework.samples.petclinic.owner.dto.PetTypeDto;

public class PetConverter {
	public static Pet getObjectFromDTO(PetDto petDto) {
		final Pet pet = new Pet();
		pet.setId(petDto.getId());
		pet.setName(petDto.getName());
		pet.setBirthDate(petDto.getBirthDate());

		if (petDto.getPetTypeDto() != null) {
			PetType petType = new PetType();
			petType.setId(petDto.getPetTypeDto().getId());
			petType.setName(petDto.getPetTypeDto().getName());

			pet.setType(petType);
		}

		if (petDto.getOwnerDto() != null) {
			Owner owner = new Owner();
			owner.setId(petDto.getOwnerDto().getId());
			owner.setFirstName(petDto.getOwnerDto().getFirstName());
			owner.setLastName(petDto.getOwnerDto().getLastName());
			owner.setAddress(petDto.getOwnerDto().getAddress());
			owner.setCity(petDto.getOwnerDto().getCity());
			owner.setTelephone(petDto.getOwnerDto().getTelephone());
			pet.setOwner(owner);
		}
		return pet;
	}


	public static PetDto getDTOFromObject(Pet pet) {
		final PetDto petDto = new PetDto();
		petDto.setId(pet.getId());
		petDto.setName(pet.getName());
		petDto.setBirthDate(pet.getBirthDate());

		if (pet.getType() != null) {
			PetTypeDto petTypeDto = new PetTypeDto();
			petTypeDto.setId(pet.getType().getId());
			petTypeDto.setName(pet.getType().getName());

			petDto.setPetTypeDto(petTypeDto);
		}

		if (pet.getOwner() != null) {
			OwnerDto ownerDto = new OwnerDto();
			ownerDto.setId(pet.getOwner().getId());
			ownerDto.setFirstName(pet.getOwner().getFirstName());
			ownerDto.setLastName(pet.getOwner().getLastName());
			ownerDto.setAddress(pet.getOwner().getAddress());
			ownerDto.setCity(pet.getOwner().getCity());
			ownerDto.setTelephone(pet.getOwner().getTelephone());
			petDto.setOwnerDto(ownerDto);
		}
		return petDto;
	}
}
