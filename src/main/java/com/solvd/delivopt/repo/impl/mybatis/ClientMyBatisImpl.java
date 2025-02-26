package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Client;
import com.solvd.delivopt.repo.IClientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class ClientMyBatisImpl extends AbstractBaseMyBatisImpl<Client,Long> implements IClientDAO  {
    private static final Logger log = LogManager.getLogger(ClientMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return IClientDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Client";
    }
}
