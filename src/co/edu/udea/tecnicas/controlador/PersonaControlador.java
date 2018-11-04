package co.edu.udea.tecnicas.controlador;

import java.util.List;

import co.edu.udea.tecnicas.modelo.PersonaDTO;
import co.edu.udea.tecnicas.negocio.PersonaNegocio;

public class PersonaControlador {
    PersonaNegocio personaNegocio = new PersonaNegocio();

    public boolean almacenarPersona(PersonaDTO persona) { // pudo haber sido
        // invocado por un
        // evento de un
        // bot�n
        // Validar que los campos est�n correctos
        boolean respuesta = personaNegocio.almacenarPersona(persona);

        return respuesta;
    }


    public List<PersonaDTO> consultarPersonas(){
        return personaNegocio.consultarPersonas();
    }

    public PersonaDTO consultarPersona(String identificacion){
        return personaNegocio.consultarPersona(identificacion);
    }
    
    public boolean eliminarPersona(String identificacion){
        return personaNegocio.eliminarPersona(identificacion);
    }

}
