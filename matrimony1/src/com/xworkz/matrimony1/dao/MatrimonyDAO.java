package com.xworkz.matrimony1.dao;

import java.util.List;

import com.xworkz.matrimony1.dto.BrideDTO;

public interface MatrimonyDAO {
	
	public BrideDTO getById(int id);
	
	public BrideDTO getAllBride();
	
	public int create(BrideDTO brideDTO);
	
	public int updatePhoneById(int id,String phoneNo);
	
	public int deleteById(int id);
	
	public int[] insertBrides(List<BrideDTO> brides);
	
	public int[] updateBrides(List<BrideDTO> brides);
	
	public int[] deleteAllBrides(List<Integer> id);

}
