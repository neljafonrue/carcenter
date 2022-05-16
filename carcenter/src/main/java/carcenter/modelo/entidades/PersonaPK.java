package carcenter.modelo.entidades;

import java.io.Serializable;

public class PersonaPK implements Serializable {

	private Long idTipoDocumento;
	private Long numeroDocumento;
	 
	public PersonaPK() {}

	
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}


	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}


	public Long getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}/*fin de class*/
