package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.converters.PetConverter;
import org.springframework.samples.petclinic.owner.dto.PetDto;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PetApiController {

	private final PetRepository petRepository;

	public PetApiController(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@GetMapping("/pets/by-owner-id")
	public List<PetDto> getListPetsAtOwnerByPetId(@RequestParam("id") int ownerId) {
		List<Pet> petById = petRepository.findPetById(ownerId);
		return petById.stream().map(PetConverter::getDTOFromObject).collect(Collectors.toList());
	}
}
