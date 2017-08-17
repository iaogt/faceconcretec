
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardoi
 */
public class ModeloPendientes extends AbstractTableModel{
    
    String[] columnNames = {"Serie","Número","Cliente","Fecha","Monto"};
    ArrayList<String[]> data = new ArrayList();
    
    public void poblarData(){
        String[] obj1 = {"1","2","3","4","5"};
        data.add(obj1);
        String[] obj2 = {"6","7","8","9","10"};
        data.add(obj2);
        String[] obj3 = {"11","12","13","14","15"};
        data.add(obj3);
        String[] obj4 = {"16","17","18","19","20"};
        data.add(obj4);
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        String[] info = data.get(row);
        return info[col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        String[] dat = data.get(row);
        dat[col] = (String)value;
        data.set(row, dat);
        fireTableCellUpdated(row, col);
    }
    
    public ArrayList getSeleccion(int[] i){
        ArrayList<String[]> f = new ArrayList();
        for(int x =0;x<i.length;x++){
            f.add(data.get(x));
        }
        return f;
    }
    
    public ArrayList getAllData(){
        return data;
    }
    
    
}
