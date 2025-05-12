package com.hexaware.test;

import com.hexaware.dao.AssetManagementServiceImpl;
import com.hexaware.model.Asset;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AssetManagementTest {

    // Instance of the service to be tested
    AssetManagementServiceImpl service = new AssetManagementServiceImpl();

    @Test
    public void testAddAsset() {
        // Creating a new asset with a unique ID to avoid conflicts
        Asset asset = new Asset(76, "keyboard", "electronic", "SN-KB779",
                LocalDate.of(2025, 5, 10), "Chennai", "available", 123); // Employee 123 exists
        // Adding the asset to the system
        boolean result = service.addAsset(asset);
        // Asserting that the asset was added successfully
        assertTrue(result, "Asset should be added successfully.");
    }

    @Test
    public void testPerformMaintenance() {
        // Using an existing asset ID (13) to perform maintenance
        boolean result = service.performMaintenance(13, "2025-06-01", "Replaced battery", 300.0);
        // Asserting that the maintenance was recorded successfully
        assertTrue(result, "Maintenance should be recorded successfully.");
    }

    @Test
    public void testReserveAsset() {
        // Using an existing asset ID (13) and employee ID (123) to reserve the asset
        boolean result = service.reserveAsset(13, 123, "2025-06-05", "2025-06-10", "2025-06-15");
        // Asserting that the asset was reserved successfully
        assertTrue(result, "Asset should be reserved successfully.");
    }

    @Test
    public void testAssetNotFound() {
        // Attempting to retrieve an asset that doesn't exist (ID 9999)
        Asset asset = service.getAssetById(9999);
        // Asserting that the asset is null, as it does not exist in the database
        assertNull(asset, "Asset should be null for non-existing ID.");
    }
}
