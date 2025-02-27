package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.OrderedGoods;
import com.solvd.delivopt.repo.IOrderedGoodsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderedGoodsMyBatisImpl implements IOrderedGoodsDAO {
    private static final Logger log = LogManager.getLogger(OrderedGoodsMyBatisImpl.class);

    @Override
    public OrderedGoods readById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void create(OrderedGoods entity) {

    }

    @Override
    public void update(OrderedGoods entity) {

    }

    @Override
    public List<OrderedGoods> readAll() {
        return List.of();
    }
}
