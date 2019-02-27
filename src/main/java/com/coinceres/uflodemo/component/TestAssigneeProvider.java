package com.coinceres.uflodemo.component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.assign.AssigneeProvider;
import com.bstek.uflo.process.assign.Entity;
import com.bstek.uflo.process.assign.PageQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 指定处理人
 */
@Component
public class TestAssigneeProvider implements AssigneeProvider {
    @Override
    public boolean isTree() {
        return true;
    }

    @Override
    public String getName() {
        return "cc运营组成员列表";
    }

    @Override
    public void queryEntities(PageQuery<Entity> page, String s) {
        page.setRecordCount(20);
        int index = page.getPageIndex();
        int size = page.getPageSize();
        List<Entity> entitys = new ArrayList();
        Entity parameter = page.getQueryParameter();
        String id = null;
        if (parameter != null) {
            id = parameter.getId();
        }
        for(int i = (index - 1) * size; i < index * size; ++i) {
            if (id == null || String.valueOf(i).equals(id)) {
                Entity entity = new Entity("cc-manager" + i, "运营人员" + i);
                entitys.add(entity);
            }
        }
        page.setResult(entitys);
    }

    @Override
    public Collection<String> getUsers(String entityId, Context context, ProcessInstance processInstance) {
        List<String> users = new ArrayList();
        users.add(entityId);
        return users;
    }

    @Override
    public boolean disable() {
        return false;
    }
}
