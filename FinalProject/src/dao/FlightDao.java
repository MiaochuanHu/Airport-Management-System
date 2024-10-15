/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Flight;
import model.FlightCompany;
import model.PieChartItem;
import org.apache.commons.lang3.StringUtils;
import utils.JDBCUtil;

/**
 * @author miaoc
 */
public class FlightDao {

    // Not Used Methods.
    public static List<Flight> getFlight() throws SQLException {
        List<Flight> res = new ArrayList<>();
        Connection conn = JDBCUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM flight";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                Flight newFlight = new Flight();

                res.add(newFlight);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static ArrayList<Flight> queryFlightListByFCID(Integer fcID) {
        ArrayList<Flight> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	flight \n"
                    + "WHERE\n"
                    + "	idCompany = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Flight f = createFlightObject(rs);
                res.add(f);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static ArrayList<Flight> queryFlightList() {
        ArrayList<Flight> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM flight";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Flight f = createFlightObject(rs);
                res.add(f);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    private static Flight createFlightObject(ResultSet rs) throws SQLException {
        Flight f = new Flight();

        f.setFlightNo(rs.getString("idFlight"));

        if (StringUtils.isNotBlank(rs.getString("idParkingLot"))) {
            f.setParkingLot(Integer.valueOf(rs.getString("idParkingLot")));
        }

        if (rs.getString("DepartureOrArrival").equals("1")) {
            f.setDepartureOrArrival(true);
        } else {
            f.setDepartureOrArrival(false);
        }

        if (StringUtils.isNotBlank(rs.getString("Status"))) {
            if (rs.getString("Status").equals("normal")) {
                f.setStatus(0);
            } else if (rs.getString("Status").equals("delay")) {
                f.setStatus(1);
            } else {
                f.setStatus(2);
            }
        } else {
            f.setStatus(0);
        }

        f.setAirport(rs.getString("airport"));
        f.setArrTime(rs.getString("timeArrival"));
        f.setDepartTime(rs.getString("timeDeparture"));
        f.setSeatStr(rs.getString("seatList"));

        int flightCompanyID = rs.getInt("idCompany");
        FlightCompany fc = FlightCompanyDao.queryFlightCompanyByFCID(flightCompanyID);
        f.setFlightCompany(fc);

        if (rs.getBoolean("onGround") == true || rs.getBoolean("onGround") == false) {
            f.setOnGround(rs.getBoolean("onGround"));
        }

        // TODO
        // too much attrs, if you need, plz add here
        return f;
    }

    public static boolean updateFlightTerminalAndRWY(int commandNumber, String flight) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();
            String sql = "UPDATE flight SET idParkingLot = ? WHERE idFlight = ?";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, commandNumber);
            pstmt.setString(2, flight);
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

    public static boolean addNewFlight(Flight newflight, int fcId, String seatList) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO flight ( idFlight, idCompany, timeArrival, timeDeparture, airport, DepartureOrArrival, seatList)"
                    + "VALUES	( ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, newflight.getFlightNo());
            pstmt.setInt(2, fcId);
            pstmt.setString(3, newflight.getArrTime());
            pstmt.setString(4, newflight.getDepartTime());
            pstmt.setString(5, newflight.getAirport());
            pstmt.setBoolean(6, newflight.getDepartureOrArrival());
            pstmt.setString(7, seatList);

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

    public static ArrayList<Flight> queryFlightListByDes(String des) {
        ArrayList<Flight> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idFlight, seatList, timeDeparture, timeArrival FROM flight WHERE airport = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, des);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Flight f = new Flight();
                f.setFlightNo(rs.getString("idFlight"));
                f.setAirport(des);
                f.setSeatStr(rs.getString("seatList"));
                f.setDepartTime(rs.getString("timeDeparture"));
                f.setArrTime(rs.getString("timeArrival"));
                res.add(f);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static List<String> allDes() {

        List<String> res = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT DISTINCT airport FROM flight;";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                String city = rs.getString("airport");
                res.add(city);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static boolean deleteFlightByID(String flightNo) {
        // delete = change the status ==> cancel
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();
            // delete flight
            String sql1 = "UPDATE flight SET `Status` = 'cancel' WHERE idFlight = ? ";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql1);
            pstmt.setString(1, flightNo);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }

            // no need to update other table
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean realDeleteFlightByID(String flightNo) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();
            // delete flight
            String sql = "DELETE FROM flight WHERE idFlight = ?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightNo);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }

            // no need to update other table
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Flight queryFlightByID(String flightNo) {
        Flight res = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM flight WHERE idFlight = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightNo);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                res = createFlightObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static List<PieChartItem> flightStatusStat() {
        List<PieChartItem> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT `Status`, COUNT(1) as `count` FROM flight GROUP BY `Status`";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                res.add(new PieChartItem(rs.getString("Status"), rs.getInt("count")));
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static boolean updateFlightInfo(Flight f, String fcName) {
        Flight flight = f;
        int id = FlightCompanyDao.getFcIdByName(fcName);
        //System.err.println(id+"--------------------");
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();
            String sql = "UPDATE flight "
                    + "SET idCompany=? , timeDeparture=?, timeArrival=?, seatList=? "
                    + "WHERE idFlight = ?";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, flight.getDepartTime());
            pstmt.setString(3, flight.getArrTime());
            pstmt.setString(4, flight.getSeatStr());
            pstmt.setString(5, flight.getFlightNo());

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

    public static boolean updateFlight(Flight curFlight, String status, int idParkingLot) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();
            // delete flight
            String sql1 = "UPDATE flight SET `Status` = ?, idParkingLot = ? WHERE idFlight = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql1);
            pstmt.setString(1, status);
            pstmt.setInt(2, idParkingLot);
            pstmt.setString(3, curFlight.getFlightNo());

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

    public static String getFromTo(String flightNo) {
        String fromto = null;
        Boolean stats = null;
        String airport = null;
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT DepartureOrArrival, airport  FROM flight WHERE idFlight = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightNo);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                stats = rs.getBoolean("DepartureOrArrival");
                airport = rs.getString("airport");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }
        if (stats) {
            fromto = "Boston," + airport;
        } else if (!stats) {
            fromto = airport + ",Boston";
        } else {
            return null;
        }

        return fromto;

    }

    public static String getBoardingTime(String flightNo) {
        String DeparTime = null;
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT timeDeparture FROM flight WHERE idFlight = ? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, flightNo);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                DeparTime = rs.getString("timeDeparture");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime depatDateTime = LocalDateTime.parse(DeparTime, dtf);
        String boardingTime = depatDateTime.minusMinutes(30).format(dtf);
        
        return boardingTime;

    }
}
