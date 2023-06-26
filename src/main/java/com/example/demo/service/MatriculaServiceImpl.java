package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.respository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	@Override
	public void guardad(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
		
	}

}
