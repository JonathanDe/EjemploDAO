package co.edu.udea.tecnicas.negocio;

import java.util.List;

import co.edu.udea.tecnicas.dao.PersonaDAO;
import co.edu.udea.tecnicas.dao.impl.PersonaDAOFile;
import co.edu.udea.tecnicas.modelo.PersonaDTO;

public class PersonaNegocio {
	PersonaDAO personaDAO= new PersonaDAOFile();
	
	public boolean almacenarPersona(PersonaDTO persona){
		//Validaciones de negocio y se ejecutarían los casos de uso de la aplicación
		boolean resultado = personaDAO.almacenarPersona(persona); 
		return resultado;
	}
	
	public List<PersonaDTO> consultarPersonas(){
		return personaDAO.consultarPersonas();
	}

}
