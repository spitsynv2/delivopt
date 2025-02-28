package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.repo.ICarDAO;
import com.solvd.delivopt.repo.IOrderDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class OrderMyBatisImpl extends AbstractExtendedMyBatisImpl<Order,Long> implements IOrderDAO {
    private static final Logger log = LogManager.getLogger(OrderMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IOrderDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Orders";
    }

    @Override
    public List<Order> readAllByClientId(Long clientId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);

            List<Order> orders = mapper.readAllByClientId(clientId);

            log.info("Orders: {} was successfully read from database, by clientId {}", orders, clientId);
            return orders;
        } catch (Exception e) {
            log.error("Error in readAllByClientId: {}", clientId, e);
            return null;
        }
    }

    @Override
    public List<Order> readAllByDeliveryId(Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);

            List<Order> orders = mapper.readAllByDeliveryId(deliveryId);

            log.info("Orders: {} was successfully read from database, by deliveryId {}", orders, deliveryId);
            return orders;
        } catch (Exception e) {
            log.error("Error in readAllByDeliveryId: {}", deliveryId, e);
            return null;
        }
    }
}
