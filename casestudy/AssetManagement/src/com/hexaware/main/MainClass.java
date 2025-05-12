package com.hexaware.main;


import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.dao.AssetManagementService;
import com.hexaware.model.Asset;
import com.hexaware.util.JdbcConnection;


public class MainClass {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		JdbcConnection connection = new JdbcConnection();
		connection.access();

        com.hexaware.dao.AssetManagementServiceImpl service = new com.hexaware.dao.AssetManagementServiceImpl();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Asset Management System ---");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Perform Maintenance");
            System.out.println("7. Reserve Asset");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1: 
                    System.out.print("Enter Asset ID: ");
                    int assetId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Asset Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Asset Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Serial Number: ");
                    String serialNumber = scanner.nextLine();
                    System.out.print("Enter Purchase Date (yyyy-mm-dd): ");
                    String purchaseDateStr = scanner.nextLine();
                    LocalDate purchaseDate = LocalDate.parse(purchaseDateStr);
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter Owner ID: ");
                    int ownerId = scanner.nextInt();
                    
                    Asset newAsset = new Asset(assetId, name, type, serialNumber, purchaseDate, location, status, ownerId);
                    if (service.addAsset(newAsset)) {
                        System.out.println("Asset added successfully!");
                    } else {
                        System.out.println("Failed to add the asset.");
                    }
                    break;
                
                case 2: 
                    System.out.print("Enter Asset ID to update: ");
                    int updateAssetId = scanner.nextInt();
                    scanner.nextLine(); 
                    Asset assetToUpdate = service.getAssetById(updateAssetId);
                    if (assetToUpdate != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        assetToUpdate.setName(newName);
                        
                        System.out.print("Enter new type: ");
                        String newType = scanner.nextLine();
                        assetToUpdate.setType(newType);
                        
                        System.out.print("Enter new serial number: ");
                        String newSerialNumber = scanner.nextLine();
                        assetToUpdate.setSerialNumber(newSerialNumber);
                        
                        System.out.print("Enter new purchase date (yyyy-mm-dd): ");
                        String newPurchaseDateStr = scanner.nextLine();
                        assetToUpdate.setPurchaseDate(LocalDate.parse(newPurchaseDateStr));
                        
                        System.out.print("Enter new location: ");
                        String newLocation = scanner.nextLine();
                        assetToUpdate.setLocation(newLocation);
                        
                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        assetToUpdate.setStatus(newStatus);
                        
                        System.out.print("Enter new owner ID: ");
                        int newOwnerId = scanner.nextInt();
                        assetToUpdate.setOwnerId(newOwnerId);
                        
                        if (service.updateAsset(assetToUpdate)) {
                            System.out.println("Asset updated successfully!");
                        } else {
                            System.out.println("Failed to update the asset.");
                        }
                    } else {
                        System.out.println("Asset not found.");
                    }
                    break;

                case 3: 
                    System.out.print("Enter Asset ID to delete: ");
                    int deleteAssetId = scanner.nextInt();
                    if (service.deleteAsset(deleteAssetId)) {
                        System.out.println("Asset deleted successfully!");
                    } else {
                        System.out.println("Failed to delete the asset.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter Asset ID: ");
                    int allocateAssetId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Allocation Date (yyyy-mm-dd): ");
                    String allocationDateStr = scanner.nextLine();
                    if (service.allocateAsset(allocateAssetId, employeeId, allocationDateStr)) {
                        System.out.println("Asset allocated successfully!");
                    } else {
                        System.out.println("Failed to allocate the asset.");
                    }
                    break;

                case 5: 
                    System.out.print("Enter Asset ID: ");
                    int deallocateAssetId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int deallocateEmployeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Return Date (yyyy-mm-dd): ");
                    String returnDateStr = scanner.nextLine();
                    if (service.deallocateAsset(deallocateAssetId, deallocateEmployeeId, returnDateStr)) {
                        System.out.println("Asset deallocated successfully!");
                    } else {
                        System.out.println("Failed to deallocate the asset.");
                    }
                    break;

                case 6: 
                    System.out.print("Enter Asset ID: ");
                    int maintenanceAssetId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Maintenance Date (yyyy-mm-dd): ");
                    String maintenanceDateStr = scanner.nextLine();
                    System.out.print("Enter Maintenance Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Maintenance Cost: ");
                    double cost = scanner.nextDouble();
                    if (service.performMaintenance(maintenanceAssetId, maintenanceDateStr, description, cost)) {
                        System.out.println("Maintenance performed successfully!");
                    } else {
                        System.out.println("Failed to perform maintenance.");
                    }
                    break;

                case 7: 
                    System.out.print("Enter Asset ID: ");
                    int reserveAssetId = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int reserveEmployeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Reservation Date (yyyy-mm-dd): ");
                    String reservationDateStr = scanner.nextLine();
                    System.out.print("Enter Start Date (yyyy-mm-dd): ");
                    String startDateStr = scanner.nextLine();
                    System.out.print("Enter End Date (yyyy-mm-dd): ");
                    String endDateStr = scanner.nextLine();
                    if (service.reserveAsset(reserveAssetId, reserveEmployeeId, reservationDateStr, startDateStr, endDateStr)) {
                        System.out.println("Asset reserved successfully!");
                    } else {
                        System.out.println("Failed to reserve the asset.");
                    }
                    break;

                case 8: 
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
