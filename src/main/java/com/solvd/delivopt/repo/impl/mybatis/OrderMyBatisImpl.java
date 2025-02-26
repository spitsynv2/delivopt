package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.repo.IOrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderMyBatisImpl extends AbstractExtendedMyBatisImpl<Order,Long> implements IOrderDAO {
    private static final Logger log = LogManager.getLogger(OrderMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IOrderDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Orders";
    }
}
