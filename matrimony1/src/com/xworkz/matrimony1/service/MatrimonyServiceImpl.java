package com.xworkz.matrimony1.service;

import java.util.List;

import com.xworkz.matrimony1.dao.MatrimonyDAO;
import com.xworkz.matrimony1.dto.BrideDTO;

public class MatrimonyServiceImpl implements MatrimonyService{
	
	private MatrimonyDAO matrimonyDAO;
	
	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO=matrimonyDAO;
	}

	@Override
	public BrideDTO getBrideById(int id) {
		if(0==id) {
			System.out.println("invalid id");
			return null;
		}
		return matrimonyDAO.getById(id);
	}

	@Override
	public BrideDTO getAllBrides() {
		
		return matrimonyDAO.getAllBride();
	}

	@Override
	public int validateAndSave(BrideDTO brideDTO) {
		if(null==brideDTO) {
			System.out.println("Bride cannot be null");
			return 0;
		}else if(brideDTO.getId()==0) {
			System.out.println("Invalid id");
			return 0;
			
		}else {
			return matrimonyDAO.create(brideDTO);
		}
		
	}

	@Override
	public int ValidateUpdatePhoneById(int id, String phoneNumber) {
		if(id==0 && null==phoneNumber) {
			System.out.println("invalid id and phone");
			return 0;
		}else {
			matrimonyDAO.updatePhoneById(id, phoneNumber);
			return 1;
		}
		
	}

	@Override
	public int validateAndDeleteById(int id) {
		if(0==id) {
			System.out.println("Invalid id so not deletd");
			return 0;
		}else {
			matrimonyDAO.deleteById(id);
			return 1;
		}
		
	}

	@Override
	public int[] validateAndInsertBrides(List<BrideDTO> listOfBride) {
		if(listOfBride==null) {
		   System.out.println("bride list cannot null");
		   int[] result=new int[listOfBride.size()];
		   for(int i=0;i<result.length;i++) {
			   result[i]=0;
		   }
		   return result;
		  
		}else
			
			return matrimonyDAO.insertBrides(listOfBride);
		 
			
		}

	@Override
	public int[] validateAndUpdateBrides(List<BrideDTO> listOfBride) {
		if(listOfBride==null) {
			System.out.println("Brides list cannot be null");
			@SuppressWarnings("null")
			int[] results=new int[listOfBride.size()];
			for (int i = 0; i < results.length; i++) {
				results[i]=0;
				
			}
			return results;
		}
		return matrimonyDAO.updateBrides(listOfBride);
	}

	@Override
	public int[] validateAndDeleteAllBrides(List<Integer> ids) {
		if(ids==null) {
			System.out.println("id should not be null");
			int[] results=new int[ids.size()];
			for (int i = 0; i < results.length; i++) {
				results[i]=0;
				
			}
			return results;
			
		}
		return matrimonyDAO.deleteAllBrides(ids);
	}

	
	
		
		
}

