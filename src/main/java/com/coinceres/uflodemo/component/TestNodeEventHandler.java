package com.coinceres.uflodemo.component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.NodeEventHandler;
import com.bstek.uflo.process.node.Node;
import org.springframework.stereotype.Component;

/**
 * 流程在进入及离开当前节点时触发的事件Bean
 */
@Component
public class TestNodeEventHandler implements NodeEventHandler {

    @Override
    public void enter(Node node, ProcessInstance processInstance, Context context) {
        System.out.println("事件bean，流程进入。。。NodeName：" + node.getName());
    }

    @Override
    public void leave(Node node, ProcessInstance processInstance, Context context) {
        System.out.println("事件bean，离开当前节点。。。NodeName：" + node.getName());
    }
}
