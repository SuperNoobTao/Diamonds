package test.dao.Impl; 

import dao.Impl.UserDAOImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UserDAOImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2016</pre> 
* @version 1.0 
*/ 
public class UserDAOImplTest { 
UserDAOImpl userDAO = new UserDAOImpl();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: login(String userAccount, String userPwd) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here...
    String userAccount = "1";
    String userPwd = "1";
    boolean i = userDAO.login(userAccount,userPwd);
    System.out.println(i);
} 


} 
