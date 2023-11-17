package com.hzh.common.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description: 全局错误处理
 * @Author: FXS) Hzh
 * @Date: 2023/11/14 16:29
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();

        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        // 构建错误消息
        String errorMessage = "An error occurred at " + formattedTime + ": " + e.getMessage();

        // 返回带有时间信息的错误消息和HTTP状态码
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);    }

}
