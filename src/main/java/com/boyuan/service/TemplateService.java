package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.domain.Template;
import com.boyuan.domain.User;
import com.boyuan.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public List<Template> getTemplates(String name){
        List<Template> templates = templateRepository.listByName(name);
        return templates;
    }

    public Template getOne(Long id) throws Exception{
        Template template = templateRepository.findOne(id);
        if(template == null){
            throw new EasyhrException("template not exist");
        }
        return template;
    }

    public Template save(Template template,User user) throws Exception{
        if(template == null){
            throw new EasyhrException("template must not be null");
        }
        template.setGmtModified(new Timestamp(System.currentTimeMillis()));
        template.setModifiedUserId(user.getId());
        if(template.getId() != null){
            Template templateDB = getOne(template.getId());
            ObjectUtil.copyPropertiesIgnoreNull(template,templateDB);
            template = templateRepository.saveAndFlush(templateDB);
        } else {
            template.setGmtCreated(new Timestamp(System.currentTimeMillis()));
            template.setCreatedUserId(user.getId());
            template = templateRepository.saveAndFlush(template);
        }
        return template;
    }

    public void delete(Long id,User user) throws Exception{
        Template template = getOne(id);
        template.setIsDeleted(1);
        save(template,user);
    }
}
