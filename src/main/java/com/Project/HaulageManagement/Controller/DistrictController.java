package com.Project.HaulageManagement.Controller;

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
import com.Project.HaulageManagement.Entity.District;
import com.Project.HaulageManagement.Entity.State;
import com.Project.HaulageManagement.Service.CountryService;
import com.Project.HaulageManagement.Service.DistrictService;
import com.Project.HaulageManagement.Service.StateService;

@Controller
@RequestMapping("district")
public class DistrictController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private DistrictService districtService;

	@GetMapping("district")
	public String getAll(Model model) {

		List<District> districtList = districtService.getAll();
		model.addAttribute("districtList", districtList);
		model.addAttribute("district", new District());

//		List<State> stateList = stateService.getAll();
//		model.addAttribute("stateList", stateList);

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);

		return "District";

	}

	@PostMapping("saveDistrict")
	public String save(Model model, @ModelAttribute("district") District district, BindingResult bindingResult) {

		@SuppressWarnings("unused")
		List<Country> countryList = countryService.getAll();
//		List<State> stateList = stateService.getAll();s
		List<District> districtList = districtService.getAll();

		if (district.getState() == null || district.getState().getCountry() == null || district.getState().getCountry().getId() == null) {
			bindingResult.rejectValue("state.country.id", "", "Please select country");
		}
		
		if (district.getState() == null || district.getState().getId() == null) {
			bindingResult.rejectValue("state.id", "", "Please select state");
		}
		

		if (bindingResult.hasErrors()) {

			if (district.getState().getCountry().getId() != null) {

				List<State> stateList = stateService.getStateByCountryId(district.getState().getCountry().getId());
				model.addAttribute("stateList", stateList);
			}

			model.addAttribute("districtList", districtList);
			return "District";

		} else {

			districtService.saveDistrict(district);
			model.addAttribute("districtList", districtList);
			return "redirect:district";

		}

	}

	@GetMapping("update")
	public String update(Model model, @ModelAttribute("id") Long id) {

		List<District> districtList = districtService.getAll();
		model.addAttribute("districtList", districtList);

		List<State> stateList = stateService.getAll();
		model.addAttribute("stateList", stateList);

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);
		
		District district = districtService.update(id);
		model.addAttribute("district", district);

		
		return "District";

	}

	@GetMapping("delete")
	public String delete(Long id) {

		districtService.delete(id);
		return "redirect:district";
	}

	@GetMapping("getStateByCountryId")
	public String getStateByCountryId(@ModelAttribute("id") Long id, @RequestParam("action") String action, Model model) {

		List<State> stateList = stateService.getStateByCountryId(id);
		model.addAttribute("stateList", stateList);
		model.addAttribute("action",action);
//		System.out.println("Hello :"+stateList.size());
		return "ajax";

	}
	@GetMapping("getDistrictByStateId")
	public String getDistrictByStateId(@ModelAttribute("id") Long id, @RequestParam("action") String action, Model model)
	{
		List<District> districtList = districtService.getDistrictByStateId(id);
		model.addAttribute("districtList",districtList);
		model.addAttribute("action",action);
		
		return "ajax";
	}

}
