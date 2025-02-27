package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Delivery;
import com.solvd.delivopt.repo.IDeliveryDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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

    @Override
    public List<Delivery> readAllByOrderId(Long orderId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            List<Delivery> deliveries = mapper.readAllByOrderId(orderId);

            log.info("deliveries: {} was successfully read from database, by orderId {}", deliveries, orderId);
            return deliveries;
        } catch (Exception e) {
            log.error("Error in readAllByOrderId: {}", orderId, e);
            return null;
        }
    }

    @Override
    public void updateOrdersDelivery(Long newOrderId, Long newDeliveryId, Long orderId, Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.updateOrdersDelivery(newOrderId, newDeliveryId, orderId, deliveryId);
            session.commit();
            log.info("Successfully updated OrdersDelivery record with new orderId: {} and deliveryId: {}", newOrderId, newDeliveryId);
        } catch (Exception e) {
            log.error("Error updateOrdersDelivery orderId: {} and deliveryId: {}", orderId, deliveryId, e);
        }
    }

    @Override
    public void createOrdersDelivery(Long orderId, Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.createOrdersDelivery(orderId, deliveryId);
            session.commit();
            log.info("Successfully created OrdersDelivery record with orderId: {} and deliveryId: {}", orderId, deliveryId);
        } catch (Exception e) {
            log.error("Error createOrdersDelivery orderId: {} and deliveryId: {}", orderId, deliveryId, e);
        }
    }

    @Override
    public void deleteOrdersDelivery(Long orderId, Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.deleteOrdersDelivery(orderId, deliveryId);
            session.commit();
            log.info("Successfully deleteOrdersDelivery OrdersDelivery record with orderId: {} and deliveryId: {}", orderId, deliveryId);
        } catch (Exception e) {
            log.error("Error deleteOrdersDelivery orderId: {} and deliveryId: {}", orderId, deliveryId, e);
        }
    }

    @Override
    public List<Delivery> readAllByRouteId(Long routeId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            List<Delivery> deliveries = mapper.readAllByRouteId(routeId);

            log.info("deliveries: {} was successfully read from database, by routeId {}", deliveries, routeId);
            return deliveries;
        } catch (Exception e) {
            log.error("Error in readAllByRouteId: {}", routeId, e);
            return null;
        }
    }

    @Override
    public void updateDeliveryRoutes(Long newRouteId, Long newDeliveryId, Integer sequence, Long routeId, Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.updateDeliveryRoutes(newRouteId, newDeliveryId, sequence, routeId, deliveryId);
            session.commit();
            log.info("Successfully updated DeliveryRoutes record with new routeId: {} and deliveryId: {}", newRouteId, newDeliveryId);
        } catch (Exception e) {
            log.error("Error updateDeliveryRoutes routeId: {} and deliveryId: {}", routeId, deliveryId, e);
        }
    }

    @Override
    public void createDeliveryRoutes(Long routeId, Long deliveryId, Integer sequence) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.createDeliveryRoutes(routeId, deliveryId, sequence);
            session.commit();
            log.info("Successfully created DeliveryRoutes record with newRouteId: {} and deliveryId: {}", routeId, deliveryId);
        } catch (Exception e) {
            log.error("Error deleteOrdersDelivery routeId: {} and deliveryId: {}", routeId, deliveryId, e);
        }
    }

    @Override
    public void deleteDeliveryRoutes(Long routeId, Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IDeliveryDAO mapper = session.getMapper(IDeliveryDAO.class);

            mapper.deleteDeliveryRoutes(routeId, deliveryId);
            session.commit();
            log.info("Successfully deleted DeliveryRoutes record with routeId: {} and deliveryId: {}", routeId, deliveryId);
        } catch (Exception e) {
            log.error("Error deleteDeliveryRoutes routeId: {} and deliveryId: {}", routeId, deliveryId, e);
        }
    }
}
