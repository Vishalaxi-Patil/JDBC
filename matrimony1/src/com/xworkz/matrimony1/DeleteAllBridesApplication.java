package com.xworkz.matrimony1;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony1.dto.BrideDTO;
import com.xworkz.matrimony1.service.MatrimonyService;
import com.xworkz.matrimony1.service.MatrimonyServiceImpl;

public class DeleteAllBridesApplication {

	public static void main(String[] args) {
		
		MatrimonyDAO matrimonyDAO=new MatrimonyDAOImpl();
		MatrimonyService matrimonyService=new MatrimonyServiceImpl(matrimonyDAO);
		List<Integer> list=new ArrayList<Integer>();
		int[] result=matrimonyService.validateAndDeleteAllBrides(list);
		for (int i = 0; i < result.length; i++) {
			if(result[i]==0) {
				System.out.println("not deleted");
			}else {
				System.out.println("deleted");
			}
			
		}
	}

	}


