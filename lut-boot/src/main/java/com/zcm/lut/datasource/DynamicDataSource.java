package com.zcm.lut.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ZCM
 * @package com.zcm.lut.datasource
 * @class DynamicDataSource
 * @date 2019/08/04
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitcher.getDataSource();
    }
}
