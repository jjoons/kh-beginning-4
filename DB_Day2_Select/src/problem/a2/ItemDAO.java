package problem.a2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
  private POSDBConnect db = POSDBConnect.getInstance();
  private Connection con = this.db.getConnection();

  public ItemDAO() throws ClassNotFoundException, SQLException {}

  public List<ItemDTO> getList() {
    try {
      List<ItemDTO> items = new ArrayList<>();
      String sql = new StringBuilder().append("SELECT * FROM items").toString();
      PreparedStatement ps = this.con.prepareStatement(sql);
      ResultSet res = ps.executeQuery();

      while (res.next()) {
        int id = res.getInt("id");
        String item_name = res.getString("item_name");
        int item_stock = res.getInt("item_stock");
        int item_price = res.getInt("item_price");

        ItemDTO item = new ItemDTO(id, item_name, item_stock, item_price);

        items.add(item);
      }

      return items;
    } catch (SQLException e) {}

    return null;
  }

  public boolean insert(ItemDTO item) {
    try {
      String sql = new StringBuilder()
          .append("INSERT INTO items(item_name, item_stock, item_price) VALUES\n")
          .append("(?, ?, ?);").toString();
      PreparedStatement ps = this.con.prepareStatement(sql);

      ps.setString(1, item.getName());
      ps.setInt(2, item.getStock());
      ps.setInt(3, item.getPrice());

      ps.executeUpdate();

      return true;
    } catch (SQLException e) {}

    return false;
  }

  public boolean delete(ItemDTO item) {
    try {
      String sql = "DELETE FROM items WHERE id = ?";
      PreparedStatement ps = this.con.prepareStatement(sql);

      ps.setInt(1, item.getId());

      ps.execute();

      return true;
    } catch (SQLException e) {}

    return false;
  }
}
