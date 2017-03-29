/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendadesktop.controlador;


import es.uma.informatica.sii.agendadesktop.modelo.Contacto;
import java.awt.event.ActionListener;

/**
 *
 * @author francis
 */
public interface Controlador extends ActionListener {
    
    public void modificaContacto(Contacto c);
    
}
