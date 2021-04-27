package com.zup.loteria.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zup.loteria.modelo.Aposta;
import com.zup.loteria.utils.RandomNumber;
import com.zup.loteria.validation.emailDuplicado.NumeroDuplicadoConstraint;

@NumeroDuplicadoConstraint
public class ApostaRegisterDto {
	@NotNull @NotEmpty @Email(message = "E-mail inválido!")
	private String email;
	private String numero;
	
	public ApostaRegisterDto() {
		this.numero = "48617";	
	}
	
	public Aposta converter() {
		return new Aposta(this.email, this.numero);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	
}
