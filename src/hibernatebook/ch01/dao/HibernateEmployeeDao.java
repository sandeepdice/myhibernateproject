package hibernatebook.ch01.dao;

import java.util.List;

import hibernatebook.ch01.UserInfo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateEmployeeDao extends HibernateDaoSupport {

	public void addUser(UserInfo userInfo) {
		getHibernateTemplate().saveOrUpdate(userInfo);
	}

	public List<UserInfo> getUser(String name) {
		List<UserInfo> list = getHibernateTemplate().find(
				"from hibernatebook.ch01.UserInfo user where user.firstName = '"
						+ name + "'");
		return list;
	}
}
