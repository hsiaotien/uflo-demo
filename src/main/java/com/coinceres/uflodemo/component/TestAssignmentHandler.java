package com.coinceres.uflodemo.component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.AssignmentHandler;
import com.bstek.uflo.process.node.TaskNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 指定处理者，指定bean
 */
@Component
public class TestAssignmentHandler implements AssignmentHandler {

    @Override
    public Collection<String> handle(TaskNode taskNode, ProcessInstance processInstance, Context context) {
        List<String> list = new ArrayList<>();
        list.add("manager");
        return list;
    }
}
