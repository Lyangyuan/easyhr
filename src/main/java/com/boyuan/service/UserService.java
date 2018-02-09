package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.domain.User;
import com.boyuan.repository.UserRepository;
import com.boyuan.vo.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author jiangbo
 * @time 2017/12/9
 */
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getUser(String account) throws Exception{
        User user = userRepository.getUserByAccount(account);
        if(user == null){
            throw new EasyhrException("user dose not exist");
        }
        return user;
    }
}
