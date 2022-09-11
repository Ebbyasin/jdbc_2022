package jdbcPractice;


    import java.sql.*;

    public class Query01 {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            // 1 .Driver yukle
            Class.forName("org.postgresql.Driver");
            // 2. Baglanti olustur
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                    "postgres",
                    "218910()/" +
                            "");
            // 3. Statement olustur
            Statement st = con.createStatement();

            // resulset olusturuyoruz
            ResultSet veri = st.executeQuery("select * from ogrenciler");
            while (veri.next()) {
                System.out.printf("%-5d %-18S %-5S %-2S\n", veri.getInt(1),
                        veri.getString(2),
                        veri.getString(3),
                        veri.getString(4));
            }
            con.close();
            st.close();
            veri.close();
        }
    }

