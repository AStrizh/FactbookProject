package DatabaseCreator.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseRestarter {

    //Connection conn;

    public DatabaseRestarter() {

        Connection conn = ConnectionManager.getInstance().getConnection();

        String sqlFile = reader();
        String[] sqlCommands = sqlFile.split(";");

        for(String sql : sqlCommands)
            executor(conn, sql);
    }


    private static String reader() {

        String projectFolder = "C:/Users/Aleksandr/Documents/ParcingFactbook/FactbookProject/";
        String source = projectFolder + "CreateDatabase.sql";

        try{
            return new String(Files.readAllBytes(Paths.get(source)), StandardCharsets.UTF_8);
        }catch (IOException e){
            return null;
        }

    }

    private static void executor(Connection conn, String sql){

        try (
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }
}
