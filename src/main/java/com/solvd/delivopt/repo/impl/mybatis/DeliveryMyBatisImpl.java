package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Delivery;
import com.solvd.delivopt.repo.IDeliveryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class DeliveryMyBatisImpl extends AbstractBaseMyBatisImpl<Delivery,Long> implements IDeliveryDAO {
    private static final Logger log = LogManager.getLogger(DeliveryMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IDeliveryDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Delivery";
    }
}
