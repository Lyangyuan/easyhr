package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.domain.Resource;
import com.boyuan.domain.User;
import com.boyuan.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/5
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource getOne(Long id) throws Exception{
        Resource resource = resourceRepository.findOne(id);
        if(resource == null){
            throw new EasyhrException("resource is not exist");
        }
        return resource;
    }

    public Resource save(Resource resource,User user) throws Exception{
        if(resource == null){
            throw new EasyhrException("resource must not be null");
        }
        try{
            resource.setModifiedUserId(user.getId());
            resource.setGmtModified(new Timestamp(System.currentTimeMillis()));
            if(resource.getId() != null){
                Resource resourceDB = getOne(resource.getId());
                ObjectUtil.copyPropertiesIgnoreNull(resource,resourceDB);
                resource = resourceRepository.saveAndFlush(resourceDB);
            } else {
                resource.setCreatedUserId(user.getId());
                resource.setGmtCreated(new Timestamp(System.currentTimeMillis()));
                resource = resourceRepository.saveAndFlush(resource);
            }
            return resource;
        }catch (Exception e){
            throw new EasyhrException("save resource error",e);
        }
    }

    public void delete(Long id,User user) throws Exception{
        try{
            Resource resource = getOne(id);
            resource.setIsDeleted(1);
            save(resource,user);
        }catch (Exception e){
            throw new EasyhrException("delete resource error",e);
        }
    }

    public List<Resource> getByParentId(Long parentId){
        List<Resource> resources = resourceRepository.listByParentId(parentId);
        return resources;
    }
}
