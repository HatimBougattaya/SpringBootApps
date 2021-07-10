package ma.enset.tpjpa.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.enset.tpjpa.entities.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;

@Controller
public class PatientsController {
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path = "/patients")
	public String list(Model model,
			@RequestParam(name="pg",defaultValue="0")int page ,
			@RequestParam(name="sz", defaultValue="3")int size,
			@RequestParam(name="keyword", defaultValue="")String keyW ){
		//List<Patient> patients= patientRepository.findAll();
		Page<Patient> pagePatients = patientRepository.findByNameContainingIgnoreCase(keyW,PageRequest.of(page, size)) ;
		model.addAttribute("patients", pagePatients);
		model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("keyword", keyW);
		return "patients";
	}
	@GetMapping(path = "/deletePatient")
	public String delete(Long id,String keyW,int page,int size) {
		patientRepository.deleteById(id);
		return "redirect:/patients?pg="+page+"&sz="+size+"&keyword="+keyW ;
	}
	@GetMapping(path = "/updatePatient")
	public String update(Model model,Long id) {
		Patient p = patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		model.addAttribute("mode", "edit");
		return "formPatient" ;
	}
	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("mode", "new");
		return "formPatient";
	}
	
	@PostMapping(path = "/savePatient")
	public String savePatient(Model model,@Valid Patient patient, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formPatient";
		patientRepository.save(patient);
		model.addAttribute("patient",patient);
		return "confirmation";
	}
	
	@GetMapping(path = "/patients/{id}")
	@ResponseBody
	public Patient patients(@PathVariable Long id) {
		return patientRepository.findById(id).get();
	}
	
}
