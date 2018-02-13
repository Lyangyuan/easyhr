package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.RoleUser;
import com.boyuan.domain.User;
import com.boyuan.dto.UserDTO;
import com.boyuan.enums.RoleEnum;
import com.boyuan.repository.RoleUserRepository;
import com.boyuan.repository.UserRepository;
import com.boyuan.vo.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Autowired
    private RoleUserRepository roleUserRepository;

    private static final String DEFAULT_PASS = "123456789";

    public User getUser(String account) throws Exception{
        User user = userRepository.getUserByAccount(account);
        if(user == null){
            throw new EasyhrException("用户不存在");
        }
        return user;
    }

    public User getUser(Long id) throws Exception{
        User user = userRepository.findOne(id);
        if(user == null){
            throw new EasyhrException("用户不存在");
        }
        return user;
    }

    public List<RoleUser> getUsers(){
        return roleUserRepository.findAll();
    }

    @Transactional
    public void add(User currentUser,String nickname,String account,Integer role){
        User user = new User();
        user.setNickname(nickname);
        user.setAccount(account);
        user.setPassword(DEFAULT_PASS);
        user.setGmtModified(TimeUtil.now());
        user.setGmtCreated(TimeUtil.now());

        user = userRepository.saveAndFlush(user);

        // 添加角色
        RoleUser roleUser = new RoleUser();

        if(role == 2){
            roleUser.setRoleId(RoleEnum.ADMIN.getRole());
        } else{
            roleUser.setRoleId(RoleEnum.GENERAL_USER.getRole());
        }

        roleUser.setUserId(user.getId());
        roleUser.setCreatedUserId(currentUser.getId());
        roleUser.setModifiedUserId(currentUser.getId());
        roleUser.setGmtCreated(TimeUtil.now());
        roleUser.setGmtModified(TimeUtil.now());

        roleUserRepository.saveAndFlush(roleUser);
    }

    public User save(User user) throws Exception{
        if(user.getId() == null){
            if (user.getIsSuperAdmin() == 1){
                throw new EasyhrException("超级管理员禁止编辑");
            }
            user = userRepository.saveAndFlush(user);
        } else {
            User userDB = getUser(user.getId());
            forbidden(userDB);
            ObjectUtil.copyPropertiesIgnoreNull(user,userDB);
            user = userRepository.saveAndFlush(userDB);
        }
        return user;
    }

    public void freeze(Long id) throws Exception{
        User user = getUser(id);
        forbidden(user);
        if(user.getIsFreeze() == 1){
            user.setIsFreeze(0);
        } else {
            user.setIsFreeze(1);
        }
        user.setGmtModified(TimeUtil.now());
        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void delete(Long id) throws Exception{
        User user = getUser(id);
        forbidden(user);
        user.setIsDeleted(1);
        user.setGmtModified(TimeUtil.now());
        userRepository.saveAndFlush(user);

        roleUserRepository.deleteByUserId(id);
    }

    private void forbidden(User user) throws Exception{
        if(user.getIsSuperAdmin() == 1){
            throw new EasyhrException("超级管理员禁止编辑");
        }
    }
}
