package com.zup.loteria.validation.emailDuplicado;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.zup.loteria.dto.ApostaRegisterDto;
import com.zup.loteria.modelo.Aposta;
import com.zup.loteria.repository.ApostaRepository;


public class NumeroDuplicadoValidator implements 
	ConstraintValidator<NumeroDuplicadoConstraint, ApostaRegisterDto>{
	
	@Autowired
    private ApostaRepository apostaRepository;
    
	@Override
    public void initialize(NumeroDuplicadoConstraint email) {
    }

    @Override
    public boolean isValid(ApostaRegisterDto aposta, ConstraintValidatorContext cxt) {
    	List<Aposta> listaApostas = this.apostaRepository.findByEmailAndNumero(aposta.getEmail(), aposta.getNumero());    	    	
        return listaApostas.isEmpty();
    }
	
}
