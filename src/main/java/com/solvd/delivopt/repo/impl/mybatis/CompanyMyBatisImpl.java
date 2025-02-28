package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Company;
import com.solvd.delivopt.repo.ICompanyDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class CompanyMyBatisImpl extends AbstractBaseMyBatisImpl<Company,Long> implements ICompanyDAO {
    private static final Logger log = LogManager.getLogger(CompanyMyBatisImpl.class);

    @Override
    protected Class<?> getMapperClass() {
        return ICompanyDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Company";
    }
}
