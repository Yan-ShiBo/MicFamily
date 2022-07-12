package com.com.swu.mic.micfamily.config;

import com.com.swu.mic.micfamily.domain.Manager;
import org.springframework.context.ApplicationEvent;

public class ObjEvent extends ApplicationEvent {

    private Manager manager;
    private String content;

    public ObjEvent(Object source, Manager manager, String content) {
        super(source);
        this.manager = manager;
        this.content = content;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ObjEvent(Object source) {
        super(source);
    }
}
