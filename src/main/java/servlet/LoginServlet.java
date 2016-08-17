package servlet;

import bean.TokenBean;
import com.google.gson.Gson;
import dao.Impl.UserDAOImpl;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.RedisAPI;
import utils.SecurityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆的servlet
 * Created by falling on 2016/3/11.
 */
@WebServlet( name = "login" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_SUCCESS = "success";
    public static final String LOGIN_FAILED = "failed";
    UserDAOImpl userDAO = new UserDAOImpl();
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JedisPool pool = RedisAPI.getPool();
        Jedis jedis =pool.getResource();
        String useraccount = request.getParameter("useraccount");
        String userpwd = request.getHeader("userpwd");
        System.out.println("useraccount="+useraccount+",userpwd="+userpwd);
            if(userDAO.login(useraccount,userpwd)) {

                Map<String , Object > map =  new HashMap<String , Object>();
                map.put("userAccount",useraccount);
                String str = SecurityUtil.authentication(map);
                jedis.set(useraccount,str);
                TokenBean tokenBean = new TokenBean(useraccount,str);
                response.getWriter().print(gson.toJson(tokenBean));

            }else{
                response.getWriter().print(LOGIN_FAILED);
            }
        }
    }

