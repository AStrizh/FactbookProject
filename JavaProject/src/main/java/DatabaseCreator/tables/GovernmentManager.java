package DatabaseCreator.tables;

import DatabaseCreator.beans.Government;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;

public class GovernmentManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static boolean insert(Government bean) {

        String sql = "INSERT INTO Government " +
                "(countryCode, governmentType, capitalLat, capitalLng, timeDifference, " +
                "daylightSavingTime, independenceDate, nationalHoliday, legalSystem, citizenshipByBirth, " +
                "citizenshipByDescent, dualCitizenship, naturalization, suffrageAge, suffrageCompulsory, " +
                "chiefOfState, headOfGovernment, diplomatToUS, diplomatFromUS) " +
                "VALUES (?, ?, ?, ?, ?, " +"?, ?, ?, ?, ?, "+ "?, ?, ?, ?, ?, " + "?, ?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getGovernmentType());
            stmt.setDouble(3, bean.getCapitalLat());
            stmt.setDouble(4, bean.getCapitalLng());
            stmt.setString(5, bean.getTimeDifference());

            stmt.setString(6, bean.getDaylightSavingTime());
            stmt.setString(7, bean.getIndependenceDate());
            stmt.setString(8, bean.getNationalHoliday());
            stmt.setString(9, bean.getLegalSystem());

            stmt.setString(11, bean.getCitizenshipByDescent());
            stmt.setString(13, bean.getNaturalization());
            stmt.setString(14, bean.getSuffrageAge());

            stmt.setString(16, bean.getChiefOfState());
            stmt.setString(17, bean.getHeadOfGovernment());
            stmt.setString(18, bean.getDiplomatToUS());
            stmt.setString(19, bean.getDiplomatFromUS());


            if(bean.getCitizenshipByBirth() != null)
                stmt.setBoolean(10, bean.getCitizenshipByBirth());
            else
                stmt.setNull(10, Types.NULL);

            if(bean.getDualCitizenship() != null)
                stmt.setBoolean(12, bean.getDualCitizenship());
            else
                stmt.setNull(12, Types.NULL);

            if(bean.getSuffrageCompulsory() != null)
                stmt.setBoolean(15, bean.getSuffrageCompulsory());
            else
                stmt.setNull(15, Types.NULL);


            if (stmt.executeUpdate() != 1) {
                System.err.println("No rows affected");
                return false;
            } else
                return true;


        } catch (SQLException e) {
            DBUtil.processException(e);
            return false;
        }
    }

}
