package beans;

import db_connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tasneem
 */
@ManagedBean
@ViewScoped
public class ProfileBean implements Serializable {

    Connection cnn = new DB_Connection().getConnection();
    Statement stat;
}
