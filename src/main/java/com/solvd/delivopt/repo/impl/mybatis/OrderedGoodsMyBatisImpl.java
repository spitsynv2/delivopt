package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.OrderedGoods;
import com.solvd.delivopt.repo.IOrderedGoodsDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderedGoodsMyBatisImpl {
    private static final Logger log = LogManager.getLogger(OrderedGoodsMyBatisImpl.class);

    public List<OrderedGoods> readAllByOrderId(Long orderId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            List<OrderedGoods> orderedGoods = mapper.readAllByOrderId(orderId);
            log.info("OrderedGoods: {} successfully read from database by orderId {}", orderedGoods, orderId);
            return orderedGoods;
        } catch (Exception e) {
            log.error("Error in readAllByOrderId: {}", orderId, e);
            return null;
        }
    }

    public List<OrderedGoods> readAllByWarehouseId(Long warehouseId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            List<OrderedGoods> orderedGoods = mapper.readAllByWarehouseId(warehouseId);
            log.info("OrderedGoods: {} successfully read from database by warehouseId {}", orderedGoods, warehouseId);
            return orderedGoods;
        } catch (Exception e) {
            log.error("Error in readAllByWarehouseId: {}", warehouseId, e);
            return null;
        }
    }

    public List<OrderedGoods> readAll() {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            List<OrderedGoods> orderedGoods = mapper.readAll();
            log.info("All OrderedGoods successfully read from database: {}", orderedGoods);
            return orderedGoods;
        } catch (Exception e) {
            log.error("Error in readAll", e);
            return null;
        }
    }

    public void deleteByOrderAndGoodsId(Long orderId, Long goodsId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            mapper.deleteByOrderAndGoodsId(orderId, goodsId);
            session.commit();
            log.info("OrderedGoods with orderId {} and goodsId {} successfully deleted from database", orderId, goodsId);
        } catch (Exception e) {
            log.error("Error in deleteByOrderAndGoodsId: orderId={}, goodsId={}", orderId, goodsId, e);
        }
    }

    public void update(Long orderId, OrderedGoods orderedGoods) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            mapper.update(orderId, orderedGoods);
            session.commit();
            log.info("OrderedGoods {} successfully updated in database for orderId {}", orderedGoods, orderId);
        } catch (Exception e) {
            log.error("Error in update: orderId={}, orderedGoods={}", orderId, orderedGoods, e);
        }
    }

    public void create(Long orderId, OrderedGoods orderedGoods) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderedGoodsDAO mapper = session.getMapper(IOrderedGoodsDAO.class);
            mapper.create(orderId, orderedGoods);
            session.commit();
            log.info("OrderedGoods {} successfully created in database for orderId {}", orderedGoods, orderId);
        } catch (Exception e) {
            log.error("Error in create: orderId={}, orderedGoods={}", orderId, orderedGoods, e);
        }
    }
}

