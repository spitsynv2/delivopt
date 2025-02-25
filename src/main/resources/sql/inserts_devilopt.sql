INSERT INTO `delivopt`.`Address` (`street`, `city`, `postcode`, `latitude`, `longitude`) VALUES 
('123 Main St', 'New York', '10001', 40.712776, -74.005974),
('456 Elm St', 'Los Angeles', '90001', 34.052235, -118.243683),
('789 Oak St', 'Chicago', '60601', 41.878113, -87.629799),
('101 Pine St', 'Houston', '77001', 29.760427, -95.369804),
('202 Maple St', 'Phoenix', '85001', 33.448376, -112.074036),
('303 Birch St', 'Philadelphia', '19101', 39.952583, -75.165222),
('404 Cedar St', 'San Antonio', '78201', 29.424122, -98.493628),
('505 Walnut St', 'San Diego', '92101', 32.715736, -117.161087),
('606 Cherry St', 'Dallas', '75201', 32.776665, -96.796989),
('707 Spruce St', 'San Jose', '95101', 37.338208, -121.886329);


INSERT INTO `delivopt`.`Client` (`client_name`, `email`, `phone_number`, `address_id`) VALUES 
('John Doe', 'john.doe@example.com', '123-456-7890', 1),
('Jane Smith', 'jane.smith@example.com', '234-567-8901', 2),
('Alice Johnson', 'alice.johnson@example.com', '345-678-9012', 3),
('Bob Brown', 'bob.brown@example.com', '456-789-0123', 4),
('Charlie Davis', 'charlie.davis@example.com', '567-890-1234', 5),
('Eve White', 'eve.white@example.com', '678-901-2345', 6),
('Frank Wilson', 'frank.wilson@example.com', '789-012-3456', 7),
('Grace Lee', 'grace.lee@example.com', '890-123-4567', 8),
('Henry Martinez', 'henry.martinez@example.com', '901-234-5678', 9),
('Ivy Garcia', 'ivy.garcia@example.com', '012-345-6789', 10);

INSERT INTO `delivopt`.`Company` (`company_name`, `address_id`) VALUES 
('Tech Corp', 1),
('Logistics Inc', 2),
('Global Goods', 3),
('Quick Ship', 4),
('Fast Freight', 5),
('Prime Delivery', 6),
('Swift Transport', 7),
('Reliable Logistics', 8),
('Express Cargo', 9),
('Speedy Services', 10);

INSERT INTO `delivopt`.`Warehouse` (`warehouse_address_id`, `warehouse_name`, `owner_company_id`) VALUES 
(1, 'Main Warehouse', 1),
(2, 'West Coast Hub', 2),
(3, 'Central Storage', 3),
(4, 'Southern Depot', 4),
(5, 'Desert Facility', 5),
(6, 'East Coast Center', 6),
(7, 'Northern Hub', 7),
(8, 'Pacific Warehouse', 8),
(9, 'Dallas Storage', 9),
(10, 'Silicon Valley Hub', 10);

INSERT INTO `delivopt`.`Goods` (`goods_name`, `description`, `weight`, `volume`) VALUES 
('Laptop', '15-inch laptop', 2.5, 0.03),
('Smartphone', 'Latest model smartphone', 0.2, 0.001),
('Tablet', '10-inch tablet', 0.5, 0.01),
('Monitor', '27-inch monitor', 5.0, 0.1),
('Printer', 'Laser printer', 10.0, 0.2),
('Desk', 'Office desk', 20.0, 1.0),
('Chair', 'Ergonomic chair', 15.0, 0.5),
('Bookshelf', 'Wooden bookshelf', 25.0, 1.5),
('Refrigerator', 'Mini fridge', 30.0, 0.8),
('Microwave', 'Compact microwave', 12.0, 0.3);

INSERT INTO `delivopt`.`Warehouse_Goods` (`warehouse_id`, `goods_id`, `quantity`) VALUES 
(1, 1, 100),
(2, 2, 200),
(3, 3, 150),
(4, 4, 50),
(5, 5, 75),
(6, 6, 30),
(7, 7, 60),
(8, 8, 40),
(9, 9, 20),
(10, 10, 80);

INSERT INTO `delivopt`.`Orders` (`client_id`, `destination_address_id`, `status`) VALUES 
(1, 2, 'PENDING'),
(2, 3, 'IN TRANSIT'),
(3, 4, 'DELIVERED'),
(4, 5, 'PENDING'),
(5, 6, 'IN TRANSIT'),
(6, 7, 'DELIVERED'),
(7, 8, 'PENDING'),
(8, 9, 'IN TRANSIT'),
(9, 10, 'DELIVERED'),
(10, 1, 'PENDING');

INSERT INTO `delivopt`.`Ordered_Warhouse_Goods` (`order_id`, `quantity`, `warehouse_id`, `goods_id`) VALUES 
(1, 5, 1, 1),
(2, 10, 2, 2),
(3, 3, 3, 3),
(4, 2, 4, 4),
(5, 1, 5, 5),
(6, 4, 6, 6),
(7, 6, 7, 7),
(8, 7, 8, 8),
(9, 8, 9, 9),
(10, 9, 10, 10);

INSERT INTO `delivopt`.`Car` (`car_type`, `max_weight_capacity`, `max_volume_capacity`, `owner_company_id`) VALUES 
('Van', 1000.0, 10.0, 1),
('Truck', 5000.0, 50.0, 2),
('SUV', 800.0, 5.0, 3),
('Pickup', 1500.0, 8.0, 4),
('Minivan', 1200.0, 7.0, 5),
('Box Truck', 3000.0, 20.0, 6),
('Cargo Van', 2000.0, 15.0, 7),
('Flatbed', 4000.0, 30.0, 8),
('Refrigerated Truck', 2500.0, 12.0, 9),
('Electric Van', 900.0, 6.0, 10);

INSERT INTO `delivopt`.`Routes` (`from_address_id`, `to_address_id`, `distance_km`, `estimated_time_min`) VALUES 
(1, 2, 500.0, 300),
(2, 3, 400.0, 240),
(3, 4, 600.0, 360),
(4, 5, 700.0, 420),
(5, 6, 800.0, 480),
(6, 7, 900.0, 540),
(7, 8, 1000.0, 600),
(8, 9, 1100.0, 660),
(9, 10, 1200.0, 720),
(10, 1, 1300.0, 780);

INSERT INTO `delivopt`.`Delivery` (`car_id`, `route_id`, `type`) VALUES 
(1, 1, 'WAREHOUSE_TO_CLIENT'),
(2, 2, 'WAREHOUSE_TO_WAREHOUSE'),
(3, 3, 'WAREHOUSE_TO_CLIENT'),
(4, 4, 'WAREHOUSE_TO_WAREHOUSE'),
(5, 5, 'WAREHOUSE_TO_CLIENT'),
(6, 6, 'WAREHOUSE_TO_WAREHOUSE'),
(7, 7, 'WAREHOUSE_TO_CLIENT'),
(8, 8, 'WAREHOUSE_TO_WAREHOUSE'),
(9, 9, 'WAREHOUSE_TO_CLIENT'),
(10, 10, 'WAREHOUSE_TO_WAREHOUSE');

INSERT INTO `delivopt`.`Orders_Delivery` (`order_id`, `delivery_id`) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);