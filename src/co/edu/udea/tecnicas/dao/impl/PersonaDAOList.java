package co.edu.udea.tecnicas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.tecnicas.dao.PersonaDAO;
import co.edu.udea.tecnicas.modelo.PersonaDTO;

public class PersonaDAOList implements PersonaDAO {

    public static final List<PersonaDTO> personasBD = new ArrayList<PersonaDTO>();

    public boolean almacenarPersona(PersonaDTO persona) {

        return personasBD.add(persona);
    }

    @Override
    public PersonaDTO consultarPersona(String identificacion) {
        for (PersonaDTO persona : personasBD) {
            if (persona.getDocumento().equals(identificacion))
                return persona;
        }
        return null;
    }

    @Override
    public List<PersonaDTO> consultarPersonas() {
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        for (PersonaDTO persona : personasBD) {
            personas.add(persona);
        }
        return personas;
    }

    @Override
    public boolean eliminarPersona(String identificacion) {
        for (PersonaDTO persona : personasBD) {
            if (persona.getDocumento().equals(identificacion)) {
                personasBD.remove(persona);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean actualizarPersona(PersonaDTO parametro) {
        for (PersonaDTO persona : personasBD) {
            if (persona.getDocumento().equals(parametro.getDocumento())) {
                personasBD.remove(persona);
                personasBD.add(parametro);
                return true;
            }

        }
        return false;
    }
}
