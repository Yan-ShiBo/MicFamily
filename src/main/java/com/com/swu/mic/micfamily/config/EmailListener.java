package com.com.swu.mic.micfamily.config;

import com.com.swu.mic.micfamily.contorller.ListenController;
import com.com.swu.mic.micfamily.domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<ObjEvent> {

    @Autowired
    ListenController listencontroller;

    @Override
    public void onApplicationEvent(ObjEvent event) {
        Object source = event.getSource();
        // System.out.println(source);
        //System.out.println("监听到了...");
        /**
         *  邮件监听器，一旦有邮件事件，则会触发此处,接收到消息
         */

        Manager manager = event.getManager();
        listencontroller.saveMsg(manager);


    }

}
