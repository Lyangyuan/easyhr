package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.utils.TimeUtil;
import com.boyuan.domain.InterviewRecord;
import com.boyuan.domain.Template;
import com.boyuan.domain.User;
import com.boyuan.dto.CreateRecordDTO;
import com.boyuan.repository.InterviewRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Service
public class InterviewRecordService {

    @Autowired
    private InterviewRecordRepository recordRepository;

    @Autowired
    private TemplateService templateService;

    public InterviewRecord getOne(Long id) throws Exception
    {
        InterviewRecord record = recordRepository.findOne(id);
        if(record == null){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        return record;
    }

    /**
     * 根据token获取
     */
    public InterviewRecord getByToken(String token) throws Exception{
        if(StringUtils.isEmpty(token)){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        InterviewRecord record = recordRepository.getByToken(token);
        if(record == null){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        return record;
    }

    public List<InterviewRecord> getRecordByCandidate(Long candidateId) throws Exception{
        if(candidateId == null){
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        List<InterviewRecord> records = recordRepository.listByCandidateId(candidateId);
        return records;
    }

    /**
     * 创建面试记录
     */
    public InterviewRecord create(User user,CreateRecordDTO recordDTO) throws Exception{
        try{
            InterviewRecord record = new InterviewRecord();

            // 模板
            Template template = templateService.getOne(recordDTO.getTemplateId());
            record.setRecord(template.getContent());

            // 生成token
            if(recordDTO.getEmployeeId() != null){
                record.setEmployeeId(recordDTO.getEmployeeId());
                record.setToken(UUID.randomUUID().toString());
            }

            record.setCandidateId(recordDTO.getCandidateId());
            record.setIsLocked(0);
            record.setStep(recordDTO.getStep());
            record.setCreatedUserId(user.getId());
            record.setModifiedUserId(user.getId());
            record.setGmtCreated(TimeUtil.now());
            record.setGmtModified(TimeUtil.now());

            record = recordRepository.saveAndFlush(record);
            return record;
        }catch (Exception e){
            throw new EasyhrException(ErrorMsg.SAVE_ERROR);
        }
    }

    /**
     * 填写
     */
    public InterviewRecord save(InterviewRecord record,User user) throws Exception{
        try{
            if(record.getId() == null){
                throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
            }
            InterviewRecord recordDB = getOne(record.getId());
            if(recordDB.getIsLocked() == 1){
                throw new EasyhrException("面试记录已锁定，请先解锁");
            }
            recordDB.setRecord(record.getRecord());
            recordDB.setGmtCreated(TimeUtil.now());
            recordDB.setModifiedUserId(user.getId());
            record = recordRepository.saveAndFlush(recordDB);
        }catch (Exception e){
            throw new EasyhrException(ErrorMsg.SAVE_ERROR);
        }
        return record;
    }

    /**
     * 保存2
     */
    public void save2(InterviewRecord record) throws Exception{
        InterviewRecord recordDB = getByToken(record.getToken());
        recordDB.setRecord(record.getRecord());
        recordDB.setGmtModified(TimeUtil.now());
        recordRepository.saveAndFlush(recordDB);
    }

    /**
     * 锁定或解锁
     */
    public void lock(User user,Long id) throws Exception{
        try{
            InterviewRecord record = getOne(id);
            // 只有创建者有解锁和锁定的权限
            if(!user.getId().equals(record.getCreatedUserId())){
                throw new EasyhrException("您无法做此操作，请联系此面试记录的创建者");
            }
            if(record.getIsLocked() == 1){
                // 解锁
                record.setToken(UUID.randomUUID().toString());
                record.setIsLocked(0);
            } else {
                // 锁定
                record.setToken(null);
                record.setIsLocked(1);
            }
            record.setModifiedUserId(user.getId());
            record.setGmtModified(TimeUtil.now());
            recordRepository.saveAndFlush(record);
        }catch (Exception e){
            throw new EasyhrException("锁定或解锁失败");
        }
    }
}
