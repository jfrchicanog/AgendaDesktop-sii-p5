/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendadesktop.vista;


import es.uma.informatica.sii.agendadesktop.controlador.Controlador;
import es.uma.informatica.sii.agendadesktop.modelo.Contacto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author francis
 */
public class Principal extends javax.swing.JPanel implements Vista, TableModelListener {

    private Controlador ctr;

    public class ModeloContactos extends AbstractTableModel {

        private List<Contacto> contactos;
        public String[] columnas = {"Nombre", "Teléfono"};

        public ModeloContactos() {
            contactos = new ArrayList<>();
        }

        public void setContactos(List<Contacto> il) {
            contactos = il;
            fireTableChanged(new TableModelEvent(this));
        }

        public void addContacto(Contacto c) {
            contactos.add(c);
            fireTableChanged(new TableModelEvent(this));
        }

        public Contacto getContacto(int i) {
            return contactos.get(i);
        }

        @Override
        public String getColumnName(int col) {
            return columnas[col];
        }

        @Override
        public int getRowCount() {
            return (contactos == null) ? 0 : contactos.size();
        }

        @Override
        public int getColumnCount() {
            return columnas.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Contacto c = contactos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return c.getNombre();
                case 1:
                    return c.getTelefono();
                default:
                    return null;
            }

        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            String val = (String) aValue;
            Contacto c = contactos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    c.setNombre(val);
                    break;
                case 1:
                    c.setTelefono(val);
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
            
        }
    }
    private ModeloContactos modeloTabla;

    /**
     * Creates new form Principal
     */
    public Principal() {
        modeloTabla = new ModeloContactos();
        modeloTabla.addTableModelListener(this);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContactos = new javax.swing.JTable();
        botonAniadir = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tablaContactos.setModel(modeloTabla);
        tablaContactos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaContactos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaContactos);

        botonAniadir.setText("Añadir");

        botonEliminar.setText("Eliminar");

        jLabel1.setText("Contactos");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(botonAniadir)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 98, Short.MAX_VALUE)
                                .add(botonEliminar))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 272, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 295, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonAniadir)
                    .add(botonEliminar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadir;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaContactos;
    // End of variables declaration//GEN-END:variables

    @Override
    public Contacto getSelected() {
        int row = tablaContactos.getSelectedRow();
        if (row >= 0) {
            return modeloTabla.getContacto(row);
        } else {
            return null;
        }
    }

    @Override
    public void setContolador(Controlador ctrl) {
        
        ctr = ctrl;

        botonAniadir.addActionListener(ctrl);
        botonEliminar.addActionListener(ctrl);
    }

    @Override
    public void setContactos(List<Contacto> contactos) {
        modeloTabla.setContactos(contactos);
    }

    @Override
    public void addContacto(Contacto c) {
        modeloTabla.addContacto(c);
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType()==TableModelEvent.UPDATE)
        {
            if (e.getFirstRow() == e.getLastRow() && 
                e.getFirstRow() >= 0) {
                Contacto c = modeloTabla.getContacto(e.getFirstRow());
                ctr.modificaContacto(c);
            }
        }
    }
}
