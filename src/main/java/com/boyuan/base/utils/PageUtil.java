package com.boyuan.base.utils;

import com.boyuan.vo.PageResult;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @time 2018/1/3
 */
public class PageUtil {

    public static int pagesSize = 5;

    public static PageResult getPageResult(Page<?> page) {
        PageResult pageResult = new PageResult();
        int totalPage = page.getTotalPages();
        int currentPage = page.getNumber() + 1;
        int pre;
        int next;
        if(currentPage <= 1){
            pre = 1;
        } else {
            pre = currentPage -1;
        }

        if(currentPage >= totalPage){
            next = totalPage;
        } else {
            next = currentPage + 1;
        }

        List<Integer> pages = new ArrayList<Integer>();
        if(totalPage <= pagesSize){
            for (int i = 0; i < totalPage; i++) {
                pages.add(i+1);
            }
        } else {
            int n = currentPage / pagesSize;
            int nn = currentPage % pagesSize;
            System.out.println(n);
            if(nn == 0){
                for (int i = 1; i <= pagesSize; i++) {
                    pages.add(pagesSize * (n-1)+i);
                }
            } else {
                for (int i = 1; i <= pagesSize; i++) {
                    pages.add(pagesSize * n+i);
                }
            }
        }

        pageResult.setData(page.getContent());
        pageResult.setCurrentPage(currentPage);
        pageResult.setPages(pages);
        pageResult.setPrePage(pre);
        pageResult.setNextPage(next);
        return pageResult;
    }

    public static void main(String[] args) {
        // 1 2 3   4 5 6   7 8 9    10 11 12
        int n1 = 10;
        int size = 3;
        int n = n1 / size;
        int nn = n1 % size;
        System.out.println(n);
        if(nn == 0){
            for (int i = 1; i <= size; i++) {
                System.out.print(size * (n-1)+i+"  ");
            }
        } else {
            for (int i = 1; i <= size; i++) {
                System.out.print(size * n+i+"  ");
            }
        }
    }
}
