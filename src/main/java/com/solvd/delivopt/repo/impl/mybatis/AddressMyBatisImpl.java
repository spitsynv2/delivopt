package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Address;
import com.solvd.delivopt.repo.IAddressDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class AddressMyBatisImpl extends AbstractBaseMyBatisImpl<Address,Long> implements IAddressDAO {
    private static final Logger log = LogManager.getLogger(AddressMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IAddressDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Address";
    }

    @Override
    public Address readByClientId(Long clientId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);

            Address address = mapper.readByClientId(clientId);

            log.info("Address: {} was successfully read from database, by clientId {}", address, clientId);
            return address;
        } catch (Exception e) {
            log.error("Error in readByClientId: {}", clientId, e);
            return null;
        }
    }

    @Override
    public Address readByWarehouseId(Long warehouseId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);

            Address address = mapper.readByWarehouseId(warehouseId);

            log.info("Address: {} was successfully read from database, by warehouseId {}", address, warehouseId);
            return address;
        } catch (Exception e) {
            log.error("Error in readByWarehouseId: {}", warehouseId, e);
            return null;
        }
    }

    @Override
    public Address readByCompanyId(Long companyId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);

            Address address = mapper.readByCompanyId(companyId);

            log.info("Address: {} was successfully read from database, by companyId {}", address, companyId);
            return address;
        } catch (Exception e) {
            log.error("Error in readByCompanyId: {}", companyId, e);
            return null;
        }
    }
}
