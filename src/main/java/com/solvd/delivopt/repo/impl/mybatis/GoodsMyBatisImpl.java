package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Goods;
import com.solvd.delivopt.repo.IGoodsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class GoodsMyBatisImpl extends AbstractExtendedMyBatisImpl<Goods,Long> implements IGoodsDAO {
    private static final Logger log = LogManager.getLogger(GoodsMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IGoodsDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Goods";
    }
}
