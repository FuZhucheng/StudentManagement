package com.user;

public interface IUserDao {
	/**
	 * 	
	 * @param user		传入VO对象
	 * @return				验证操作结果
	 * @throws Exception		抛出异常
	 */
	public boolean findLogin(Userstudent user) throws Exception;

	public void update(Userstudent user);
}
