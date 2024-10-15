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
import model.Flight;
import model.FlightCompany;
import model.Person;
import org.apache.commons.lang3.ObjectUtils;
import utils.Constant;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class FlightCompanyDao {

    public static List<FlightCompany> queryAllFlightCompany() {
        List<FlightCompany> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM `flight company`";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                FlightCompany fc = createFCObject(rs);
                res.add(fc);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return res;
    }

    private static FlightCompany createFCObject(ResultSet rs) throws SQLException {
        FlightCompany fc = new FlightCompany(rs.getInt("idflight company"), rs.getString("name"), rs.getString("admin"), rs.getString("counter"));

        return fc;
    }

    public static boolean insertNewFlightCompany(FlightCompany fc) {
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();
            // TODO 增加表字段
            String sql = "INSERT INTO `flight company` ( `name`, `admin`, counter)\n"
                    + "VALUES\n"
                    + "	( ?, ?, ?)";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fc.getFcName());
            pstmt.setString(2, fc.getAdmin());
            pstmt.setString(3, fc.getCounterList());

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

    public static Integer queryFCByName(String flightName) {
        Integer flightCompanyId = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT\n"
                    + "	`idflight company` \n"
                    + "FROM\n"
                    + "	`flight company` \n"
                    + "WHERE\n"
                    + "	`name` = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightName);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                flightCompanyId = rs.getInt("idflight company");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return flightCompanyId;
    }

    public static boolean updateCounter(Integer fcID, String counter) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE `flight company` SET counter= ? WHERE `idflight company` = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, counter);
            pstmt.setInt(2, fcID);

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

    public static String deleteFlightCompanyByFCID(Integer fcID) {

        // logic1: cannot be delete if this company has flight
        List<Flight> flights = FlightDao.queryFlightListByFCID(fcID);
        if (ObjectUtils.isNotEmpty(flights) || !flights.isEmpty()) {
            return "There Are Flights Belonging to This Company!";
        }
        // logic2: cannot be delete if this company has crew and counter (person)
        List<Person> workers = PersonDao.queryCrewAndCounterByFcID(fcID);
        if (ObjectUtils.isNotEmpty(workers) || !workers.isEmpty()) {
            return "There Are Crew And Counters Belonging to This Company!";
        }

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "DELETE FROM `flight company` WHERE `idflight company` = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);

            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return "";
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Constant.DATABASE_ERROR;
    }

    public static FlightCompany queryFlightCompanyByFCID(int fcID) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM `flight company` WHERE `idflight company`= ? ;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                FlightCompany fc = createFCObject(rs);
                return fc;
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static FlightCompany queryFlightCompanyNameByFlight(String flightNo) {
        FlightCompany flightCompany = null;
        int idCompany = 0;
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idCompany FROM flight WHERE idFlight = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightNo);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                idCompany = rs.getInt("idCompany");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }
        flightCompany = queryFlightCompanyByFCID(idCompany);
        return flightCompany;
    }

    public static List<String> queryFlightComNames() {
        List<String> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT name FROM `flight company`";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                res.add(name);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return res;
    }

    public static int getFcIdByName(String name) {
        int id = 0;
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT `idflight company` FROM `flight company` where name=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("idflight company");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return id;
    }

    public static Integer queryFCByCounter(Integer personID) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT `idflight company` FROM `flight company` fc, person p "
                    + "WHERE p.idFlightCompany = fc.`idflight company` AND idPersons =  ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, personID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("idflight company");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return null;
    }
}
