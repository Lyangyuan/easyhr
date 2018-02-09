package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.Candidate;
import com.boyuan.domain.User;
import com.boyuan.dto.CandidateDTO;
import com.boyuan.enums.CandidateStatusEnum;
import com.boyuan.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/3
 */
@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * 分页列表
     */
    public Page<Candidate> query(final CandidateDTO candidateDTO){
        Specification<Candidate> specification = new Specification<Candidate>() {
            @Override
            public Predicate toPredicate(Root<Candidate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if(!StringUtils.isEmpty(candidateDTO.getName())){
                    predicates.add(cb.like(root.get("name").as(String.class),"%"+candidateDTO.getName()+"%"));
                }
                if(!StringUtils.isEmpty(candidateDTO.getStatus())){
                    predicates.add(cb.equal(root.get("status").as(String.class),candidateDTO.getStatus()));
                }
                if(candidateDTO.getPostId() != null){
                    predicates.add(cb.equal(root.get("postId").as(Long.class),candidateDTO.getPostId()));
                }
                predicates.add(cb.equal(root.get("isDeleted").as(Integer.class), 0));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort;
        if(candidateDTO.getSortDir().equals("desc")){
            sort = new Sort(Sort.Direction.DESC,candidateDTO.getSortCol());
        } else {
            sort = new Sort(Sort.Direction.ASC,candidateDTO.getSortCol());
        }
        PageRequest pageRequest = new PageRequest(candidateDTO.getPageIndex(),candidateDTO.getPageSize(),sort);
        Page<Candidate> page = candidateRepository.findAll(specification,pageRequest);
        return page;
    }

    /**
     * 获取候选人
     */
    public Candidate getOne(Long id) throws Exception{
        Candidate candidate = candidateRepository.findOne(id);
        if(candidate == null){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        return candidate;
    }

    /**
     * 保存或更新候选人
     */
    public Candidate save(User user, Candidate candidate) throws Exception{
        try{
            if(candidate.getId() != null){
                Candidate candidateDB = candidateRepository.findOne(candidate.getId());
                ObjectUtil.copyPropertiesIgnoreNull(candidate,candidateDB);
                candidateDB.setModifiedUserId(user.getId());
                candidateDB.setGmtModified(TimeUtil.now());
                candidate = candidateRepository.saveAndFlush(candidateDB);
            } else {
                candidate.setGmtModified(TimeUtil.now());
                candidate.setGmtCreated(TimeUtil.now());
                candidate.setModifiedUserId(user.getId());
                candidate.setCreatedUserId(user.getId());
                candidate.setStatus(CandidateStatusEnum.a.getStatus());
                candidate = candidateRepository.saveAndFlush(candidate);
            }
        }catch (Exception e){
            throw new EasyhrException(ErrorMsg.SAVE_ERROR);
        }
        return candidate;
    }

    /**
     * 修改候选人状态
     */
    public void status(User user,Long id,String status) throws Exception{
        try {
            Candidate candidate = getOne(id);
            candidate.setStatus(status);
            candidate.setGmtModified(TimeUtil.now());
            candidate.setModifiedUserId(user.getId());
            candidateRepository.saveAndFlush(candidate);
        } catch (Exception e){
            throw new EasyhrException(ErrorMsg.SAVE_ERROR);
        }
    }

    /**
     * 入职操作
     */
    public void entry(Long id,User user){
        // TODO finish
    }

    /**
     * 下载
     */
    public void download(){
        // TODO finish
        //ExcelUtil.createExcel(null,null,"");
    }
}
