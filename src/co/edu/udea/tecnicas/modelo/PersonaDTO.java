package co.edu.udea.tecnicas.modelo;

import org.omg.CORBA.IdentifierHelper;

public class PersonaDTO { // DTO = DATA TRANSFER OBJECT = OBJETO DE
							// TRANSFERENCIA DE DATOS
	private String nombres;
	private String apellidos;
	private char genero;
	private String documento;

	public PersonaDTO(String nombres, String apellidos, char genero, String documento) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	@Override
	public String toString(){
		return documento+"-"+nombres+"-"+apellidos+"-"+genero;
	}

}
