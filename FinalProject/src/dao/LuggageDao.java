/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Luggage;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class LuggageDao {

    public static List<Luggage> queryLuggagesByIDs(String[] Luggages) {
        List<Luggage> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM laggage WHERE idlaggage IN (";
            StringBuilder queryBuilder = new StringBuilder(sql);
            for (int i = 0; i < Luggages.length; i++) {
                queryBuilder.append(" ?");
                if (i != Luggages.length - 1) {
                    queryBuilder.append(",");
                }
            }
            queryBuilder.append(")");
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(queryBuilder.toString());
            for (int i = 1; i <= Luggages.length; i++) {
                pstmt.setString(i, Luggages[i - 1]);
            }

            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Luggage l = new Luggage(rs.getString("idlaggage"), rs.getDouble("weight"), rs.getBoolean("isFragile"));
                res.add(l);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean insertNewLuggages(List<Luggage> luggages) {
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            // write into luggage table
            for (Luggage l : luggages) {

                String sql = "INSERT INTO laggage (idlaggage, weight, isFragile) VALUES (?, ?, ?)";

                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setString(1, l.getLuggageID());
                pstmt.setDouble(2, l.getWeight());
                pstmt.setBoolean(3, l.isIsFragile());

                int rs = pstmt.executeUpdate();
                if (rs <= 0) {
                    return false;
                }
                pstmt.close();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
