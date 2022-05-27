package com.mycompany.spring_mvc_project_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.SavingCategory;
import com.mycompany.spring_mvc_project_final.repository.SavingCategoryRepository;

@Service
public class SavingCategoryService {
	@Autowired
	SavingCategoryRepository savingCategoryRepository;
	
	public List<SavingCategory> findAllSavingCategory(){
		return (List<SavingCategory>) savingCategoryRepository.findAll();
	}
	public Optional<SavingCategory> findById(int id)  {
		return savingCategoryRepository.findById(id);
	}
}
