package co.edu.udea.tecnicas.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import co.edu.udea.tecnicas.dao.PersonaDAO;
import co.edu.udea.tecnicas.modelo.PersonaDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAOFile implements PersonaDAO {

    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String PERSONAS_FILE_NAME = "personas";
    private BufferedWriter escritorBuffer;
    private FileWriter escritorArchivo;
    private Scanner lector;
    private File archivoPersonas;
    private BufferedReader lectorBuffer;
    private FileReader lectorArchivo;

    public PersonaDAOFile() {
        archivoPersonas = new File(PERSONAS_FILE_NAME);

        try {
            lector = new Scanner(archivoPersonas);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean almacenarPersona(PersonaDTO persona) {
        StringBuilder sb = new StringBuilder();
        sb.append(persona.getDocumento());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(persona.getNombres());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(persona.getApellidos());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(persona.getGenero());

        try {
            escritorArchivo = new FileWriter(archivoPersonas, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PersonaDTO consultarPersona(String identificacion) {
        PersonaDTO persona = null;
        try {
            lectorArchivo = new FileReader(archivoPersonas);
            lectorBuffer = new BufferedReader(lectorArchivo);
            String linea;
            boolean found = false;
            while ((linea = lectorBuffer.readLine()) != null && !found) {
                String[] datosPersona = linea.split(",");
                if (datosPersona[0].equals(identificacion)) {
                    found = true;
                    persona = new PersonaDTO(datosPersona[1], datosPersona[2], datosPersona[3].charAt(0), datosPersona[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectorArchivo) {
                    lectorArchivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return persona;
    }

    @Override
    public List<PersonaDTO> consultarPersonas() {
        final List<PersonaDTO> listaPersonas = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoPersonas);
            lectorBuffer = new BufferedReader(lectorArchivo);
            String linea;
            while ((linea = lectorBuffer.readLine()) != null) {
                String[] datosPersona = linea.split(",");
                listaPersonas.add(new PersonaDTO(datosPersona[1], datosPersona[2], datosPersona[3].charAt(0), datosPersona[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectorArchivo) {
                    lectorArchivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listaPersonas;
    }

    @Override
    public boolean eliminarPersona(String identificacion) {
        boolean remove = false;
        
            /*try {
                lectorArchivo = new FileReader(archivoPersonas);
                lectorBuffer = new BufferedReader(lectorArchivo);
                String linea;
                
                while ((linea = lectorBuffer.readLine()) != null) {
                    if(linea.split(",")[0].equals(identificacion)) {
                       linea = lectorBuffer.readLine().
                    }
                }
            } catch (IOException e) {
                 e.printStackTrace();
            } finally {
                try {
                    if (null != lectorArchivo) {
                        lectorArchivo.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }*/


        List<PersonaDTO> personas = this.consultarPersonas();

        int j = 0;
        boolean found = false;
        do {
            if (personas.get(j).getDocumento().trim().equals(identificacion)) {
                found = true;
                personas.remove(j);
            }
            j++;
        } while (found == false && personas.size() > j);

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(archivoPersonas));
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(PersonaDAOFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (PersonaDTO persona : personas) {
            this.almacenarPersona(persona);
            remove = true;
        }
        return remove;
    }

    @Override
    public boolean actualizarPersona(PersonaDTO persona) {

        return false;
    }

}
