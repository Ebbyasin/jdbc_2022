package jdbc;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
         //DBWork objesini olustur.
        DBWork db=new DBWork();

        //Connection methodunu cagir.
        Connection con =db.connect_to_db("techpro","postgres","218910()/");

        //Yeni table olusturma methodunu cagir.
        db.createTable(con,"employees");

    }
}
