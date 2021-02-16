package com.xworkz.matrimony1;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.dto.BrideDTO;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class CreateBrideApplication {

	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);

		BrideDTO bride = new BrideDTO();

		bride.setId(6);
		bride.setName("Vidya");
		bride.setAge(23);
		bride.setHeight(5.5);
		bride.setWeight(50.0);
		bride.setQualification("BCA");
		bride.setCast("Hindu");
		bride.setPhoneNumber("8978909879");
		bride.setAddress("Gadag");
		bride.setOccupation("Trainee");
		bride.setExpectation("Good Behaviour");
		bride.setSalary(70000);

		int result = matrimonyService.validateAndSave(bride);
		if (result == 1) {
			System.out.println("Bride created succesfully");

		} else {
			System.out.println("Failed to create Bride");
		}

	}

}
