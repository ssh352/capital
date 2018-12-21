package com.bazinga.capital.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yunshan
 * @date 2018/12/21
 */

@Component
@Slf4j
public class TestJob {

    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("job test {}", simpleDateFormat.format(new Date()));
    }

}
