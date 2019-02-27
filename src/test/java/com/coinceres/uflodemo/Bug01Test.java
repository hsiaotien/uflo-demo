package com.coinceres.uflodemo;

import com.bstek.uflo.model.task.DateUnit;
import org.junit.Test;

/**
 * TaskParser 144 没有minute
 */
public class Bug01Test {

    @Test
    public void testBug01() {
        DateUnit minute = DateUnit.valueOf("Minute");
        System.out.println(minute);

    }
}
