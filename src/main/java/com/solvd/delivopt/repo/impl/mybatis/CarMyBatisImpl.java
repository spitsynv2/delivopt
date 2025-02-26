package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.repo.ICarDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class CarMyBatisImpl extends AbstractExtendedMyBatisImpl<Car,Long> implements ICarDAO {
    private static final Logger log = LogManager.getLogger(CarMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return ICarDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Car";
    }
}
