package com.restapis.firstjobapp.company.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapis.firstjobapp.company.Company;
import com.restapis.firstjobapp.company.CompanyRepository;
import com.restapis.firstjobapp.company.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {

		return companyRepository.findAll();
	}

}
