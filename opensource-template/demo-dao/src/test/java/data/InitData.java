package data;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitData {

	private static final Logger logger  = LoggerFactory.getLogger(InitData.class);

	private DataSource dataSource;

	public void init() throws Exception {
		logger.info("create table start...");
		ScriptRunner scriptRunner = new ScriptRunner(dataSource.getConnection());
		scriptRunner.setAutoCommit(true);

		InputStream is = InitData.class.getClassLoader().getResourceAsStream(
				"sql/clear.sql");
		scriptRunner.runScript(new InputStreamReader(is));
		is = InitData.class.getClassLoader().getResourceAsStream(
				"sql/createtable.sql");
		scriptRunner.runScript(new InputStreamReader(is));
		is = InitData.class.getClassLoader().getResourceAsStream(
				"sql/initdata.sql");
		scriptRunner.runScript(new InputStreamReader(is));
		scriptRunner.closeConnection();
		logger.info("create table finish");
		
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
