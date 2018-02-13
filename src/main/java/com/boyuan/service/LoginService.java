package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.utils.JasyptUtil;
import com.boyuan.domain.User;
import com.boyuan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @author jiangbo
 * @date 2017\11\18 0018
 */
@Service
public class LoginService {

    public static Logger logger = LoggerFactory.getLogger(LoginService.class);

    private static String noMean = "yangyuanshishabi";

    @Autowired
    private UserRepository userRepository;

    /**
     * 登录
     */
    public User login(String account, String password) throws Exception{
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new EasyhrException("账号和密码不能为空");
        }
        User user = userRepository.getUserByAccount(account);
        // 密码错误
        //JasyptUtil.checkPassword(password,user.getPassword());
        if(user == null || !user.getPassword().equals(password)){
            throw new EasyhrException(String.format(ErrorMsg.PASSWORD_OR_ACCOUNT_WRONG,account));
        }
        if(user.getIsFreeze() == 1){
            throw new EasyhrException(ErrorMsg.ACCOUNT_FREEZON);
        }
        // 生成token
        Map<String,Object> tokenData = new HashMap<String,Object>(3);
        tokenData.put("account",account);
        tokenData.put("name",user.getNickname());
        tokenData.put("noMean",noMean);
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        user = userRepository.saveAndFlush(user);
        return user;
    }

    /**
     * 退出
     */
    public void logout(String account) throws Exception{
        User user = userRepository.getUserByAccount(account);
        user.setToken("");
        userRepository.saveAndFlush(user);
    }
}
