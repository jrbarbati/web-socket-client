package com.personal.executor;

import com.personal.batch.hatcher.annotation.DistributedBatch;
import com.personal.batch.hatcher.annotation.OrgIdParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PrintOrgIdExecutor
{
    private static final Logger log = LogManager.getLogger(PrintOrgIdExecutor.class);

    @DistributedBatch(name = "printOrgId")
    public void printOrgId(@OrgIdParam int orgId)
    {
        log.info("printOrgId started for org {}", orgId);
        System.out.println(orgId);
        log.info("printOrgId finished for org {}", orgId);
    }
}
