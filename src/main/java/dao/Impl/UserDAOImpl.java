package dao.Impl;

import bean.UserBean;
import dao.DAO;

/**
 * Created by vito on 2016/8/17.
 */
public class UserDAOImpl extends DAO<UserBean> {
    /**
     * 登陆
     * @param userAccount
     * @param userPwd
     * @return
     */
    public boolean login(String userAccount,String userPwd){
        String sql = "select * from tb_user where user_account = ? and user_pwd = ?";
        return get(sql,userAccount,userPwd) != null;
    }
}
