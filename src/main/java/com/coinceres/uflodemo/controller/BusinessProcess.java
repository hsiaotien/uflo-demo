package com.coinceres.uflodemo.controller;

import com.bstek.uflo.console.handler.impl.PageData;
import com.bstek.uflo.model.task.Task;
import com.bstek.uflo.model.task.TaskState;
import com.bstek.uflo.query.TaskQuery;
import com.bstek.uflo.service.ProcessService;
import com.bstek.uflo.service.StartProcessInfo;
import com.bstek.uflo.service.TaskOpinion;
import com.bstek.uflo.service.TaskService;
import com.bstek.uflo.utils.EnvironmentUtils;
import com.coinceres.uflodemo.domain.Demo;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/bp")
public class BusinessProcess {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ProcessService processService;
    @Autowired
    private TaskService taskService;

    @PostMapping("/startProcess")
    @Transactional
    public Object start(String name, String desc) {
        String id = UUID.randomUUID().toString();
        Session session = sessionFactory.openSession();
        try {
            Demo demo = new Demo();
            demo.setId(id);
            demo.setName(name);
            demo.setDesc(desc);
            session.save(demo);
            StartProcessInfo startProcessInfo = new StartProcessInfo(EnvironmentUtils.getEnvironment().getLoginUser());
            // 业务流程绑定
            startProcessInfo.setBusinessId(id);
            startProcessInfo.setCompleteStartTask(false);
            // el
            Map<String,Object> variables = new HashMap<>();
            variables.put("eluser","superman");
            variables.put("begin","beginTask");
            startProcessInfo.setVariables(variables);
            processService.startProcessByName("v1",startProcessInfo);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }

    @PostMapping("loadBusinessData")
    public Object loadBusinessData(String businessId) {
        Session session = sessionFactory.openSession();
        try {
            Demo demo = session.get(Demo.class, businessId);
            // 或者用hql取
            return demo;
        } finally {
            session.close();
        }
    }

    @PostMapping("/doApprove")
    @Transactional
    public Object approve(String opinion, String taskId) {
        long taskID = Long.valueOf(taskId);
        System.out.println("opinion: " + opinion);
        taskService.start(taskID);
        taskService.complete(taskID, new TaskOpinion(opinion));
        return null;
    }

    @GetMapping("loadTodo")
    public Object loadTodo(){
        String loginUsername = EnvironmentUtils.getEnvironment().getLoginUser();
        TaskQuery query = this.taskService.createTaskQuery();
        query.addTaskState(TaskState.Created);
        query.addTaskState(TaskState.InProgress);
        query.addTaskState(TaskState.Ready);
        query.addTaskState(TaskState.Suspended);
        query.addTaskState(TaskState.Reserved);
        query.addAssignee(loginUsername).addOrderDesc("createDate");
        List<Task> tasks = query.list();
        List<Task> list = new ArrayList<>();
        for (Task task: tasks) {
            Task newTask = new Task();
            list.add(newTask);
            newTask.setBusinessId(task.getBusinessId());
            newTask.setId(task.getId());
            newTask.setUrl(task.getUrl());
            newTask.setTaskName(task.getTaskName());
            newTask.setDescription(task.getDescription());
        }
        return list;
    }

    @PostMapping("startNodeTaskUrl")
    public Object startNodeTaskUrl(String desc, String taskId) {
        System.out.println("开始节点url-desc = " + desc + ",taskId=" + taskId);
        long taskID = Long.valueOf(taskId);
        taskService.start(taskID);
        taskService.complete(taskID);
        return null;
    }
}
