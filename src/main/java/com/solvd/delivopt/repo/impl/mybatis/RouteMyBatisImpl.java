package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Order;
import com.solvd.delivopt.model.Route;
import com.solvd.delivopt.repo.IOrderDAO;
import com.solvd.delivopt.repo.IRouteDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class RouteMyBatisImpl extends AbstractExtendedMyBatisImpl<Route, Long> implements IRouteDAO {
    private static final Logger log = LogManager.getLogger(RouteMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IRouteDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Routes";
    }

    @Override
    public List<Route> readAllByDeliveryId(Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IRouteDAO mapper = session.getMapper(IRouteDAO.class);

            List<Route> routes = mapper.readAllByDeliveryId(deliveryId);

            log.info("Routes: {} was successfully read from database, by deliveryId {}", routes, deliveryId);
            return routes;
        } catch (Exception e) {
            log.error("Error in readAllByDeliveryId: {}", deliveryId, e);
            return null;
        }
    }
}
