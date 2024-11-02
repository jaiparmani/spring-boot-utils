package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PreventDowntime {
    @Scheduled(fixedDelay = 20000)
    public void run(){
      log.info("Heartbeat check");
    }

}
