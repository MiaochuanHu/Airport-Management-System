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
import model.Ticket;
import org.apache.commons.lang3.StringUtils;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class TicketDao {

    public static Ticket queryTicketByTicketID(String ticketID) {
        Ticket res = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM	ticket t, seat s WHERE t.idSeat = s.idSeat AND idTicket = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                res = createTicketObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean updateDangerFlag(String ticketID, boolean haveDanger) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE ticket SET carryDanger = ?  WHERE idTicket = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setBoolean(1, haveDanger);
            pstmt.setString(2, ticketID);

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

    private static Ticket createTicketObject(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketID(rs.getString("idTicket"));

        if (StringUtils.isNotBlank(rs.getString("idFlight"))) {
            ticket.setFlightNo(rs.getString("idFlight"));
        }

        if (StringUtils.isNotBlank(rs.getString("boardingTime"))) {
            ticket.setBoardingTime(rs.getString("boardingTime"));
        }

        ticket.setCarryDanger(rs.getBoolean("carryDanger"));
        if (StringUtils.isNotBlank(rs.getString("from"))) {
            ticket.setFrom(rs.getString("from"));
        }
        if (StringUtils.isNotBlank(rs.getString("to"))) {
            ticket.setTo(rs.getString("to"));
        }
        ticket.setActualPrice(rs.getDouble("realPrice"));
        ticket.setPrintBoardingPass(rs.getBoolean("isBoardingPass"));
        ticket.setIsBorderCheck(rs.getBoolean("isBorderCheck"));

        if (StringUtils.isNotBlank(rs.getString("idLaggage"))) {
            ticket.setLaggageList(rs.getString("idLaggage"));
        }
        ticket.setPort(rs.getString("idPort"));
        ticket.setIdSeat(rs.getString("idSeat"));

        ticket.setIssuedGift(rs.getBoolean("issuedGift"));

        return ticket;
    }

    public static List<Ticket> queryDepartTickets() {
        List<Ticket> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM ticket t, flight f WHERE f.idFlight = t.idFlight";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Ticket t = createTicketObject(rs);
                res.add(t);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String queryLagguageIDByTID(String ticketID) {
        String res = "";
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idLaggage FROM ticket WHERE idTicket = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                res = rs.getString("idLaggage");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean createBoardingPass(Ticket ticket, String idLuggages) {

        try {
            Flight flight = FlightDao.queryFlightByID(ticket.getFlightNo());
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE ticket SET idLaggage = ? , isBoardingPass = TRUE, idPort = ? where idTicket = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, idLuggages);
            pstmt.setInt(2, flight.getParkingLot());
            // pstmt.setString(3, DateUtils.getBoardingTime(flight.getDepartTime()));
            pstmt.setString(3, ticket.getTicketID());

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

    public static boolean updateBorderCheckFlag(String ticketID) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE ticket SET isBorderCheck = TRUE WHERE idTicket = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketID);

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

    public static void createTicket(String ticketId, String seatId, String flightNo) {
        String fromto = FlightDao.getFromTo(flightNo);
        String boardingtime = FlightDao.getBoardingTime(flightNo);
        String[] arr = fromto.split(",");
        String from  = arr[0];
        String to = arr[1];
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO ticket (idTicket, idSeat, isBoardingPass, idFlight, `from`, `to`, boardingTime) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketId);
            pstmt.setString(2, seatId);
            pstmt.setBoolean(3, false);
            pstmt.setString(4, flightNo);
            pstmt.setString(5,from);
            pstmt.setString(6,to);
            pstmt.setString(7, boardingtime);

            int rs = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Ticket> queryAllNormalTicketNoBPByFcID(Integer fcID) {
        List<Ticket> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM ticket t, flight f WHERE f.idFlight = t.idFlight AND f.idCompany = ? ;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Ticket t = createTicketObject(rs);
                res.add(t);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Ticket getTicketById(String testId) {
        Ticket t = new Ticket();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * "
                    + "from ticket "
                    + "WHERE idTicket=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, testId);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                t = createTicketObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static boolean updateGiftFlag(String ticketID, boolean issued) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE ticket SET issuedGift = ? WHERE idTicket = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setBoolean(1, issued);
            pstmt.setString(2, ticketID);

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
    
    public static boolean getPassStats(String ticketId){
        boolean stats = false;
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT isBoardingPass "
                    + "from ticket "
                    + "WHERE idTicket=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketId);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                stats = rs.getBoolean("isBoardingPass");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }
    
    public static Ticket getTicket(String ticketId){
                Ticket t = new Ticket();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idFlight, boardingTime, idSeat, idPort, idLaggage"
                    + "FROM ticket "
                    + " WHERE idTicket = ?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketId);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                t.setFlightNo(rs.getString("idFlight"));
                t.setBoardingTime(rs.getString("boardingTime"));
                t.setIdSeat(rs.getString("idSeat"));
                t.setPort(rs.getString("idPort"));
                t.setLaggageList(rs.getString("idLaggage"));
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
