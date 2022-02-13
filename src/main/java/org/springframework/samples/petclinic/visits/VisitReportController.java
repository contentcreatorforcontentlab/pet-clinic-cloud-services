package org.springframework.samples.petclinic.visits;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class VisitReportController {

	private final VetRepository vets;

	public VisitReportController(VetRepository vets) {
		this.vets = vets;
	}

	@GetMapping("/visits.html")
	public String getVisitReport(@RequestParam(defaultValue = "1") int page, Model model) {
		VisitRequest visitRequest = new VisitRequest(1, LocalDate.now(), LocalDate.now());
		model.addAttribute("visitRequest", visitRequest);
		model.addAttribute("vetList", vets.findAll());
		model.addAttribute("visitList", null);
		return "visits/visitList";
	}

	@PostMapping("/visits.html")
	public String postVisitReport(@Valid VisitRequest visitRequest, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("visitRequest", visitRequest);
			model.addAttribute("vetList", vets.findAll());
			model.addAttribute("visitList", null);
			return "visits/visitList";
		}

		LocalDate startDate = visitRequest.getStartDate();
		LocalDate endDate = visitRequest.getEndDate();
		int vetId = visitRequest.getVetId();

		// http://localhost:7071/vets/7/visits?startDate=01-01-2010&endDate=01-01-2020
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(
				"http://localhost:7071/vets/{vet}/visits?startDate={startDate}&endDate={endDate}", String.class, vetId,
				startDate, endDate);

		model.addAttribute("visitRequest", visitRequest);
		model.addAttribute("vetList", vets.findAll());

		if (result == null) {
			ArrayList<ReportVisit> visitList = new ArrayList<ReportVisit>();
			model.addAttribute("visitList", visitList);
		}
		else {
			try {
				ObjectMapper mapper = new ObjectMapper();
				ReportVisit[] visitArray = mapper.readValue(result, ReportVisit[].class);
				List<ReportVisit> visitList = Arrays.asList(visitArray);
				model.addAttribute("visitList", visitList);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return "visits/visitList";
	}

}
