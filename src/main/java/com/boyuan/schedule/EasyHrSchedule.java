package com.boyuan.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jiangbo
 * @time 2018/1/19
 */
@Component
public class EasyHrSchedule {

    public static Logger logger = LoggerFactory.getLogger(EasyHrSchedule.class);

    /**
     * 更新临时链接，删除过期的链接
     */
    @Scheduled(fixedDelay = 1000 * 60 *10)
    public void updateTempLink(){
        logger.info("start update temp link");

        logger.info("update temp link success");
    }
}
