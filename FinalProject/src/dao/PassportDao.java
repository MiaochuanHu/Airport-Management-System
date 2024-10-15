/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Passport;
import org.apache.commons.lang3.StringUtils;
import utils.DateUtils;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class PassportDao {

    public static Passport queryPassportByPassportID(String passportID) {
        Passport res = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * from passport WHERE idpassport = ?";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, passportID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                res = createPassportObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static boolean insertNewOne(Passport passport) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO passport ( idpassport, legalName, expiryDate, dob, visa )\n"
                    + "VALUES\n"
                    + "	( ?, ?, ?, ?, ? )";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, passport.getPassportNumber());
            pstmt.setString(2, passport.getLegalName());
            pstmt.setDate(3, DateUtils.stringToSqlDate(passport.getExpiryDate()));
            pstmt.setDate(4, DateUtils.stringToSqlDate(passport.getBirthday()));
            pstmt.setString(5, passport.getVisa());

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

    public static Passport queryPassportNoByPid(Integer personID) {
        Passport res = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * from person p, passport pp \n"
                    + "WHERE p.idPassport = pp.idpassport\n"
                    + "AND p.idPersons= ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, personID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                res = createPassportObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    private static Passport createPassportObject(ResultSet rs) throws SQLException {
        Passport res = new Passport();

        res.setLegalName(rs.getString("legalName"));
        res.setPassportNumber(rs.getString("idpassport"));
        res.setExpiryDate(DateUtils.dateToString(rs.getDate("expiryDate")));
        res.setBirthday(DateUtils.dateToString(rs.getDate("dob")));
        if (StringUtils.isNotBlank(rs.getString("visa"))) {
            res.setVisa(rs.getString("visa"));
        }

        return res;
    }

    public static boolean updatePassportnfo(Passport passport) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE passport\n"
                    + "SET legalName = ?, expiryDate = ?, visa = ? \n"
                    + "WHERE idPassport = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, passport.getLegalName());
            pstmt.setDate(2, DateUtils.stringToSqlDate(passport.getExpiryDate()));
            pstmt.setString(3, passport.getVisa());
            pstmt.setString(4, passport.getPassportNumber());

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
