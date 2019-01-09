package com.order;

import java.sql.*;

    public class DataBaseConnection {

        String orderName, chickenBiryani, chilliChicken, vegBiryani;

        public DataBaseConnection(String orderName) {
            this.orderName = orderName;
        }

        public DataBaseConnection(String orderName, String chickenBiryani, String chilliChicken, String vegBiryani) {
            this.orderName = orderName;
            this.chickenBiryani = chickenBiryani;
            this.chilliChicken = chilliChicken;
            this.vegBiryani = vegBiryani;
        }


        public Connection createConnection() {

            Connection connection = null;
            try {
                Class.forName("org.postgres.Driver");
                connection = DriverManager.
                        getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "iHateyou7");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        public ResultSet getOrder(Connection connection) {
            return null;
        }

        public void setOrder(Connection conncection) {
        }
    }