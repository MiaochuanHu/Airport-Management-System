/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.JDBCUtil;

/**
 *
 * @author Jiaf
 */
public class SeatDao {
        public static void insertNewSeat(String seatId, String flightNo, String level){
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO seat (idSeat, flightNo, class, sold)"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, seatId);
            pstmt.setString(2, flightNo);
            pstmt.setString(3, level);
            pstmt.setBoolean(4, false);
            
            int rs = pstmt.executeUpdate();
            if (rs > 0) {

            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String sellBSeat(String flightNo) {
       
        String seatId = null;
       
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            PreparedStatement pstmt1;
            pstmt1 = (PreparedStatement) conn.prepareStatement("select idseat from seat"
                    + " where sold = 'false' and class = 'Business' and flightNo = ?");
            pstmt1.setString(1, flightNo);
            ResultSet rs = pstmt1.executeQuery();
            if (rs.next()) {
                seatId = rs.getString("idseat");
            }
            else 
                return null;
            
            PreparedStatement ps2;
            ps2 = (PreparedStatement) conn.prepareStatement("update seat set sold = true"
                    + " where idseat =?");
            
            ps2.setString(1, seatId);
            int rs2 = ps2.executeUpdate();
            pstmt1.close();
            ps2.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatId;
    }
    
        public static String sellESeat(String flightNo) {
       
        String seatId = null;
       
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            PreparedStatement pstmt1;
            pstmt1 = (PreparedStatement) conn.prepareStatement("select idseat from seat"
                    + " where sold = 'false' and class = 'Economy' and flightNo = ?");
            pstmt1.setString(1, flightNo);
            ResultSet rs = pstmt1.executeQuery();
            if (rs.next()) {
                seatId = rs.getString("idseat");
            }
            else 
                return null;
            
            PreparedStatement ps2;
            ps2 = (PreparedStatement) conn.prepareStatement("update seat set sold = true"
                    + " where idseat =?");
            
            ps2.setString(1, seatId);
            
            int rs2 = ps2.executeUpdate();
                     
            pstmt1.close();
            ps2.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatId;
    }
}
