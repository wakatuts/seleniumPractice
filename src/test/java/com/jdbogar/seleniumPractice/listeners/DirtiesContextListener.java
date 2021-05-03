package com.jdbogar.seleniumPractice.listeners;

import org.springframework.test.annotation.DirtiesContext.HierarchyMode;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class DirtiesContextListener extends AbstractTestExecutionListener{

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        testContext.markApplicationContextDirty(HierarchyMode.EXHAUSTIVE);
    }

}
