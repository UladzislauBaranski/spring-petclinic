package org.springframework.samples.petclinic.owner;

import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.samples.petclinic.converters.PetConverter;
import org.springframework.samples.petclinic.owner.dto.PetDto;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VisitApiController {
	private final VisitRepository visitRepository;

	public VisitApiController(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@GetMapping("/status")
	public void getStatusActiveById(@RequestParam("id") Integer visitId, @RequestParam("status") Boolean status) {
		visitRepository.getStatusActiveById(visitId, status);
	}

	@GetMapping("/visit-by-id")
	public Boolean getVisitById(@RequestParam("id") Integer visitId) {
		Visit visitById = visitRepository.findById(visitId);
		Boolean active = visitById.getActive();
		String message = active ? "visit is active" : "visit canceled";
		System.out.println(message);
		return active;
	}
}
