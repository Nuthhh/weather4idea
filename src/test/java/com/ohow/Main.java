package com.ohow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("测试日志输出info");
        logger.error("测试日志输出 ????error");
    }
}
