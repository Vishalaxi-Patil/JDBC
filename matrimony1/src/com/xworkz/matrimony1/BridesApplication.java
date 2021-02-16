package com.xworkz.matrimony1;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.dto.BrideDTO;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class BridesApplication {

	public static void main(String[] args) {
//		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
//		BrideDTO brideDTO=matrimonyDAO.getById(1);
//		//System.out.println(brideDTO);
//	    matrimonyDAO.getAllBride();
		
		MatrimonyDAO dao=new MatrimonyDAOImpl();
        
		MatrimonyService service=new MatrimonyServiceImpl(dao);
		BrideDTO brideDTO=service.getBrideById(2);
		if(brideDTO!=null) {
		System.out.println("getById:"+brideDTO);
		service.getAllBrides();
		
		
	}

}
}
