package jdbcPractice;

import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "218910()/");
        Statement st=con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Tablonun Sutun Sayisi" + rsmd.getColumnCount());

        System.out.printf("%-10s %-18S %-8S %-8S\n", rsmd.getColumnName(1),
                rsmd.getColumnName(2),
                rsmd.getColumnName(3),
                rsmd.getColumnName(4));

        while (rs.next()) {
            System.out.printf("%-10d %-18S %-8S %-8S\n", rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }
        con.close();
        rs.close();
    }
}
