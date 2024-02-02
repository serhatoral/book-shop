package dev.serhat.bookshop.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

    public static  <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
