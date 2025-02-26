package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Address;
import com.solvd.delivopt.repo.IAddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class AddressMyBatisImpl extends AbstractExtendedMyBatisImpl<Address,Long> implements IAddressDAO {
    private static final Logger log = LogManager.getLogger(AddressMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IAddressDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Address";
    }
}
