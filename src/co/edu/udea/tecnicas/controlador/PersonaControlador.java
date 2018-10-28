package co.edu.udea.tecnicas.controlador;

import java.util.List;

import co.edu.udea.tecnicas.modelo.PersonaDTO;
import co.edu.udea.tecnicas.negocio.PersonaNegocio;

public class PersonaControlador {
	PersonaNegocio personaNegocio = new PersonaNegocio();

	public boolean almacenarPersona(PersonaDTO persona) { // pudo haber sido
															// invocado por un
															// evento de un
															// botón
		// Validar que los campos estén correctos
		boolean respuesta = personaNegocio.almacenarPersona(persona);

		return respuesta;
	}
	
	
	public List<PersonaDTO> consultarPersonas(){
		return personaNegocio.consultarPersonas();
	}

}
