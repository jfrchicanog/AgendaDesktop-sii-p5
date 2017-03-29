/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendadesktop.vista;


import es.uma.informatica.sii.agendadesktop.controlador.Controlador;
import es.uma.informatica.sii.agendadesktop.modelo.Contacto;
import java.util.List;

/**
 *
 * @author francis
 */
public interface Vista {
    void addContacto(Contacto c);
    Contacto getSelected();
    void setContactos(List<Contacto> contactos);
    void setContolador(Controlador ctrl);
}
