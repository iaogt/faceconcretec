
import java.awt.Desktop;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardoi
 */
public class Anular extends javax.swing.JInternalFrame {
    private JDatePickerImpl datePicker;
    private boolean enviando;
    /**
     * Creates new form Anular
     */
    public Anular() {
        initComponents();
/*UtilDateModel model = new UtilDateModel();
        Calendar hoy = new GregorianCalendar();
model.setDate(hoy.get(Calendar.YEAR),hoy.get(Calendar.MONTH),hoy.get(Calendar.DAY_OF_MONTH));
model.setSelected(true);
// Need this...
Properties p = new Properties();
p.put("text.today", "Today");
p.put("text.month", "Month");
p.put("text.year", "Year"); 
JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
// Don't know about the formatter, but there it is...
 datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
datePicker.setBounds(130, 141, 150, 100);
this.add(datePicker);*/
enviando=false;
jLabel5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura", "Nota de crédito", "Nota de débito", "Factura cambiaria" }));

        jLabel1.setText("Tipo de documento");

        jLabel2.setText("Serie del documento");

        jLabel3.setText("No. de documento");

        jLabel4.setText("Razón");

        jButton1.setText("Pedir Anulación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Enviando información....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel5)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!enviando){
            enviando=true;
            jLabel5.setVisible(true);
            Thread updateThread = new Thread() {
                public void run() {
         Map<String, String> opciones = BDLocal.getOpciones();
        String IDEMPRESA = opciones.get("empresa_codigo");
                    String endpoint = "";
                    String tipodoc="";
                    String nomnum="";
                    String opsele = (String)jComboBox1.getSelectedItem();
                    if(opsele.compareTo("Factura")==0){
                        endpoint="AnulaFacturaXML";
                        tipodoc="FACTURA";
                        nomnum="NOFACTURA";
                    }else if(opsele.compareTo("Nota de crédito")==0){
                        endpoint="AnulaNotaCreditoXML";
                        tipodoc="NOTACREDITO";
                        nomnum="NODOCUMENTO";
                    }else if(opsele.compareTo("Nota de débito")==0){
                        endpoint="AnulaNotaDebitoXML";
                        tipodoc="NOTADEBITO";
                        nomnum="NODOCUMENTO";
                    }else if(opsele.compareTo("Factura cambiaria")==0){
                        endpoint="AnulaFacturaXML";
                        tipodoc="FACTURA";
                        nomnum="NOFACTURA";
                    }
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("nofactura",jTextField2.getText());
                    params.put("razonanulacion",jTextArea1.getText());
                    params.put("idserie",jTextField1.getText());
                    params.put("empresa",IDEMPRESA);
                    params.put("sucursal",opciones.get("empresa_sucursal"));
                    params.put("caja",opciones.get("empresa_caja"));
                    params.put("tipodoc",tipodoc);
                    params.put("nomnum",nomnum);
                    String respuesta = APIGeface.anularDocumento(params,endpoint,tipodoc);
                    System.out.println(respuesta);
                    String archivo = Registro.procesaAnular(respuesta);
                    if((archivo!="")&&(!archivo.startsWith("error"))){ 
                        JOptionPane.showMessageDialog(null, archivo);
                        reiniciar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Se generó un error:"+archivo);
                    }
                    enviando=false;
                    jLabel5.setVisible(false);
                }
            };
            updateThread.start();
        }else{
                JOptionPane.showMessageDialog(null, "Los datos están siendo enviados");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

private void reiniciar(){
    jTextField1.setText("");
    jTextField2.setText("");
    jTextArea1.setText("");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
