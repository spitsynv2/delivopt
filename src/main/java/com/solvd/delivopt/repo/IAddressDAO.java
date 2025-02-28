package com.solvd.delivopt.repo;

import com.solvd.delivopt.model.Address;

/**
 * @author Vadym Spitsyn
 * @created 2025-02-26
 */
public interface IAddressDAO extends IDAO<Address,Long> {
    Address readByClientId(Long clientId);
    Address readByWarehouseId(Long warehouseId);
    Address readByCompanyId(Long companyId);
}
