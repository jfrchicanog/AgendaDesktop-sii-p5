/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendadesktop.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author francis
 */
public class Modelo {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public Modelo()
    {
        emf = Persistence.createEntityManagerFactory("AgendaPU");
        em=emf.createEntityManager();
    }
    
    public boolean aniadirContacto (Contacto c)
    {
        // TODO: Insertar código para añadir contacto a la BBDD (se puede hacer en 4 líneas)
        return true;
    }
    
    public void modificarContacto (Contacto c)
    {
        // TODO: Insertar código para modificar contacto de la BBDD (se puede hacer en 4 líneas)
    }
    
    public void eliminarContacto (Contacto c)
    {
        // TODO: Insertar código para eliminar un contacto de la BBDD (se puede hacer en 4 líneas)
    }
    
    public List<Contacto> getContactos()
    {
        // TODO: Insertar código para devolver todos los contactos de la BBDD (se puede hacer en 3 líneas contando las que ya hay)
        List<Contacto> res = null;
        return res;
    }
    
    public void cerrar()
    {
        em.close();
        emf.close();
    }
    
    
}
