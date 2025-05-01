package com.personal.scheduled;

import com.personal.batch.hatcher.annotation.DistributedBatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "scheduled.print-org-id.enabled", matchIfMissing = true)
public class PrintOrgIdRunner
{
    private static final Logger log = LogManager.getLogger(PrintOrgIdRunner.class);

    @Scheduled(cron = "${scheduled.print-org-id.cron}")
    @DistributedBatch(name = "printOrgId", orgId = 1)
    public void printOrgId()
    {
        log.info("printOrgId started");
        System.out.println(1);
        log.info("printOrgId finished");
    }
}
