package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IWarehouseDAO extends IDAO<Warehouse,Long> {
    List<Warehouse> readAllByGoodsId(@Param("goodsId") Long goodsId);
}
