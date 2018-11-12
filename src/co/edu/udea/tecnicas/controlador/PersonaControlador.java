package co.edu.udea.tecnicas.controlador;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import java.util.List;

import co.edu.udea.tecnicas.modelo.PersonaDTO;
import co.edu.udea.tecnicas.negocio.PersonaNegocio;

public class PersonaControlador {
    @FXML
    private Text actionStatus;
    @FXML
    private TextField documento;
    @FXML
    private TextField nombres;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField genero;
    @FXML
    private Text actionStatus2;
    @FXML
    private TextField id;
    @FXML
    private TableView<String> tablePersonas;

    PersonaNegocio personaNegocio = new PersonaNegocio();

    public boolean almacenarPersona(PersonaDTO persona) {
        // invocado por un
        // evento de un
        // bot�n
        // Validar que los campos est�n correctos
        boolean respuesta = personaNegocio.almacenarPersona(persona);

        return respuesta;
    }

    public List<PersonaDTO> consultarPersonas() {
        return personaNegocio.consultarPersonas();
    }

    @FXML
    protected void consultarPersona(ActionEvent a) {
        PersonaDTO persona = personaNegocio.consultarPersona(id.getText());
        if (persona != null) {
            actionStatus2.setText("Nombre: " + persona.getNombres() + "\nApellido: " + persona.getApellidos() + "\nIdentificación: " + persona.getDocumento() + "\nGenero: " + persona.getGenero());
        } else {
            actionStatus2.setText("Esta persona no está registrada");
        }
    }

    public boolean eliminarPersona(String identificacion) {
        return personaNegocio.eliminarPersona(identificacion);
    }

    /**
     * @param event Boton Almacenar Persona
     */
    @FXML
    protected void handleSubmitAlmacenarPersona(ActionEvent event) {
        if (!nombres.getText().equals("") && !apellidos.getText().equals("") && !genero.getText().equals("") && !documento.getText().equals("")) {
            PersonaDTO persona = new PersonaDTO(nombres.getText(), apellidos.getText(), genero.getText().charAt(0), documento.getText());

            if (this.almacenarPersona(persona)) {
                actionStatus.setText("Usuario registrado con éxito!");
                nombres.setText("");
                apellidos.setText("");
                genero.setText("");
                documento.setText("");
            } else {
                actionStatus.setText("Ocurrió un problema ingresando el usuario!");
            }
        } else {
            actionStatus.setText("El formulario no puede ser vacío!");
        }
    }

}
