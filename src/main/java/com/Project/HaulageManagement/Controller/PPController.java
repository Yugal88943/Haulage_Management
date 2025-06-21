package com.Project.HaulageManagement.Controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project.HaulageManagement.Entity.Product;
import com.Project.HaulageManagement.Entity.Purchase;
import com.Project.HaulageManagement.Repository.PurchaseRepository;


@Controller
@RequestMapping("/show")
public class PPController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@GetMapping("/show")
	public String showPurchase(Model model) {
		
		Purchase purchase = new Purchase();  
		purchase.getProduct().add(new Product());
		model.addAttribute("purchase", purchase);

		return "Purchase-Form";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("purchase") Purchase purchase) throws IOException {

		byte[] dp = purchase.getFile().getBytes();
		purchase.setDp(dp);

		
		System.out.println("purchase.getProduct().size() : "+purchase.getProduct().size());
		
		
		/*
		 * for (int i = 0; i < purchase.getProduct().size(); i++) {
		 * purchase.getProduct().get(i).setPurchase(purchase);
		 * 
		 * 
		 * }
		 */
		for(Product product:purchase.getProduct())
		{
			product.setPurchase(purchase);
			
		}
		purchaseRepository.save(purchase);
		return "redirect:show";

	}

}
