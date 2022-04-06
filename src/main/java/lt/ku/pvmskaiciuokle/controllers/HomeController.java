package lt.ku.pvmskaiciuokle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String pvm(
			@RequestParam("kainaSuPVM") Double kainaSuPVM,
			@RequestParam("kiekis") Integer kiekis,
			Model model) {
		
		double vienetoKainaSuPVM = kainaSuPVM;
		double vienetoPVM = vienetoKainaSuPVM*17.3554/100;
		double vienetoKainaBePVM = vienetoKainaSuPVM - vienetoPVM;
		double bendrasPVM = vienetoPVM*kiekis;
		double bendraKainaBePVM = vienetoKainaSuPVM*kiekis-bendrasPVM;
		double bendraKainaSuPVM = vienetoKainaSuPVM*kiekis;
		
		model.addAttribute("vienetoKainaSuPVM",vienetoKainaSuPVM);
		model.addAttribute("vienetoPVM", vienetoPVM);
		model.addAttribute("vienetoKainaBePVM", vienetoKainaBePVM);
		model.addAttribute("bendrasPVM", bendrasPVM);
		model.addAttribute("bendraKainaBePVM", bendraKainaBePVM);
		model.addAttribute("bendraKainaSuPVM", bendraKainaSuPVM);
		model.addAttribute("kiekis", kiekis);
			
		return "results";
	}
}
