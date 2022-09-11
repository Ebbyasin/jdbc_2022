package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techpro","postgres","218910()/");
        Statement st=con.createStatement();

        /*
        TABLOLARİN İNTELLİJDEN EKLENMİS HALİ

         st.execute("drop table countries"); // tablo silme
        st.execute("drop table companies"); // tablo silme
        String tablo_olustur1="CREATE TABLE countries\n" +
                "(\n" +
                "    country_id CHAR(3),\n" +
                "    country_name VARCHAR(50),\n" +
                "    region_id SMALLINT\n" +
                ");\n" +
                "Insert into countries values ('AR','Argentina',2);\n" +
                "Insert into countries values ('AU','Australia',3);\n" +
                "Insert into countries values ('BE','Belgium',1);\n" +
                "Insert into countries values ('BR','Brazil',2);\n" +
                "Insert into countries values ('CA','Canada',2);\n" +
                "Insert into countries values ('CH','Switzerland',1);\n" +
                "Insert into countries values ('CN','China',3);\n" +
                "Insert into countries values ('DE','Germany',1);\n" +
                "Insert into countries values ('DK','Denmark',1);\n" +
                "Insert into countries values ('EG','Egypt',4);\n" +
                "Insert into countries values ('FR','France',1);\n" +
                "Insert into countries values ('IL','Israel',4);\n" +
                "Insert into countries values ('IN','India',3);\n" +
                "Insert into countries values ('IT','Italy',1);\n" +
                "Insert into countries values ('JP','Japan',3);\n" +
                "Insert into countries values ('KW','Kuwait',4);\n" +
                "Insert into countries values ('ML','Malaysia',3);\n" +
                "Insert into countries values ('MX','Mexico',2);\n" +
                "Insert into countries values ('NG','Nigeria',4);\n" +
                "Insert into countries values ('NL','Netherlands',1);\n" +
                "Insert into countries values ('SG','Singapore',3);\n" +
                "Insert into countries values ('UK','United Kingdom',1);\n" +
                "Insert into countries values ('US','United States of America',2);\n" +
                "Insert into countries values ('ZM','Zambia',4);\n" +
                "Insert into countries values ('ZW','Zimbabwe',4);";
        st.execute(tablo_olustur1); // 1. tabloyu buradan olusturduk
         */

        //1. Example:  region id'si 1 olan "country name" değerlerini çağırın.

        String sql1="select country_name from countries where region_id =1";
        boolean r1=st.execute(sql1);// execute codu calistirmak icin kullaniliyor
        System.out.println(r1);// true yada false verir. cunku data cagirma islemi yaptik.

        //REcordlari gormek icin executeQuery() methou kullanmaliyiz.
        ResultSet result1 =st.executeQuery(sql1);// executeQuery kodu cagirmak icin kullaniliyor

        while (result1.next()){
            System.out.println(result1.getString("country_name"));

        }

        //2.Ornek:"region_id'nin 2'den buyuk oldugu "country_id" ve "country_name" degerlerini cagirin.
        String sql2= "select country_id, country_name from countries where region_id >2";
        ResultSet result2=st.executeQuery(sql2);
        while (result2.next()){

            System.out.println(result2.getString("country_id")+"-->"+result2.getString("country_name"));
        }
        /*
        String tablo_olustur2= " CREATE TABLE companies\n" +
                "(\n" +
                "  company_id SMALLINT,\n" +
                "  company VARCHAR(20),\n" +
                "  number_of_employees SMALLINT\n" +
                ");\n" +
                "INSERT INTO companies VALUES(100, 'IBM', 12000);\n" +
                "INSERT INTO companies VALUES(101, 'GOOGLE', 18000);\n" +
                "INSERT INTO companies VALUES(102, 'MICROSOFT', 10000);\n" +
                "INSERT INTO companies VALUES(103, 'APPLE', 21000);";
        st.execute(tablo_olustur2); // 2. tabloyu buradan olusturduk
         */

        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()){
            System.out.println(result3.getInt("company_id")+"--"+result3.getString("company")
                    +"--"+result3.getInt("number_of_employees"));
        }
        con.close();
        st.close();




    }
}
