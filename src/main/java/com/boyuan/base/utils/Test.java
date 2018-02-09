package com.boyuan.base.utils;

import com.boyuan.domain.Candidate;

/**
 * @author jiangbo
 * @time 2018/2/8
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Candidate candidate = new Candidate();
        candidate.setId(1L);
        candidate.setName("lijiangbo");
        candidate = JasyptUtil.encryptObject(candidate,Candidate.class);
        System.out.println(candidate.getName());
        candidate = JasyptUtil.decryptObject(candidate,Candidate.class);
        System.out.println(candidate.getName());
    }
}
