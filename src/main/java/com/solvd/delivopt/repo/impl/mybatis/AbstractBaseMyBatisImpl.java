package com.solvd.delivopt.repo.impl.mybatis;

import com.solvd.delivopt.repo.IDAO;
import com.solvd.delivopt.util.MyBatisLoader;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-13
 */
public abstract class AbstractBaseMyBatisImpl<T,ID> implements IDAO<T,ID>{
    private static final Logger log = LogManager.getLogger(AbstractBaseMyBatisImpl.class);

    @Override
    public T readById(ID id) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAO<T, ID> daoMapper = (IDAO<T, ID>) mapper;

            T entity = daoMapper.readById(id);

            log.info("Entity: {} was successfully read from database", entity);
            return entity;
        } catch (Exception e) {
            log.error("Error in readById: {}", id, e);
            return null;
        }
    }

    @Override
    public void deleteById(ID id) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAO<T, ID> daoMapper = (IDAO<T, ID>) mapper;

            daoMapper.deleteById(id);
            session.commit();

            log.info("Successfully deleteById: {} from {} table.", id, getTableName());
        } catch (Exception e) {
            log.error("Error in deleteById: {} from {} table.", id, getTableName(), e);
        }
    }

    @Override
    public void create(T entity) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAO<T, ID> daoMapper = (IDAO<T, ID>) mapper;

            daoMapper.create(entity);
            session.commit();

            log.info("Successfully inserted {} to {} table.", entity, getTableName());
        } catch (Exception e) {
            log.error("Error in insertion: {} to {} table.", entity, getTableName(), e);
        }
    }

    @Override
    public void update(T entity) {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAO<T, ID> daoMapper = (IDAO<T, ID>) mapper;

            daoMapper.update(entity);
            session.commit();

            log.info("Successfully updated {} in {} table.", entity, getTableName());
        } catch (Exception e) {
            log.error("Error in update: {} in {} table.", entity, getTableName(), e);
        }
    }

    @Override
    public List<T> readAll() {
        try (SqlSession session = MyBatisLoader.getSqlSessionFactory().openSession()) {
            Object mapper = session.getMapper(getMapperClass());
            IDAO<T, ID> utility = (IDAO<T, ID>) mapper;

            List<T> entityList = utility.readAll();

            if (entityList != null && !entityList.isEmpty()) {
                log.info("{}List: {} were successfully readAll from database table: {}",
                        entityList.get(0).getClass().getSimpleName(), entityList, getTableName());
            } else {
                log.info("No records found in database table: {}", getTableName());
            }

            return entityList;
        } catch (Exception e) {
            log.error("Error in readAll, from table: {}",getTableName(), e);
            return null;
        }
    }

    protected abstract Class<?> getMapperClass();

    protected abstract String getTableName();
}
