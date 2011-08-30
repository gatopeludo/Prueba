package cl.macrogestión.jackcess;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;


public class TestJackcess {
	 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        Database db = Database.open(  new File( "acciones.mdb"), true); //)(FileFormat.V1997, new File("new.mdb"));
        Table newTable = new TableBuilder("NewTable").addColumn( new ColumnBuilder("a").setSQLType(Types.INTEGER).toColumn()).addColumn(new ColumnBuilder("b").setSQLType(Types.VARCHAR).toColumn()).toTable(db);
        newTable.addRow(1, "foo");
    }
}
