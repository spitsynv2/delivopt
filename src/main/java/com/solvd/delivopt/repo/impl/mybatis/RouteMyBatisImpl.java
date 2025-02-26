package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.model.Route;
import com.solvd.delivopt.repo.IRouteDAO;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public class RouteMyBatisImpl extends AbstractExtendedMyBatisImpl<Route, Long> implements IRouteDAO {

    @Override
    protected Class<?> getMapperClass() {
        return IRouteDAO.class;
    }

    @Override
    protected String getTableName() {
        return "Routes";
    }
}
