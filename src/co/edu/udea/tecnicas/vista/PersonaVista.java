package co.edu.udea.tecnicas.vista;

import java.util.List;
import javax.swing.JOptionPane;

import co.edu.udea.tecnicas.controlador.PersonaControlador;
import co.edu.udea.tecnicas.modelo.PersonaDTO;
 
public class PersonaVista {

	public static void main(String[] args) {
		PersonaControlador controlador = new PersonaControlador();
		String opcion = "";

		do {
			opcion = JOptionPane.showInputDialog(
					"Bienvenido al programa:\nSeleccione una opci�n:\n1. Registrar Persona.\n2.Listar Personas.\n3.Salir");

			switch (opcion) {
			case "1":
				String nombres = JOptionPane.showInputDialog("Ingrese el nombre de la persona: ");
				String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos de la persona: ");
				char genero = JOptionPane.showInputDialog("Ingrese el g�nero de la persona: ").charAt(0);
				String documento = JOptionPane.showInputDialog("Ingrese la identificaci�n de la persona: ");

				PersonaDTO persona = new PersonaDTO(nombres, apellidos, genero, documento);
				
                                
                                if (controlador.almacenarPersona(persona)) {
					JOptionPane.showMessageDialog(null, "Persona guardada correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ocurri� un error al guardar la persona");
				}
				break;
			case "2":
				List<PersonaDTO> respuesta=controlador.consultarPersonas();
				StringBuilder sb=new StringBuilder();
				for(PersonaDTO p:respuesta){
					sb.append(p);	
					sb.append("\n");
				}
				JOptionPane.showMessageDialog(null, sb.toString());				
			}

		} while (!"3".equals(opcion));

	}

}
