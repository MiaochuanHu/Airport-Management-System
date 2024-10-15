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
import model.Passenger;
import model.Passport;
import model.Person;
import model.Ticket;
import org.apache.commons.lang3.ObjectUtils;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class PassenagerDao {

    public static List<Passenger> queryPassengersWithBP() {
        List<Passenger> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person p, ticket t "
                    + "WHERE p.idTicket=t.idTicket AND p.role = 'Passenger' AND p.idPassport != '' "
                    + "AND p.idTicket !='' AND t.isBoardingPass = TRUE";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {

                Passenger p = new Passenger();
                p.setGender(rs.getString("gender"));
                p.setAge(rs.getInt("age"));
                p.setPersonName(rs.getString("name"));

                String passportId = rs.getString("idPassport");
                Passport passport = PassportDao.queryPassportByPassportID(passportId);
                p.setPassport(passport);

                String ticketId = rs.getString("idTicket");
                Ticket ticket = TicketDao.queryTicketByTicketID(ticketId);
                p.setTicket(ticket);

                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean updatePassportID(int personID, String passportID) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE person \n"
                    + "SET idPassport = ? \n"
                    + "WHERE\n"
                    + "	idPersons = ?";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, passportID);
            pstmt.setInt(2, personID);

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

    public static List<Person> queryPersonByRoleType(String roleType) {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE role= ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, roleType);
            var rs = pstmt.executeQuery();

            while (rs.next()) {

                Person p = new Person();
                p.setGender(rs.getString("gender"));
                p.setPersonName(rs.getString("name"));
                p.setAccount(rs.getString("account"));
                p.setAge(rs.getInt("age"));
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String queryPassengerByTicketID(String ticketID) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT `name` from person WHERE idTicket = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {

                return rs.getString("name");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<Passenger> queryAllPassenagersWithPassport() {
        List<Passenger> res = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * from person WHERE role = 'Passenger' AND idPassport != ''";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Passenger p = new Passenger();
                p.setGender(rs.getString("gender"));
                p.setAge(rs.getInt("age"));
                p.setPersonName(rs.getString("name"));

                String passportId = rs.getString("idPassport");
                Passport passport = PassportDao.queryPassportByPassportID(passportId);
                if (ObjectUtils.isEmpty(passport)) {
                    continue;
                }
                p.setPassport(passport);

                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean updateTicketID(Integer personID, String ticketID) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE person SET idTicket = ? WHERE idPersons = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketID);
            pstmt.setInt(2, personID);

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

    public static List<Passenger> queryVipList() {
        List<Passenger> res = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * from person p, ticket t, seat s "
                    + "WHERE p.idTicket = t.idTicket AND t.idSeat = s.idSeat AND class = 'Business';";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Passenger p = new Passenger();
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setPersonName(rs.getString("name"));

                String ticketId = rs.getString("idTicket");
                Ticket ticket = TicketDao.queryTicketByTicketID(ticketId);
                if (ObjectUtils.isEmpty(ticket)) {
                    continue;
                }
                p.setTicket(ticket);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
