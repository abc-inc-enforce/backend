package com.example.order.demo.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.Set;

// OrderController.java

@Controller
public class OrderController {

    private Set<String> tableSet = new HashSet<>(); // 테이블 번호를 저장할 Set

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/table")
    public void handleTableMessage(@Payload Table tableMessage, SimpMessageHeaderAccessor headerAccessor) {
        String tableNum = tableMessage.getTableNum();
        System.out.println(tableSet);
        System.out.println("num: " + tableNum);

        // 클라이언트가 새로운 테이블에 입장했을 때
        if (!tableSet.contains(tableNum)) {
            tableSet.add(tableNum);
            // 추가 작업 수행...
            System.out.println("New table entered: " + tableNum);

            // 클라이언트에게 알림 전송
            String destination = "/topic/table";
            messagingTemplate.convertAndSend(destination,  tableSet);
        }
    }

    @MessageMapping("/initTables")
    @SendTo("/topic/initialTables")
    public void initializeTables() {
        // 초기 테이블 정보를 반환
        messagingTemplate.convertAndSend("/topic/initialTables", tableSet);
    }




}

