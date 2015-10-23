package com.ahyc.eai.batch.data.financial.member;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.junit.Test;
import org.mo.com.data.FSql;
import org.mo.com.lang.FAttributes;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

public class TestFSynchronizeStatisticsMemberData {
    @Test
    public void testSynchronizedMember() {
        FAttributes attributes = RAop.configConsole().defineCollection()
                .attributes();
        attributes.set("application", "D:/Microbject/MoCloud/");
        RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
        IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
        FLogicContext logicContext = new FLogicContext(databaseConsole);
        FSynchronizeStatisticsMemberData.synchronizedMember(logicContext);

    }

    @Test
    public void test2222() {
        FAttributes attributes = RAop.configConsole().defineCollection()
                .attributes();
        attributes.set("application", "D:/Microbject/MoCloud/");
        RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
        IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
        FLogicContext logicContext = new FLogicContext(databaseConsole);
        FStatisticsFinancialDynamicLogic statisticsDynamicLogic = logicContext
                .findLogic(FStatisticsFinancialDynamicLogic.class);
        FSql whereCustomerId = new FSql();
        whereCustomerId
                .append(FStatisticsFinancialDynamicLogic.CUSTOMER_ACTION_DATE);
        whereCustomerId
                .append("= (SELECT MAX(`CUSTOMER_ACTION_DATE`) FROM `ST_FIN_DYNAMIC` AS D1 WHERE D1.`CUSTOMER_ID`="
                        + 1 + ")");
        FLogicDataset<FStatisticsFinancialDynamicUnit> StatisticsDynamicUnits = statisticsDynamicLogic
                .fetch(whereCustomerId);
        if (StatisticsDynamicUnits != null
                && StatisticsDynamicUnits.count() > 0) {
            System.out.println(StatisticsDynamicUnits.first()
                    .customerActionDate()
                    + "-----"
                    + StatisticsDynamicUnits.first().customerId());
        }

    }

}
