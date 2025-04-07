package in.pwskills.akash.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import in.pwskills.akash.beans.EmployeeBO;

@DependsOnDatabaseInitialization
@Repository("dao")
@Profile(value = {"dev", "qa"})
public class MysqlEmployeeDaoImpl implements IEmployeeDao {
	
	static {
		System.out.println("MysqlEmployeeDaoImpl.class file is loading");
	}
	
	public MysqlEmployeeDaoImpl() {
		System.out.println("MysqlEmployeeDaoImpl:: Zero param constructor....");
		
	}
	
	//SELECT * FROM employee WHERE job IN ('batsman','bowler');
	private static final String GET_EMP_DESG = "SELECT * FROM employee WHERE job IN ";
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<EmployeeBO> fetchEmpByDesg(String cond) throws Exception {
		
		List<EmployeeBO> listBo = null;
		EmployeeBO bo = null;
		System.out.println("DATASOURCE TYPE IS :: "+dataSource.getClass().getName());
	
		try(Connection connection = dataSource.getConnection();
				//use connection and perform DB operation using plan JDBC
				Statement stmt = connection.createStatement();
				//use ResultSet to pull the records
				ResultSet resultSet = stmt.executeQuery(GET_EMP_DESG + cond + " ORDER BY ename")) {
		
				listBo = new ArrayList<>();
		
			//process ResultSet
			while(resultSet.next()) {
				//Copy Record from RS to BO Object
				bo = new EmployeeBO();
				bo.setEmpNo(resultSet.getInt(1));
				bo.setEmpName(resultSet.getString(2));
				bo.setJob(resultSet.getString(3));
				bo.setSalary(resultSet.getFloat(4));
				bo.setDeptNo(resultSet.getInt(5));
				bo.setMgrNo(resultSet.getInt(6));
				
				//adding BO to List<EmployeeBO>
				listBo.add(bo);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return listBo;
	}

}
