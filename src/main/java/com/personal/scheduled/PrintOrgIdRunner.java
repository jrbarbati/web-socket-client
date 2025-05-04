package com.personal.scheduled;

import com.personal.executor.PrintOrgIdExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "scheduled.print-org-id.enabled", matchIfMissing = true)
public class PrintOrgIdRunner
{
    private static final Logger log = LogManager.getLogger(PrintOrgIdRunner.class);

    private final PrintOrgIdExecutor printOrgIdExecutor;

    @Autowired
    public PrintOrgIdRunner(PrintOrgIdExecutor printOrgIdExecutor)
    {
        this.printOrgIdExecutor = printOrgIdExecutor;
    }

    @Scheduled(cron = "${scheduled.print-org-id.cron}")
    public void printOrgIds()
    {
        log.info("printOrgId started");

        for (int i = 1; i <= 10; i++)
            printOrgIdExecutor.printOrgId(i);

        log.info("printOrgId finished");
    }
}
