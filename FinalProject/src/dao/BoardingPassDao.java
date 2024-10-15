/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.BoardingPass;
import utils.DateUtils;

/**
 *
 * @author limingxia
 */
public class BoardingPassDao {

    public static BoardingPass createBPObject(ResultSet rs) throws SQLException {
        BoardingPass bp = new BoardingPass();

        bp.setBaggageCarousel(rs.getString("idLaggage"));
        bp.setBoardingTime(DateUtils.dateToString(rs.getDate("boardingTime")));
        bp.setFlightNo(rs.getString("idFlight"));
        // TODO ; split the string
        // bp.setLuggageList(Arrays.asList(rs.getString("idLaggage").split(",")));
        // TODO setSeat;
        // bp.setSeat(rs.getString("idSeat"));
        bp.setPortID(rs.getString("idPort"));

        return bp;
    }
}
