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
import model.Person;
import utils.JDBCUtil;

/**
 *
 * @author limingxia
 */
public class PersonDao {

    public static Person queryLoginByAccount(String email) {
        Person loginPerson = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE " + "account = ?";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, email);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                loginPerson = createPersonObject(rs);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loginPerson;
    }

    public static Person createPersonObject(ResultSet rs) throws SQLException {
        Person loginPerson = new Person();

        loginPerson.setPersonID(rs.getInt("idPersons"));
        loginPerson.setAccount(rs.getString("account"));
        loginPerson.setAge(rs.getInt("age"));
        loginPerson.setPassword(rs.getString("pw"));
        loginPerson.setRoleType(rs.getString("role"));
        loginPerson.setGender(rs.getString("gender"));
        loginPerson.setPersonName(rs.getString("name"));

        return loginPerson;
    }

    public static boolean insertNewPerson(Person person) {

        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO person ( `name`, account, gender, age, pw, role )\n"
                    + "VALUES\n"
                    + "	(?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, person.getPersonName());
            pstmt.setString(2, person.getAccount());
            pstmt.setString(3, person.getGender());
            pstmt.setInt(4, person.getAge());
            pstmt.setString(5, person.getPassword());
            pstmt.setString(6, person.getRoleType());

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

    public static String queryFCAdminByFCID(String fcID) {
        String fcadmin = "";

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person\n"
                    + "WHERE\n"
                    + "	role = " + enumvalue.RoleEnum.AIRBUS_ADMIN.getIndex() + "\n"
                    + "	AND idFlightCompany = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fcID);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("account");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return fcadmin;
    }

    static ArrayList<String> queryCrewListByFcID(String fcID) {
        ArrayList<String> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            // TODO 机组包含哪些人 who is crew?
            String sql = "SELECT\n"
                    + "	`name` \n"
                    + "FROM\n"
                    + "	person \n"
                    + "WHERE\n"
                    + "	role = 10 \n"
                    + "	AND idFlight = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                res.add(rs.getString("name"));
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    static ArrayList<String> queryCounterListByFcID(String fcID) {
        ArrayList<String> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            // TODO 机组包含哪些人 who is crew?
            String sql = "SELECT\n"
                    + "	`name` \n"
                    + "FROM\n"
                    + "	person \n"
                    + "WHERE\n"
                    + "	role = 11 \n"
                    + "	AND idFlight = ? ";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                res.add(rs.getString("name"));
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static boolean insertNewFCAdmin(Person faPerson, int flightCompanyId) {
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO person ( `name`, account, gender, age, pw, role, idFlightCompany)\n"
                    + "VALUES\n"
                    + "	(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt;
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, faPerson.getPersonName());
            pstmt.setString(2, faPerson.getAccount());
            pstmt.setString(3, faPerson.getGender());
            pstmt.setInt(4, faPerson.getAge());
            pstmt.setString(5, faPerson.getPassword());
            pstmt.setString(6, faPerson.getRoleType());
            pstmt.setInt(7, flightCompanyId);

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

    public static List<Person> queryAllPerson() {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT\n"
                    + "	* \n"
                    + "FROM\n"
                    + "	person";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {

                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean deletePersonByPid(Integer personID) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "DELETE FROM person WHERE idPersons = ?";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, personID);

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

    public static boolean updatePersonAge(int personId, int age) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE person \n"
                    + "SET age = ?\n"
                    + "WHERE\n"
                    + "	idPersons = ?";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, age);
            pstmt.setInt(2, personId);

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

    public static List<Person> querAllWorkersByFcID(Integer fcID) {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE idFlightCompany = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static List<Person> queryCrewAndCounterByFcID(Integer fcID) {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE idFlightCompany = ? AND role != 'Airbus Admin'";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static int queryFcAdminCompanyId(String account) {
        int fcId = 0;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idFlightCompany FROM person WHERE account = ?";
            PreparedStatement pstmt;

            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account);
            var rs = pstmt.executeQuery();

            if (rs.next()) {
                fcId = rs.getInt("idFlightCompany");
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fcId;
    }

    public static List<Person> querCrewAndCounterByFcID(Integer fcID) {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE idFlightCompany = ? AND role!='Airbus Admin'";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, fcID);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static boolean deletePersonByAccount(String account) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "DELETE FROM person WHERE account = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account);

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

    public static boolean updatePassword(String account, String newPassword) {
        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "UPDATE person SET pw = ? WHERE account = ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, account);

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

    public static boolean addTicket(String ticketId, String account) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "update person set idTicket=? where account =? ";

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, ticketId);
            pstmt.setString(2, account);

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

    public static boolean checkPersonInfo(String account, String name, String passport) {

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE account = ? and name=? and idpassport=? ";
            PreparedStatement ps;

            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, name);
            ps.setString(3, passport);

            var rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertNewCounter(Person newUser, Integer fcID) {
        try {

            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "INSERT INTO person ( `name`, account, gender, age, pw, role, idFlightCompany)\n"
                    + "VALUES\n"
                    + "	(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getPersonName());
            pstmt.setString(2, newUser.getAccount());
            pstmt.setString(3, newUser.getGender());
            pstmt.setInt(4, newUser.getAge());
            pstmt.setString(5, newUser.getPassword());
            pstmt.setString(6, newUser.getRoleType());
            pstmt.setInt(7, fcID);

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

    public static List<Person> queryAllGovernStaff() {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE role='Customs' OR role = 'Security Policeman'";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static List<Person> queryAllServiceStaff() {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT * FROM person WHERE role='Salesman' OR role = 'Greeter'";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static List<Person> queryAllAirportStaff() {
        List<Person> res = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            // TODO 少
            String sql = "SELECT * FROM person WHERE role='Traffic Control'";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = createPersonObject(rs);
                res.add(p);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }

    public static String getTicketByAccount(String account) {
        String res = null;

        try {
            Connection conn = JDBCUtil.getDataSource().getConnection();

            String sql = "SELECT idTicket FROM person WHERE account=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account);
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                res = rs.getString("idTicket");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {

        }

        return res;
    }
}
