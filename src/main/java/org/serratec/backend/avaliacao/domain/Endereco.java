package org.serratec.backend.avaliacao.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Endereco {

	@NotBlank(message = "Por favor preeencha a sua rua!")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	private String rua;

	@NotBlank(message = "Por favor preeencha o sua cidade!")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	private String cidade;

	@NotBlank(message = "Por favor preeencha o seu estado!")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	private String estado;

	@NotBlank(message = "Por favor preeencha o seu CEP!")
	@Size(min = 8,max = 8)
	@Column(nullable = false, length = 8)
	private String cep;

	

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
