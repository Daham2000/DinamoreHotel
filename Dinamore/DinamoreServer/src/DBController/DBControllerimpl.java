package DBController;

import Model.CustomOrder;
import Model.Order;
import Model.OrderDetails;
import dinamore.Common.Controller.DBController;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBControllerimpl implements DBController {

    public DBControllerimpl() {
    }

    private static DBControllerimpl dbcontrollerimpl;

    public static DBControllerimpl getInstance() {
        return dbcontrollerimpl == null ? dbcontrollerimpl = new DBControllerimpl() : dbcontrollerimpl;
    }

    @Override
    public void SaveOrder(Order order,OrderDetails orderde) throws RemoteException {
        try {
            Connection connection = DBConnection.DBConnection.getInstance().getConnection();
            String sql = "insert into Corder values(?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, order.getO_id());
            stm.setString(2, String.valueOf(order.getO_time()));
            stm.setString(3, String.valueOf(order.getTeleOprtrID()));
            stm.setString(4, order.getC_name());
            int r = stm.executeUpdate();
            if (r >= 1) {
                sql = "insert into OrderDetails values(?,?,?,?,?,?)";
                stm = connection.prepareStatement(sql);
                stm.setString(1, orderde.getO_id());
                stm.setString(2, orderde.getCheif_id());
                stm.setString(3, orderde.getTimeSpent());
                stm.setString(4, orderde.getProccesingTime());
                stm.setString(5, orderde.getOrderFinishTime());
                stm.setInt(6, orderde.getQty());
                stm.executeUpdate();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBControllerimpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBControllerimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
