package com.coinceres.uflodemo.component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.ProcessEventHandler;
import org.springframework.stereotype.Component;

@Component
public class TestProcessEventHandler implements ProcessEventHandler {

    @Override
    public void start(ProcessInstance processInstance, Context context) {
        String businessId = processInstance.getBusinessId();
        System.out.println("processEvent事件bean,start()，businessId:" + businessId);
    }

    @Override
    public void end(ProcessInstance processInstance, Context context) {
        String businessId = processInstance.getBusinessId();
        System.out.println("processEvent事件bean,end()，businessId:" + businessId);
    }
}
