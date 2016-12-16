package com.fuzhu.studentmanager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.user.Slf4jTest;

public class DAO {
	  private static Logger Log = LoggerFactory.getLogger(Slf4jTest.class);

	// INSERT, UPDATE, DELETE操作都可以包含在其中
		public void update(String sql, Object... args) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = JDBCTools.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTools.release(null, preparedStatement, connection);
			}
		}
		
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		List<T> result = getForList(clazz, sql, args);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	// 查询多条记录，返回对应的对象的集合
		public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
			List<T> list = new ArrayList<>();

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				// 总步骤.（1） 得到结果集
				connection = JDBCTools.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
				resultSet = preparedStatement.executeQuery();
				// 总步骤（2）处理结果集，得到Map的List，其中一个Map对象就是一条记录。Map的key为resultSet中列的别名，Map的value为列的值
				// 5-11方法隔离抽取：处理结果集，得到Map的一个List，其中一个Map对象对应一条记录
				List<Map<String, Object>> values = handleResultSetToMapList(resultSet);

				// 总步骤（3）把Map的List转为clazz对应的List集合，其中Map的key即为clazz对应的对象的propertyName，而Map的value即为clazz对应的对象的propertyValue
				// 12.
				// 判断List是否为空，不为空则遍历List，得到一个一个的Map，再把一个Map对象转为一个对应的Class参数对应的Object对象。
				list = transferMapListToBeanList(clazz, values);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				JDBCTools.release(resultSet, preparedStatement, connection);
			}
			return list;
		}
		/**
		 * 处理结果集，得到Map的一个List，其中一个Map对象对应一条记录
		 * 
		 * @param resultSet
		 * @return
		 * @throws SQLException
		 */
		private List<Map<String, Object>> handleResultSetToMapList(ResultSet resultSet) throws SQLException {
			// 5.
			// 若ResultSet中有记录--准备一个List<Map<String,Object>>：键：存放列的别名；值：存放列的值。其中一个Map对象对应一条记录。
			List<Map<String, Object>> values = new ArrayList<>();

			// ResultSetMetaData rsmd =resultSet.getMetaData(); //优化这个方法
			List<String> columnLabels = getColumnLabels(resultSet);
			Map<String, Object> map = null;
			// 7. 处理ResultSet，用while遍历多少行
			while (resultSet.next()) {
				map = new HashMap<>();
				// 8.由ResultSetMetaData对象得到结果集中有多少列。遍历多少列。(含优化方法)
				// for(int i=0;i<rsmd.getColumnCount();i++){
				// String columnLabel = rsmd.getColumnLabel(i+1);
				// Object value= resultSet.getObject(i+1);
				// map.put(columnLabel, value);
				// }
				for (int i = 0; i < columnLabels.size(); i++) {
					// 优化：
					String columnLabel = columnLabels.get(i);
					Object value = resultSet.getObject(columnLabel); // 可以根据列名获取，也可以根据索引获取
					map.put(columnLabel, value);
				}
				// 11.把一条记录的一个Map对象放入5准备的List中
				values.add(map);
			}
			return values;
		}
		
		/**
		 * 把Map的List转为clazz对应的List集合，其中Map的key即为clazz对应的对象的propertyName，
		 * 而Map的value即为clazz对应的对象的propertyValue
		 * 
		 * @param clazz
		 * @param values
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws InvocationTargetException
		 */
		private <T> List<T> transferMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values)
				throws InstantiationException, IllegalAccessException, InvocationTargetException {
			List<T> result = new ArrayList<>();
			T bean = null;
			if (values.size() > 0) {
				for (Map<String, Object> m : values) {
					for (Map.Entry<String, Object> entry : m.entrySet()) {
						String propertyName = entry.getKey();
						Object value = entry.getValue();
						bean = clazz.newInstance();
						BeanUtils.setProperty(bean, propertyName, value);
					}
					// 13.把Object对象放入到list中。
					// 遍历Map对象，用反射填充对象的属性值：属性名为Map中的key，属性值为Map中的Value
					result.add(bean);
				}
			}
			return result;
		}
		// 优化方法：
		/**
		 * 获取结果集的ColumnLabel 对应的list
		 * 
		 * @param rs
		 * @return
		 * @throws SQLException
		 */
		private List<String> getColumnLabels(ResultSet rs) throws SQLException {
			List<String> labels = new ArrayList<>();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				labels.add(rsmd.getColumnLabel(i + 1));
			}
			return labels;
		}

}
