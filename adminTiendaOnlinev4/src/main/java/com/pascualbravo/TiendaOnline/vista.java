package com.pascualbravo.TiendaOnline;

import com.pascualbravo.TiendaOnline.Controlador.controlProductos;
import com.pascualbravo.TiendaOnline.Dao.Conexion.AdministradorConexion;
import com.pascualbravo.TiendaOnline.utilidades.Util;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class vista extends javax.swing.JFrame {

    private final controlProductos controlador;
    private final static String[] COLUMNAS_TABLA = {"ID", "NOMBRE", "DESCRIPCION",
        "PRECIO", "STOCK", "FECHA", "IMAGEN", "ID PROVEEDOR", "ID CATEGORIA"};
    private int id_Producto, Stock, Id_PROVEEDORES, Id_Categoría;
    private String Nombre, Descripcion, Imagen;
    private float Precio;
    private LocalDate Fecha;

    public vista() {
        initComponents();

        this.setResizable(false);
        txtId.setVisible(false);
        this.getContentPane().setBackground(new Color(27, 38, 44));
        controlador = controlProductos.getInstance();
        try {

            controlador.llenartabla(COLUMNAS_TABLA, tblProductos);
            controlador.llenarComboBox(cbProveedor, cbCategorias);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!!!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtUrlimagen = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblUrlimagen = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblIdproveedor = new javax.swing.JLabel();
        lblIdcategoria = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        cbProveedor = new javax.swing.JComboBox<>();
        cbCategorias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ADMINISTRADORA DE PRODUCTOS");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNombre.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre ");

        lblDescripcion.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcion.setText("Descripcion ");

        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtId.setEnabled(false);
        txtId.setName(""); // NOI18N

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPrecio.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("Precio");

        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcion.setToolTipText("");
        txtDescripcion.setAlignmentX(0.0F);
        txtDescripcion.setAlignmentY(0.0F);
        txtDescripcion.setAutoscrolls(false);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtUrlimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblStock.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Stock");

        lblFecha.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha");

        lblUrlimagen.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblUrlimagen.setForeground(new java.awt.Color(255, 255, 255));
        lblUrlimagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUrlimagen.setText("URL Imagen");

        txtStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIdproveedor.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblIdproveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblIdproveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdproveedor.setText("Id Proveedor");

        lblIdcategoria.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        lblIdcategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblIdcategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdcategoria.setText("Id Categoria");

        btnEliminar.setBackground(new java.awt.Color(240, 18, 11));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setActionCommand("");
        btnEliminar.setAutoscrolls(true);
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(50, 130, 184));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setActionCommand("");
        btnActualizar.setAutoscrolls(true);
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(38, 180, 42));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setActionCommand("");
        btnAgregar.setAutoscrolls(true);
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar1.setBackground(new java.awt.Color(5, 173, 103));
        btnLimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar1.setText("LIMPIAR");
        btnLimpiar1.setActionCommand("");
        btnLimpiar1.setAutoscrolls(true);
        btnLimpiar1.setBorder(null);
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        scrollProductos.setBackground(new java.awt.Color(255, 0, 0));
        scrollProductos.setBorder(null);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        scrollProductos.setViewportView(tblProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdcategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(cbCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addComponent(txtNombre))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDescripcion)
                                        .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblUrlimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUrlimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblDescripcion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(lblStock))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(lblUrlimagen))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUrlimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdcategoria)
                            .addComponent(lblIdproveedor))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//con este metodo obtenemos los datos que hay en los text fields

    private void ObtenerDatos() throws SQLException {
        int p = 0, c = 0;
        String nombreCategoria = (cbCategorias.getSelectedItem()).toString();
        String CONSULTA = "select categoria_id as numero from categorias where nombre='" + nombreCategoria + "'";
        String nombreProveedores = (cbProveedor.getSelectedItem()).toString();
        String CONSULTA2 = "select proveedor_id as numero from proveedores where nombre='" + nombreProveedores + "'";
        try {
            c = Util.RetornarId(CONSULTA);
            p = Util.RetornarId(CONSULTA2);
            if (c > 0 && p > 0) {
                JOptionPane.showMessageDialog(null, "Bien",
                        "bbien", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "error interno con combobox",
                    "error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("111");
        Nombre = txtNombre.getText();
        Descripcion = txtDescripcion.getText();
        Precio = Float.parseFloat(txtPrecio.getText());
        Stock = Integer.parseInt(txtStock.getText());
        Fecha = LocalDate.parse(txtFecha.getText());
        Imagen = txtUrlimagen.getText();
        Id_PROVEEDORES = p;
        Id_Categoría = c;
        System.out.println("222");

    }

    private void MandarDatos() {
        controlador.RecibirDatos(Nombre, Descripcion, Precio, Stock,
                Fecha, Imagen, Id_PROVEEDORES, Id_Categoría);
    }

    private String mensajeError() {
        String messagesError = controlador.ValidarCampos(
                txtId.getText(), txtNombre.getText(), txtDescripcion.getText(),
                txtPrecio.getText(), txtStock.getText(), txtFecha.getText(),
                txtUrlimagen.getText(), Integer.toString(Id_PROVEEDORES),
                Integer.toString(Id_Categoría));
        return messagesError;
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        boolean mensaje = false;
        int Pregunta = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar este producto?",
                "Eliminar Producto", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (Pregunta == 0) {
            try {
                mensaje = controlador.eliminar(Integer.parseInt(txtId.getText()));
                if (mensaje) {
                    JOptionPane.showMessageDialog(null, "\"Producto eliminado correctamente\"",
                            "producto eliminado", JOptionPane.INFORMATION_MESSAGE);
                    ActualizarTabla();
                    clearText();
                } else {
                    JOptionPane.showMessageDialog(null, "Error, Id producto no encontrado",
                            " producto no encontrado", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnAgregar.setEnabled(true);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void ActualizarTabla() throws SQLException {
        try {
            controlador.llenartabla(COLUMNAS_TABLA, tblProductos);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la Tabla",
                    " error al actualizar la Tabla", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        boolean mensaje = false;
        int pregunta;
        try {
            String messagesError = mensajeError();
            if (messagesError.length() > 0) {
                JOptionPane.showMessageDialog(null, messagesError,
                        " error al actualizar producto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            pregunta = JOptionPane.showConfirmDialog(null, "Desea Realizar estos cambios?",
                    "Actualizar Producto", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (pregunta != 0) {
                return;
            }
            ObtenerDatos();
            MandarDatos();
            mensaje = controlador.actualizar(Integer.parseInt((txtId.getText())));
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente",
                        " Exito", JOptionPane.INFORMATION_MESSAGE);
                ActualizarTabla();
                clearText();
            } else {
                JOptionPane.showMessageDialog(null, "Error, producto no actualizado",
                        " error al actualizar producto", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        boolean mensaje = false;
        int pregunta;
        try {
            String messagesError = mensajeError();
            if (messagesError.length() > 0) {
                JOptionPane.showMessageDialog(null, messagesError,
                        " error al agregar producto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            pregunta = JOptionPane.showConfirmDialog(null, "Desea Agregar Este Producto?",
                    "Verificar campos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //0=si; 1=no
            if (pregunta != 0) {
                return;
            }
            ObtenerDatos();
            MandarDatos();
            mensaje = controlador.agregar();
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente",
                        " Exito", JOptionPane.INFORMATION_MESSAGE);
                clearText();
                ActualizarTabla();

                return;
            } else {
                JOptionPane.showMessageDialog(null, "Error, producto ya registrado",
                        " error al agregar producto", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int seleccionar = tblProductos.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 0)));
        txtNombre.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 1)));
        txtDescripcion.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 2)));
        txtPrecio.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 3)));
        txtStock.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 4)));
        txtFecha.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 5)));
        txtUrlimagen.setText(String.valueOf(tblProductos.getValueAt(seleccionar, 6)));
        cbProveedor.setSelectedItem(String.valueOf(tblProductos.getValueAt(seleccionar, 7)));

        cbCategorias.setSelectedItem(String.valueOf(tblProductos.getValueAt(seleccionar, 8)));
//        aprovacion = true;
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);


    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed

        clearText();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    public void clearText() {
        controlador.clearText(txtNombre);
        controlador.clearText(txtDescripcion);
        controlador.clearText(txtPrecio);
        controlador.clearText(txtStock);
        controlador.clearText(txtFecha);
        controlador.clearText(txtUrlimagen);
        /////////////////////////////////////
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new vista().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JComboBox<String> cbCategorias;
    private javax.swing.JComboBox<String> cbProveedor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdcategoria;
    private javax.swing.JLabel lblIdproveedor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUrlimagen;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUrlimagen;
    // End of variables declaration//GEN-END:variables
}
