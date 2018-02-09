package com.boyuan.service;

import com.boyuan.base.EasyhrException;
import com.boyuan.base.ErrorMsg;
import com.boyuan.base.utils.ObjectUtil;
import com.boyuan.domain.Post;
import com.boyuan.domain.User;
import com.boyuan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/1
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getOne(Long id) throws Exception {
        Post post = postRepository.findOne(id);
        if (post == null) {
            throw new EasyhrException(ErrorMsg.DATA_NOT_EXIST);
        }
        return post;
    }

    /**
     * 获取岗位列表
     */
    public List<Post> getPosts(final Post post) {
        Specification<Post> specification = new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(cb.equal(root.get("isDeleted").as(Integer.class), post.getIsDeleted()));
                if(!StringUtils.isEmpty(post.getPostName())){
                    predicates.add(cb.like(root.get("postName").as(String.class),"%"+post.getPostName()+"%"));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"gmtModified");
        List<Post> posts = postRepository.findAll(specification,sort);
        return posts;
    }

    public Post save(Post post, User user) throws Exception {
        try {
            post.setModifiedUserId(user.getId());
            post.setGmtModified(new Timestamp(System.currentTimeMillis()));
            if (post.getId() != null && !post.getId().equals(0L)) {
                Post postDB = getOne(post.getId());
                ObjectUtil.copyPropertiesIgnoreNull(post, postDB);
                post = postRepository.saveAndFlush(postDB);
            } else {
                post.setCreatedUserId(user.getId());
                post.setGmtCreated(new Timestamp(System.currentTimeMillis()));
                post = postRepository.saveAndFlush(post);
            }
            return post;
        } catch (Exception e) {
            throw new EasyhrException(ErrorMsg.SAVE_ERROR,e);
        }
    }

    public void delete(Long id,User user) throws Exception {
        try{
            Post post = getOne(id);
            post.setIsDeleted(1);
            save(post,user);
        } catch (Exception e){
            throw new EasyhrException(ErrorMsg.DELETE_ERROR,e);
        }
    }
}
