package com.niu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niu.dao.UserInfoDao;
import com.niu.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTkbatis1120ApplicationTests {

	@Autowired
	private UserInfoDao userInfoDao;

	@Test
	public void contextLoads() {
		UserInfo userInfo = userInfoDao.selectByPrimaryKey(9);
		System.out.println(userInfo);
	}

	@Test
	public void testAll(){
		List<UserInfo> list = userInfoDao.selectAll();
		list.forEach(System.out::println);
	}

	@Test
	public void test2(){
		Example example = new Example(UserInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("username","%h%");
		List<UserInfo> list = userInfoDao.selectByExample(example);
		list.forEach(System.out::println);
	}

	@Test
	public void testBetween(){
		//测试分页   测试条件查询
		PageHelper.startPage(1, 5);
		Example example = new Example(UserInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andBetween("id",11,20);
		List<UserInfo> list = userInfoDao.selectByExample(example);
		PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(list);
		System.out.println(userInfoPageInfo);

	}

	@Test
	public void testWhere(){
		Example example =  new Example(UserInfo.class);
		example.setOrderByClause("id desc");
		Example.Criteria criteria = example.createCriteria();
		criteria.andGreaterThan("id",25);
		List<UserInfo> list = userInfoDao.selectByExample(example);
		list.forEach(System.out::println);

	}
	@Test
	public void testWhere2(){
		Example example =  new Example(UserInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLessThan("id",25);
		criteria.andGreaterThan("id",15);
		List<UserInfo> list = userInfoDao.selectByExample(example);
		list.forEach(System.out::println);

	}

	@Test
	public void testGroup(){
		Example example = new Example(UserInfo.class);
//		criteria.andCondition("group by username");
		List<UserInfo> list = userInfoDao.selectByExample(example);
		System.out.println(list.size());
		list.forEach(System.out::println);

	}




}
