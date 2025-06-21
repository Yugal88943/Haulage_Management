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

import com.Project.HaulageManagement.Entity.Country;
import com.Project.HaulageManagement.Entity.State;
import com.Project.HaulageManagement.Service.CountryService;
import com.Project.HaulageManagement.Service.StateService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("state")
public class StateController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@GetMapping("state")
	public String getAll(Model model) {

		List<State> stateList = stateService.getAll();
		model.addAttribute("stateList", stateList);
		model.addAttribute("state", new State());

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);

		return "State";

	}

	@PostMapping("saveState")
	public String saveState(@Valid @ModelAttribute("state") State state,  BindingResult bindingResult, Model model) {

		List<Country> countryList = countryService.getAll();
		List<State> stateList = stateService.getAll();

		if (state.getCountry().getId() == null) {
			bindingResult.rejectValue("country.id", "", "please select Country");
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("stateList", stateList);
			model.addAttribute("countryList", countryList);
			return "State";

		} else {

			stateService.saveState(state); 
					 
			return "redirect:state";
		}
	}

	@GetMapping("update")
	public String update(@ModelAttribute("id") Long id, Model model) {

		List<State> stateList = stateService.getAll();
		model.addAttribute("stateList", stateList);

		State state = stateService.update(id);
		model.addAttribute("state", state);

		List<Country> countryList = countryService.getAll();
		model.addAttribute("countryList", countryList);

		return "State";

	}

	@GetMapping("delete")
	public String delete(Long id) {

		stateService.delete(id);
		return "redirect:state";
	}
 @GetMapping("/getStateByCountryId")
 public String getStateByCountryId(@ModelAttribute("id")Long id,@ModelAttribute("action")String action,Model model)
 {
	List<State> stateList= stateService.getStateByCountryId(id);
	model.addAttribute("stateList", stateList);
	model.addAttribute("action",action);
	
	
	
	 
	return "ajax";
	 
 }
 
}
