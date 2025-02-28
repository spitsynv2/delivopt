package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IGoodsDAO extends IDAO<Goods,Long> {
    List<Goods> readAllByWarehouseId(@Param("warehouseId") Long warehouseId);

    void deleteByWarehouseAndGoodsId(@Param("warehouseId") Long warehouseId,
                                     @Param("goodsId") Long goodsId);

    void updateByWarehouseAndGoodsId(@Param("warehouseId") Long warehouseId,
                                     @Param("goodsId") Long goodsId,
                                     @Param("quantity") Integer quantity);

    void createByWarehouseAndGoodsId(@Param("warehouseId") Long warehouseId,
                                     @Param("goodsId") Long goodsId,
                                     @Param("quantity") Integer quantity);
}
