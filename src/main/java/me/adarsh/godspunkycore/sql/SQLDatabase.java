package me.adarsh.godspunkycore.sql;

import me.adarsh.godspunkycore.Skyblock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabase {
    private static final Skyblock plugin = Skyblock.getPlugin();
    String url = "jdbc:mysql://188.40.143.44:3306/s57_test"+"?autoReconnect=true&zeroDateTimeBehavior=convertToNull";
    String user = "u57_qbJP83FsYA";
    String password = "uL4QjYAblPaZXQk@bK9qZ+tg";

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                connection.prepareStatement("CREATE TABLE IF NOT EXISTS `worlds` (\n" +
                        "\t`id` SMALLINT,\n" +
                        "\t`name` TEXT\n" +
                        ");").execute();
                connection.prepareStatement("CREATE TABLE IF NOT EXISTS `users` (\n" +
                        "\t`id` INT,\n" +
                        "\t`uuid` TINYTEXT\n" +
                        ");").execute();
                connection.prepareStatement("CREATE TABLE IF NOT EXISTS `regions` (\n" +
                        "\t`name` TINYTEXT,\n" +
                        "\t`x1` INT,\n" +
                        "\t`y1` INT,\n" +
                        "\t`z1` INT,\n" +
                        "\t`x2` INT,\n" +
                        "\t`y2` INT,\n" +
                        "\t`z2` INT,\n" +
                        "\t`world` SMALLINT,\n" +
                        "\t`type` TINYTEXT\n" +
                        ");").execute();
                connection.prepareStatement("CREATE TABLE IF NOT EXISTS `launchers` (\n" +
                        "\t`region_name` TINYTEXT,\n" +
                        "\t`x` INT,\n" +
                        "\t`y` INT,\n" +
                        "\t`z` INT\n" +
                        ");").execute();
                return connection;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}