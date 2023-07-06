package ibatis;

import java.io.IOException;
import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMap {
  private static SqlMapClient sqlMapClient = null;

  public static SqlMapClient getSqlMapClientInstance() {
    String sqlMapConfigFile = "ibatis/SqlMapConfig.xml";

    if (sqlMapClient == null) {
      try (Reader reader = Resources.getResourceAsReader(sqlMapConfigFile)) {
        sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return sqlMapClient;
  }
}
