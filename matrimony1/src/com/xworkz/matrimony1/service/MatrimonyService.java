package com.xworkz.matrimony1.service;

import java.util.List;

import com.xworkz.matrimony1.dto.BrideDTO;

public interface MatrimonyService {
	
	public BrideDTO getBrideById(int id);
	
	public BrideDTO getAllBrides();
	
	public  int validateAndSave(BrideDTO brideDTO);
	
	public int ValidateUpdatePhoneById(int id,String phoneNumber);
	
	public int validateAndDeleteById(int id);
	
	public int[] validateAndInsertBrides(List<BrideDTO> listOfBride);
	
	public int[] validateAndUpdateBrides(List<BrideDTO> listOfBride);
	
	public int[] validateAndDeleteAllBrides(List<Integer> ids);
	
	

	

}
