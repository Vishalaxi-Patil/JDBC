package com.xworkz.matrimony1;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class UpdateBridePhoneById {

	public static void main(String[] args) {


		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
		int result=matrimonyService.ValidateUpdatePhoneById(2, "9098999999");
		if (result == 1) {
			System.out.println("Update Successfulyy");

		} else {
			System.out.println("cannot update ");
		}
		
	}

}
