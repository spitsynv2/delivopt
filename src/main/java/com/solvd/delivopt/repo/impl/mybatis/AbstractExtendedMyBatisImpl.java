package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.repo.IDAOUtility;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-25
 */
public abstract class AbstractExtendedMyBatisImpl<T,ID> extends AbstractBaseMyBatisImpl<T,ID> implements IDAOUtility<T,ID> {
    private static final Logger log = LogManager.getLogger(AbstractExtendedMyBatisImpl.class);

    @Override
    public List<T> readAllByForeignKeyId(ID foreignKeyId) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAOUtility<T, ID> IDAOCommonUtility = (IDAOUtility<T, ID>) mapper;

            List<T> entityList = IDAOCommonUtility.readAllByForeignKeyId(foreignKeyId);

            if (entityList != null && !entityList.isEmpty()) {
                log.info("{}List: {} were successfully readAllByForeignKeyId from database table: {}",
                        entityList.get(0).getClass().getSimpleName(), entityList, getTableName());
            } else {
                log.info("No records found in database table: {}", getTableName());
            }

            return entityList;
        } catch (Exception e) {
            log.error("Error in readAllByForeignKeyId: {}, from table: {}", foreignKeyId, getTableName(), e);
            return null;
        }
    }
}
