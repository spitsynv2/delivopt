package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Goods;
import com.solvd.delivopt.repo.IGoodsDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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

    @Override
    public List<Goods> readAllByWarehouseId(Long warehouseId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IGoodsDAO mapper = session.getMapper(IGoodsDAO.class);

            List<Goods> goods = mapper.readAllByWarehouseId(warehouseId);

            log.info("Goods: {} was successfully read from database, by warehouseId {}", goods, warehouseId);
            return goods;
        } catch (Exception e) {
            log.error("Error in readAllByWarehouseId: {}", warehouseId, e);
            return null;
        }
    }

    @Override
    public void deleteByWarehouseAndGoodsId(Long warehouseId, Long goodsId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IGoodsDAO mapper = session.getMapper(IGoodsDAO.class);

            mapper.deleteByWarehouseAndGoodsId(warehouseId, goodsId);
            session.commit();
            log.info("Successfully deleted Warehouse_Goods record with warehouseId: {} and goodsId: {}", warehouseId, goodsId);
        } catch (Exception e) {
            log.error("Error deleteByWarehouseAndGoodsId warehouseId: {} and goodsId: {}", warehouseId, goodsId, e);
        }
    }

    @Override
    public void updateByWarehouseAndGoodsId(Long warehouseId, Long goodsId, Integer quantity) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IGoodsDAO mapper = session.getMapper(IGoodsDAO.class);

            mapper.updateByWarehouseAndGoodsId(warehouseId, goodsId, quantity);
            session.commit();
            log.info("Successfully updated Warehouse_Goods record with warehouseId: {} and goodsId: {}, quantity: {}", warehouseId, goodsId, quantity);
        } catch (Exception e) {
            log.error("Error updateByWarehouseAndGoodsId warehouseId: {} and goodsId: {}", warehouseId, goodsId, e);
        }
    }

    @Override
    public void createByWarehouseAndGoodsId(Long warehouseId, Long goodsId, Integer quantity) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IGoodsDAO mapper = session.getMapper(IGoodsDAO.class);

            mapper.createByWarehouseAndGoodsId(warehouseId, goodsId, quantity);
            session.commit();
            log.info("Successfully created Warehouse_Goods record with warehouseId: {} and goodsId: {}, quantity: {}", warehouseId, goodsId, quantity);
        } catch (Exception e) {
            log.error("Error createByWarehouseAndGoodsId warehouseId: {} and goodsId: {}", warehouseId, goodsId, e);
        }
    }
}
