package com.coinceres.uflodemo.component;

import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.model.task.Task;
import com.bstek.uflo.process.handler.ReminderHandler;
import org.springframework.stereotype.Component;

@Component
public class TestReminderHandler implements ReminderHandler {

    @Override
    public void execute(ProcessInstance processInstance, Task task) {
        System.out.println("过期了，过期提醒bean-execute，可以发email or message");
    }
}
