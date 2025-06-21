	package com.Project.HaulageManagement.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.HaulageManagement.Entity.Country;
import com.Project.HaulageManagement.Entity.Haulage;
import com.Project.HaulageManagement.Entity.HaulageItems;
import com.Project.HaulageManagement.Service.CountryService;
import com.Project.HaulageManagement.Service.HaulageService;

@Controller
@RequestMapping("/haulage") 
public class HaulageController {
	@Autowired
	HaulageService haulageService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/haulageBooking")
	public String showHaulageForm(Model model) {
		Haulage haulage=new Haulage();
		String saveReceiver = "true";
		model.addAttribute("saveReceiver",saveReceiver);
		haulage.getHaulageItems().add(new HaulageItems());
		List<Country> countryList=countryService.getAll();
		model.addAttribute("countryList",countryList);
		model.addAttribute("haulage",haulage);
		 return "haulagebooking";
	}
	
	@PostMapping("/saveHaulage")
	public String saveHaulage(@ModelAttribute ("haulage") Haulage haulage,
			@RequestParam ("saveReceiver") String saveReceiver,
			@RequestParam (value="dontUseWeight", defaultValue = "false") boolean dontUseWeight,
			Model model,
			BindingResult bindingResult )
	{
		System.out.println("dontUseWeight: " + dontUseWeight);

		if (bindingResult.hasErrors()) {
			System.out.println("in if");
			return "haulagebooking";
		} else {

			if (dontUseWeight) {
				haulage.setHaulageItems(null);
			} else {
				for (HaulageItems item : haulage.getHaulageItems()) {
					item.setHualage(haulage);
				}

			}

			System.out.println("in else");

			haulageService.saveHaulage(haulage, Boolean.valueOf(saveReceiver));
			return "redirect:haulageBooking";
		}
	}

	@GetMapping("/manageHaulage")
	public String manageHaulage(Model model) {

		List<Haulage> getHaulageList = haulageService.getHaulageBooking();
		
		model.addAttribute("getHaulageList",getHaulageList);
		return "haulage-Manage";

	}
	@GetMapping("/deletehaulage")
	public String deletehaulage(@ModelAttribute("id")Integer id)
	{
		haulageService.deletehaulage(id);
		return "redirect:manageHaulage";
		
	}
	@GetMapping("/searchHaulage")
	public String searchHaulage(@RequestParam(value = "BookingCode", required = false) String BookingCode,
			@RequestParam(value = "trackingCode", required = false) String trackingCode,
			@RequestParam(value = "bookingdate", required = false) LocalDate bookingdate,
			@RequestParam(value = "clientName", required = false) LocalDate clientName,
			@RequestParam(value = "courierstatus", required = false) String courierstatus,
			@RequestParam(value = "startdate", required = false) LocalDate startdate,
			@RequestParam(value = "enddate", required = false) LocalDate enddate) {
	@SuppressWarnings("unused")
	List<Haulage> haulagelist = null;
		if (BookingCode != null) {
			haulagelist = haulageService.getHaulageByBookingCode(BookingCode);

		}
		return courierstatus;

	}
}