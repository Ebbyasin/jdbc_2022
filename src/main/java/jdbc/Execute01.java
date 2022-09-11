package jdbc;

import java.sql.*;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adim:Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim:Database'e baglan
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techpro","postgres","218910()/");

        //3.Adim: Statement olustur.
        Statement st =con.createStatement();

        //4.Adim: Query calistir

        //1.Ornek: "workers" adinda bir tablle olusturup "worker_id,worker_name,worker_salary" sutunlarini ekleyin

        String sql1="CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(50),worker_salary INT)";
        boolean result=st.execute(sql1);
        System.out.println(result);// False return yapar, cunku data cagrilmadi.

        //2.Ornek: Table'a worker_address sutunu ekleyerek alter yapin.
        String sql2= "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Example:Drop workers table
        String sql3="drop table workers";
        st.execute(sql3);

        //5.Adim: Baglanti ve Statement i kapat.
        con.close();
        st.close();
    }
}
