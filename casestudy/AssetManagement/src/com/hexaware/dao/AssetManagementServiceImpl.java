package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.AssetManagementService;
import com.hexaware.model.Asset;
import com.hexaware.util.JdbcConnection;

public class AssetManagementServiceImpl implements AssetManagementService {
    private Connection con = JdbcConnection.getConnection();

    @Override
    public boolean addAsset(Asset asset) {
        String sql = "INSERT INTO assets (asset_id, name, type, serial_number, purchase_date, location, status, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, asset.getAssetId());
            ps.setString(2, asset.getName());
            ps.setString(3, asset.getType());
            ps.setString(4, asset.getSerialNumber());
            ps.setDate(5, java.sql.Date.valueOf(asset.getPurchaseDate()));
            ps.setString(6, asset.getLocation());
            ps.setString(7, asset.getStatus());
            ps.setInt(8, asset.getOwnerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAsset(Asset asset) {
        String sql = "UPDATE assets SET name=?, type=?, serial_number=?, purchase_date=?, location=?, status=?, owner_id=? WHERE asset_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, asset.getName());
            ps.setString(2, asset.getType());
            ps.setString(3, asset.getSerialNumber());
            ps.setDate(4, java.sql.Date.valueOf(asset.getPurchaseDate()));
            ps.setString(5, asset.getLocation());
            ps.setString(6, asset.getStatus());
            ps.setInt(7, asset.getOwnerId());
            ps.setInt(8, asset.getAssetId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAsset(int assetId) {
        String sql = "DELETE FROM assets WHERE asset_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assetId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Asset getAssetById(int assetId) {
        String sql = "SELECT * FROM assets WHERE asset_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assetId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Asset(
                        rs.getInt("asset_id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("serial_number"),
                        rs.getDate("purchase_date").toLocalDate(),
                        rs.getString("location"),
                        rs.getString("status"),
                        rs.getInt("owner_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Asset> getAllAssets() {
        String sql = "SELECT * FROM assets";
        List<Asset> assets = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                assets.add(new Asset(
                        rs.getInt("asset_id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("serial_number"),
                        rs.getDate("purchase_date").toLocalDate(),
                        rs.getString("location"),
                        rs.getString("status"),
                        rs.getInt("owner_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assets;
    }

    @Override
    public boolean allocateAsset(int assetId, int employeeId, String allocationDate) {
        String sql = "INSERT INTO asset_allocations (asset_id, employee_id, allocation_date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assetId);
            ps.setInt(2, employeeId);
            ps.setString(3, allocationDate);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deallocateAsset(int assetId, int employeeId, String returnDate) {
        String sql = "UPDATE asset_allocations SET return_date=? WHERE asset_id=? AND employee_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, returnDate);
            ps.setInt(2, assetId);
            ps.setInt(3, employeeId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) {
        String sql = "INSERT INTO maintenance_records (asset_id, maintenance_date, description, cost) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assetId);
            ps.setString(2, maintenanceDate);
            ps.setString(3, description);
            ps.setDouble(4, cost);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) {
        String sql = "INSERT INTO reservations (asset_id, employee_id, reservation_date, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, assetId);
            ps.setInt(2, employeeId);
            ps.setString(3, reservationDate);
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean withdrawReservation(int reservationId) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reservationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

