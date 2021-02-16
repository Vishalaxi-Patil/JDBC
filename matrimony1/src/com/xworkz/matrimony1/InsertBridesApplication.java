package com.xworkz.matrimony1;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.dto.BrideDTO;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class InsertBridesApplication {

	public static void main(String[] args) {
		
		//two brides into DB
		BrideDTO bride=new BrideDTO();
		bride.setId(7);
		bride.setName("Anusha");
		bride.setAge(28);
		bride.setHeight(6.5);
		bride.setWeight(45.0);
		bride.setQualification("Engineer");
		bride.setCast("Hindu");
		bride.setPhoneNumber("7876567890");
		bride.setAddress("Mumbai");
		bride.setOccupation("Full stack developer");
		bride.setExpectation("Good");
		bride.setSalary(70000);
		
		BrideDTO bride2= new BrideDTO();
		bride2.setId(8);
		bride2.setName("lalita");
		bride2.setAge(25);
		bride2.setHeight(6.1);
		bride2.setWeight(45.0);
		bride2.setQualification("B.E");
		bride2.setCast("Hindu");
		bride2.setPhoneNumber("78790876545");
		bride2.setAddress("Chinna");
		bride2.setOccupation("Engineer");
		bride2.setExpectation("no existing loan");
		bride2.setSalary(50000);
		
		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
		
		List<BrideDTO> brideDTOs=new ArrayList<BrideDTO>();
		brideDTOs.add(bride);
		brideDTOs.add(bride2);
		int[] results=matrimonyService.validateAndInsertBrides(brideDTOs);
		for (int i = 0; i < results.length; i++) {
			if(results[i]==0) {
				System.out.println(brideDTOs.get(i).getName()+" bride failed to create");
				
			}else {
				System.out.println(brideDTOs.get(i).getName()+" bride sucessfully");
				
			}
			
		}
		
		
		
		
		

	}

}
