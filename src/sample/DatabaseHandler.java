package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    static Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost/table_for_signup?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow&useLegacyDatetimeCode=false" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + ","
                + Const.USERS_LASTNAME + "," + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + ")"
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = null;

            prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirst_name());
            prSt.setString(2, user.getLast_name());
            prSt.setString(3, user.getLogin());
            prSt.setString(4, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USERS_LOGIN + "=? AND " +
                Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = null;

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void registercontract(Contracts contracts) {
        String insert = "INSERT INTO " + Constforcontracts.USER_TABLE + "("
                + Constforcontracts.EXECUTOR + "," + Constforcontracts.SUBJECT_NAME + "," + Constforcontracts.SUBJECT_TIN + "," + Constforcontracts.SUBJECT_EMAIL + "," + Constforcontracts.CONTRACT_DETAILS
                + "," + Constforcontracts.SUBJECT_OF_THE_CONTRACT + "," + Constforcontracts.CONTRACT_OBJECT + "," + Constforcontracts.CASE_STATUS + "," + Constforcontracts.DETAILS_OF_THE_PRETENSION + ","
                + Constforcontracts.PRETENSION_DATE + "," + Constforcontracts.PAYMENT_TERM + ","
                + Constforcontracts.AMOUNT_PAYABLE  + "," + Constforcontracts.STATE_OF_PRETENSION  + "," + Constforcontracts.TYPE_OF_CLAIM + ","
                + Constforcontracts.A_SIGN_OF_SPECIAL_IMPORTANCE  + "," + Constforcontracts.THE_CLAIM_FILING_DATE + "," + Constforcontracts.OUTGOING_NUMBER + ","
                + Constforcontracts.STATE_OF_CLAIM  + "," + Constforcontracts.DATE_OF_COURT_HEARING + "," + Constforcontracts.COURT_NAME + "," + Constforcontracts.COURT_NUMBER + ","
                + Constforcontracts.FULL_NAME_OF_JUDGE + "," + Constforcontracts.MEETING_STAGE + "," + Constforcontracts.THE_COURTS_DECISION + "," + Constforcontracts.EFFECTIVE_DATE + ","
                + Constforcontracts.NOTE + ")" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = null;

            prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(2, contracts.getSubject_name());
            prSt.setString(1, contracts.getExecutor());
            prSt.setString(3, contracts.getSubject_tin());
            prSt.setString(4, contracts.getSubject_email());
            prSt.setString(5, contracts.getContract_details());
            prSt.setString(6, contracts.getSubject_of_the_contract());
            prSt.setString(7, contracts.getContract_object());
            prSt.setString(8, contracts.getCase_status());
            prSt.setString(9, contracts.getDetails_of_the_pretension());
            prSt.setString(10, contracts.getPretension_date());
            prSt.setString(11, contracts.getPayment_term());
            prSt.setString(12, contracts.getAmount_payable());
            prSt.setString(13, contracts.getState_of_pretension());
            prSt.setString(14, contracts.getType_of_claim());
            prSt.setString(15, contracts.getA_sign_of_special_importance());
            prSt.setString(16, contracts.getThe_claim_filing_date());
            prSt.setString(17, contracts.getOutgoing_number());
            prSt.setString(18, contracts.getState_of_claim());
            prSt.setString(19, contracts.getDate_of_court_hearing());
            prSt.setString(20, contracts.getCourt_name());
            prSt.setString(21, contracts.getCourt_number());
            prSt.setString(22, contracts.getFull_name_of_judge());
            prSt.setString(23, contracts.getMeeting_stage());
            prSt.setString(24, contracts.getThe_courts_decision());
            prSt.setString(25, contracts.getEffective_date());
            prSt.setString(26, contracts.getNote());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getContracts(Contracts contracts) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Constforcontracts.USER_TABLE + " WHERE " + Constforcontracts.EXECUTOR + "=? AND " + Constforcontracts.SUBJECT_NAME +
                "=? AND " + Constforcontracts.SUBJECT_TIN + "=? AND " + Constforcontracts.SUBJECT_EMAIL + "=? AND " + Constforcontracts.CONTRACT_DETAILS + "=? AND " +
                Constforcontracts.SUBJECT_OF_THE_CONTRACT + "=? AND " + Constforcontracts.CONTRACT_OBJECT + "=? AND " + Constforcontracts.CASE_STATUS + "=? AND "
                + Constforcontracts.DETAILS_OF_THE_PRETENSION + "=? AND "  + Constforcontracts.PRETENSION_DATE + "=? AND " + Constforcontracts.PAYMENT_TERM + "=? AND "
                 + Constforcontracts.AMOUNT_PAYABLE  + "=? AND " + Constforcontracts.STATE_OF_PRETENSION  + "=? AND " + Constforcontracts.TYPE_OF_CLAIM + "=? AND "
                 + Constforcontracts.A_SIGN_OF_SPECIAL_IMPORTANCE  + "=? AND " + Constforcontracts.THE_CLAIM_FILING_DATE + "=? AND " + Constforcontracts.OUTGOING_NUMBER + "=? AND "
                 + Constforcontracts.STATE_OF_CLAIM  + "=? AND " + Constforcontracts.DATE_OF_COURT_HEARING + "=? AND " + Constforcontracts.COURT_NAME + "=? AND " + Constforcontracts.COURT_NUMBER + "=? AND "
                + Constforcontracts.FULL_NAME_OF_JUDGE + "=? AND " + Constforcontracts.MEETING_STAGE + "=? AND " + Constforcontracts.THE_COURTS_DECISION + "=? AND " + Constforcontracts.EFFECTIVE_DATE + "=? AND "
                + Constforcontracts.NOTE + "=?";

        try {
            PreparedStatement prSt = null;

            prSt = getDbConnection().prepareStatement(select);
            prSt.setString(2, contracts.getSubject_name());
            prSt.setString(1, contracts.getExecutor());
            prSt.setString(3, contracts.getSubject_tin());
            prSt.setString(4, contracts.getSubject_email());
            prSt.setString(5, contracts.getContract_details());
            prSt.setString(6, contracts.getSubject_of_the_contract());
            prSt.setString(7, contracts.getContract_object());
            prSt.setString(9, contracts.getDetails_of_the_pretension());
            prSt.setString(10, contracts.getPretension_date());
            prSt.setString(11, contracts.getPayment_term());
            prSt.setString(12, contracts.getAmount_payable());
            prSt.setString(13, contracts.getState_of_pretension());
            prSt.setString(14, contracts.getType_of_claim());
            prSt.setString(15, contracts.getA_sign_of_special_importance());
            prSt.setString(16, contracts.getThe_claim_filing_date());
            prSt.setString(17, contracts.getOutgoing_number());
            prSt.setString(18, contracts.getState_of_claim());
            prSt.setString(19, contracts.getDate_of_court_hearing());
            prSt.setString(20, contracts.getCourt_name());
            prSt.setString(21, contracts.getCourt_number());
            prSt.setString(22, contracts.getFull_name_of_judge());
            prSt.setString(23, contracts.getMeeting_stage());
            prSt.setString(24, contracts.getThe_courts_decision());
            prSt.setString(25, contracts.getEffective_date());
            prSt.setString(26, contracts.getNote());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
