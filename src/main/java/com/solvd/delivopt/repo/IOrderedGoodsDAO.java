package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.OrderedGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IOrderedGoodsDAO {

    List<OrderedGoods> readAllByOrderId(@Param("orderId") Long orderId);
    List<OrderedGoods> readAllByWarehouseId(@Param("warehouseId") Long warehouseId);
    List<OrderedGoods> readAll();
    void deleteByOrderAndGoodsId(@Param("orderId") Long orderId, @Param("goodsId") Long goodsId);
    void update(@Param("orderId") Long orderId, @Param("orderedGoods") OrderedGoods orderedGoods);
    void create(@Param("orderId") Long orderId, @Param("orderedGoods") OrderedGoods orderedGoods);
}