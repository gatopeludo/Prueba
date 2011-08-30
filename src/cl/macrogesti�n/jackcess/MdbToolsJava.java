package cl.macrogestión.jackcess;

import java.sql.*;
public class MdbToolsJava
{
  private static String filename = "acciones.mdb";

  public static void main(String[] args)
  {
    //sql();
   //metaData();
    createEmployees();
  }

  private static void metaData()
  {
    try
    {
      Class.forName("mdbtools.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mdbtools:" + filename);
      java.sql.DatabaseMetaData dmd = conn.getMetaData();
      ResultSet rset = dmd.getTables(null,null,null,new String[]{"TABLE"});
      rset.getMetaData();
      while (rset.next())
        System.out.println(rset.getString(3));
      conn.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private static void sql()
  {
    try
    {
      Class.forName("mdbtools.jdbc2.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mdbtools:" + filename);
      Statement stmt = conn.createStatement();
      String query = "select * from provincia";
      ResultSet rset;
      rset = stmt.executeQuery(query);
//      PreparedStatement pstmt = conn.prepareStatement(query);
//      pstmt.setString(1,"hi");
//      pstmt.setInt(2,1);
//      pstmt.setInt(3,4);
//      rset = pstmt.executeQuery();
      java.sql.ResultSetMetaData rmd = rset.getMetaData();
      int numCol = rmd.getColumnCount();

      System.out.print("# ");
      for (int n=1; n <= numCol; n++)
      {
        System.out.print(rmd.getColumnLabel(n) + "|");
      }
      System.out.println();

      for (int i = 1; rset.next(); i++)
      {
        System.out.print((i) + " ");
        for (int n=1; n <= numCol; n++)
        {
          System.out.print(rset.getString(n) + "|");
        }
        System.out.println();
      }
      rset.close();
      stmt.close();
//      pstmt.close();
      conn.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  public static void createEmployees() {
		try {
			Class.forName("mdbtools.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mdbtools:"
					+ filename);
			Statement stmt = con.createStatement();

			String createString;
			createString = "create table Employees (" 
					+ "Employee varchar(10), "
					+ "Name varchar(30))";

			stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
