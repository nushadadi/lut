package com.zcm.lut.datasource;

import org.springframework.util.Assert;

/**
 * @author ZCM
 * @package com.zcm.lut.datasource
 * @class DataSourceType
 * @date 2019/08/04
 **/
public class DataSourceSwitcher {

    @SuppressWarnings("rawtypes")
    private static final ThreadLocal contextHolder = new ThreadLocal();

    @SuppressWarnings("unchecked")
    public static void setDataSource(String dataSource) {
        Assert.notNull(dataSource, "dataSource cannot be null");
        contextHolder.set(dataSource);
    }

    public static void setMaster(){
        clearDataSource();
    }

    public static void setSlave() {
        setDataSource("slave");
    }

    public static String getDataSource() {
        return (String) contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}
