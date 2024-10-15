/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EntryExitRcd;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class ImmRecDao {

    public static List<EntryExitRcd> queryEntryExitRcdByPassportID(String passportID) {
        List<EntryExitRcd> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM immgrateRecord WHERE idpassport = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, passportID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                EntryExitRcd ee = createEEObject(rs);
                res.add(ee);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static EntryExitRcd createEEObject(ResultSet rs) throws SQLException {

        EntryExitRcd ee = new EntryExitRcd();
        ee.setPassportNumber(rs.getString("idpassport"));
        // TODO check date 
        ee.setDate(rs.getString("recordDate"));
        ee.setComments(rs.getString("comments"));
        ee.setFrom(rs.getString("from"));
        ee.setTo(rs.getString("to"));
        ee.setWithDanger(rs.getInt("withDanger") == 1);

        return ee;
    }

    public static boolean insertNewRec(EntryExitRcd ee) {
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();
            String sql = "INSERT INTO `immgraterecord` ( `idImmRecord`, `recordDate`, idpassport, `from`, `to`, withDanger, comments)\n"
                    + "VALUES\n"
                    + "	( ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ee.getImmId());
            pstmt.setString(2, ee.getDate());
            pstmt.setString(3, ee.getPassportNumber());
            pstmt.setString(4, ee.getFrom());
            pstmt.setString(5, ee.getTo());
            pstmt.setBoolean(6, ee.getWithDanger());
            pstmt.setString(7, ee.getComments());

            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
