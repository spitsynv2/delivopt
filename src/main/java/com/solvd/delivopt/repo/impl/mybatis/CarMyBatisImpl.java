package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Car;
import com.solvd.delivopt.repo.ICarDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class CarMyBatisImpl extends AbstractBaseMyBatisImpl<Car,Long> implements ICarDAO {
    private static final Logger log = LogManager.getLogger(CarMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return ICarDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Car";
    }

    @Override
    public List<Car> readAllByCompanyId(Long companyId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            ICarDAO mapper = session.getMapper(ICarDAO.class);

            List<Car> cars = mapper.readAllByCompanyId(companyId);

            log.info("Cars: {} was successfully read from database, by companyId {}", cars, companyId);
            return cars;
        } catch (Exception e) {
            log.error("Error in readAllByCompanyId: {}", companyId, e);
            return null;
        }
    }

    @Override
    public Car readByDeliveryId(Long deliveryId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            ICarDAO mapper = session.getMapper(ICarDAO.class);

            Car car = mapper.readByDeliveryId(deliveryId);

            log.info("Cars: {} was successfully read from database, by deliveryId {}", car, deliveryId);
            return car;
        } catch (Exception e) {
            log.error("Error in readByDeliveryId: {}", deliveryId, e);
            return null;
        }
    }
}
