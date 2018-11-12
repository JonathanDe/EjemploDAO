package co.edu.udea.tecnicas.dao;

import java.util.List;

import co.edu.udea.tecnicas.modelo.PersonaDTO;

public interface PersonaDAO {
    public boolean almacenarPersona(PersonaDTO persona);

    public PersonaDTO consultarPersona(String identificacion);

    public List<PersonaDTO> consultarPersonas();

    public boolean eliminarPersona(String identificacion);

    public boolean actualizarPersona(PersonaDTO persona);
}
