package com.solvd.delivopt.repo;

import java.util.List;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-13
 */
public interface IDAOUtility<T,ID> {
    List<T> readAllByForeignKeyId(ID id);
}
