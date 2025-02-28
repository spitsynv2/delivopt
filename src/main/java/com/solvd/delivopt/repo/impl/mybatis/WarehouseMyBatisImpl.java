package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Goods;
import com.solvd.delivopt.model.Warehouse;
import com.solvd.delivopt.repo.IGoodsDAO;
import com.solvd.delivopt.repo.IWarehouseDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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

    @Override
    public List<Warehouse> readAllByGoodsId(Long goodsId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IWarehouseDAO mapper = session.getMapper(IWarehouseDAO.class);

            List<Warehouse> warehouses = mapper.readAllByGoodsId(goodsId);

            log.info("Warehouses: {} was successfully read from database, by goodsId {}", warehouses, goodsId);
            return warehouses;
        } catch (Exception e) {
            log.error("Error in readAllByGoodsId: {}", goodsId, e);
            return null;
        }
    }
}
