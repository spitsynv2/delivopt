package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Warehouse;
import com.solvd.delivopt.repo.IWarehouseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class WarehouseMyBatisImpl extends AbstractExtendedMyBatisImpl<Warehouse,Long> implements IWarehouseDAO {
    private static final Logger log = LogManager.getLogger(WarehouseMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IWarehouseDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Warehouse";
    }
}
