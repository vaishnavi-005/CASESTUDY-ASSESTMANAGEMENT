package com.hexaware.dao;

import java.util.List;

import com.hexaware.model.Asset;

public interface AssetManagementService {
    boolean addAsset(Asset asset);
    boolean updateAsset(Asset asset);
    boolean deleteAsset(int assetId);
    Asset getAssetById(int assetId);
    List<Asset> getAllAssets();
    boolean allocateAsset(int assetId, int employeeId, String allocationDate);
    boolean deallocateAsset(int assetId, int employeeId, String returnDate);
    boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost);
    boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate);
    boolean withdrawReservation(int reservationId);
}
