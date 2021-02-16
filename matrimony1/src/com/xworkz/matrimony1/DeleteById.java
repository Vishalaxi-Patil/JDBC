package com.xworkz.matrimony1;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class DeleteById {

	public static void main(String[] args) {

   MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
   
   MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
   int result=matrimonyService.validateAndDeleteById(1);
   if(result==1) {
	   System.out.println("deleted sucessfully");
   }else {
	   System.out.println("not deleted");
   }

	}

}
