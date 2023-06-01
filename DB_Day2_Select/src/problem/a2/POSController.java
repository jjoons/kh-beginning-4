package problem.a2;

import java.sql.SQLException;
import java.util.List;

public class POSController {
  ItemDAO dao = new ItemDAO();

  public POSController() throws SQLException, ClassNotFoundException {}

  public List<ItemDTO> getList() {
    return this.dao.getList();
  }

  public void showList() {
    for (ItemDTO dto : this.getList()) {
      System.out.println(dto);
    }
  }
}
