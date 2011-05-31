package data.dbutil;

import java.sql.SQLException;

/**
 *
 * @author otniel
 */
public class MySqlException extends SQLException{

    @Override
    public String getMessage() {
        return "se renunta la inserare";
    }

}
