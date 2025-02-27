package br.com.frigorificos.pedidos.api.v1.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {

    private final Logger logger = LoggerFactory.getLogger("FRIGORIFICOS_PEDIDOS_API");

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

}
