package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.Employee;
import com.boyuan.domain.User;
import com.boyuan.dto.EmployeeDTO;
import com.boyuan.enums.SortDirEnum;
import com.boyuan.repository.EmployeeRepository;
import com.boyuan.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author jiangbo
 * @time 2018/1/19
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 分页查询
     */
    public Page<Employee> query(final EmployeeDTO employeeDTO){
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if(!StringUtils.isEmpty(employeeDTO.getName())){
                    predicates.add(cb.like(root.get("name").as(String.class),"%"+employeeDTO.getName()+"%"));
                }
                if(!StringUtils.isEmpty(employeeDTO.getName())){
                    predicates.add(cb.like(root.get("nickname").as(String.class),"%"+employeeDTO.getNickname()+"%"));
                }
                if(!StringUtils.isEmpty(employeeDTO.getStatus())){
                    predicates.add(cb.equal(root.get("status").as(String.class),employeeDTO.getStatus()));
                }
                if(employeeDTO.getPostId() != null){
                    predicates.add(cb.equal(root.get("postId").as(Long.class),employeeDTO.getPostId()));
                }
                if(employeeDTO.getSex() != null){
                    predicates.add(cb.equal(root.get("sex").as(Integer.class),employeeDTO.getSex()));
                }
                if(employeeDTO.getNumber() != null){
                    predicates.add(cb.equal(root.get("number").as(Integer.class),employeeDTO.getNumber()));
                }
                if(employeeDTO.getEntryTimeStart() != null){
                    predicates.add(cb.greaterThanOrEqualTo(root.get("entryDate").as(Timestamp.class),employeeDTO.getEntryTimeStart()));
                }
                if(employeeDTO.getEntryTimeEnd() != null){
                    predicates.add(cb.lessThanOrEqualTo(root.get("entryDate").as(Timestamp.class),employeeDTO.getEntryTimeEnd()));
                }
                predicates.add(cb.equal(root.get("isDeleted").as(Integer.class), 0));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort;
        if(SortDirEnum.DESC.getDir().equals(employeeDTO.getSortDir())){
            sort = new Sort(Sort.Direction.DESC,employeeDTO.getSortCol());
        } else {
            sort = new Sort(Sort.Direction.ASC,employeeDTO.getSortCol());
        }
        PageRequest pageRequest = new PageRequest(employeeDTO.getPageIndex(),employeeDTO.getPageSize(),sort);
        return employeeRepository.findAll(specification,pageRequest);
    }

    /**
     * 获取员工信息
     */
    public Employee getOne(Long id) throws Exception{
        Employee employee = employeeRepository.findOne(id);
        if(employee == null){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        return employee;
    }

    /**
     *
     */
    public void save(User user,Employee employee) throws Exception{
        try{
            Employee employeeDB = getOne(employee.getId());
            if(employeeDB.getIsLocked() == 1){
                throw new EasyhrException("此员工已锁定，无法修改");
            }
            ObjectUtil.copyPropertiesIgnoreNull(employee,employeeDB);
            employeeDB.setModifiedUserId(user.getId());
            employeeDB.setGmtModified(TimeUtil.now());

            employeeRepository.saveAndFlush(employeeDB);
        }catch (Exception e){
            throw new EasyhrException(ErrorMsg.SAVE_ERROR);
        }
    }

    /**
     * 解锁锁定
     */
    public void lock(User user, Long id) throws Exception{
        try{
            Employee employee = getOne(id);
            employee.setGmtCreated(TimeUtil.now());
            employee.setModifiedUserId(user.getId());
            if(employee.getIsLocked() == 1){
                // 解锁
                employee.setToken(UUID.randomUUID().toString());
                employee.setIsLocked(0);
            } else {
                // 锁定
                employee.setToken(null);
                employee.setIsLocked(1);
            }
            employeeRepository.saveAndFlush(employee);
        }catch (Exception e){
            throw new Exception(ErrorMsg.SAVE_ERROR);
        }
    }

    /**
     * 获取全部员工
     */
    public List<EmployeeVO> getAllEmployee(){
        List<EmployeeVO> employeeVOS = null;
        List<Employee> employees = employeeRepository.findAll();
        if(!CollectionUtils.isEmpty(employees)){
            employeeVOS = new ArrayList<EmployeeVO>(employees.size());
            EmployeeVO employeeVO;
            for (Employee employee : employees) {
                employeeVO = new EmployeeVO();
                ObjectUtil.copyPropertiesIgnoreNull(employee,employeeVO);
                employeeVOS.add(employeeVO);
            }
        }
        return employeeVOS;
    }
}
