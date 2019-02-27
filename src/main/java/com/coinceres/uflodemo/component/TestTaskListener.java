package com.coinceres.uflodemo.component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.model.task.Task;
import com.bstek.uflo.process.listener.TaskListener;
import com.bstek.uflo.process.node.TaskNode;
import org.springframework.stereotype.Component;

@Component
public class TestTaskListener implements TaskListener {
    @Override
    public boolean beforeTaskCreate(Context context, ProcessInstance processInstance, TaskNode taskNode) {
        System.out.println("人工任务节点监听bean-beforeTaskCreate()。taskName：" + taskNode.getTaskName()
                + ", businessId:" + processInstance.getBusinessId());
        return false;
    }

    @Override
    public void onTaskCreate(Context context, Task task) {
        System.out.println("人工任务节点监听bean-onTaskCreate(),taskName：" + task.getTaskName() +
                ", businessId:" + task.getBusinessId()
        + ",taskId=" + task.getId());

    }

    @Override
    public void onTaskComplete(Context context, Task task) {
        System.out.println("人工任务节点监听bean-onTaskCreate(),taskName：" + task.getTaskName() + ", businessId:" + task.getBusinessId()
                + ",taskId=" + task.getId());
    }
}
