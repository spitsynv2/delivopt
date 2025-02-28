USE `delivopt`;

INSERT INTO `Address` (`street`, `city`, `postcode`, `latitude`, `longitude`) VALUES
('Mazowiecka 1', 'Warsaw', '00-001', 52.2298, 21.0122), -- Warehous
('Pilsudskiego 15', 'Warsaw', '00-010', 52.2200, 21.0050),
('Pulawska 30', 'Warsaw', '00-020', 52.2100, 21.0005),
('Saska 45', 'Warsaw', '00-030', 52.2000, 20.9950),
('Wilanowska 60', 'Warsaw', '00-040', 52.1900, 20.9900),
('Karmelicka 18', 'Krakow', '30-002', 50.0651, 19.9440), -- Warehous
('Zakopianska 22', 'Krakow', '30-003', 50.0500, 19.9300);

INSERT INTO `Client` (`client_name`, `email`, `phone_number`, `address_id`) VALUES
('Jan Kowalski', 'jan.kowalski@example.com', '+48 600 700 800', 2),
('Anna Nowak', 'anna.nowak@example.com', '+48 601 702 803', 3),
('Piotr Zielinski', 'piotr.zielinski@example.com', '+48 602 703 804', 4),
('Ewa Malinowska', 'ewa.malinowska@example.com', '+48 603 704 805', 5),
('Tomasz Nowicki', 'tomasz.nowicki@example.com', '+48 604 705 806', 6),
('Maria Wisniewska', 'maria.wisniewska@example.com', '+48 605 706 807', 7),
('Krzysztof Lewandowski', 'krzysztof.lewandowski@example.com', '+48 606 707 808', 7);

INSERT INTO `Company` (`company_name`, `address_id`) VALUES
('Fast Logistics', 1);

INSERT INTO `Warehouse` (`warehouse_name`, `warehouse_address_id`, `owner_company_id`) VALUES
('Warsaw Central Warehouse', 1, 1),
('Krakow Distribution Hub', 6, 1);

INSERT INTO `Goods` (`goods_name`, `description`, `weight`, `volume`) VALUES
('Laptop', 'High-end laptop', 2.5, 0.01),
('Smartphone', 'Latest model smartphone', 0.5, 0.002),
('Tablet', '10-inch tablet', 0.5, 0.01),
('Monitor', '27-inch monitor', 5.0, 0.1),
('Printer', 'Laser printer', 10.0, 0.2),
('Desk', 'Office desk', 20.0, 1.0),
('Chair', 'Ergonomic chair', 15.0, 0.5),
('Bookshelf', 'Wooden bookshelf', 25.0, 1.5),
('Refrigerator', 'Mini fridge', 30.0, 0.8),
('Microwave', 'Compact microwave', 12.0, 0.3);

INSERT INTO `Warehouse_Goods` (`warehouse_id`, `goods_id`, `quantity`) VALUES
(1, 1, 50),
(1, 2, 100),
(1, 3, 25),
(2, 1, 30),
(2, 2, 60);

INSERT INTO `Orders` (`client_id`, `destination_address_id`, `order_date`, `status`) VALUES
(1, 2, NOW(), 'PENDING'),
(2, 3, NOW(), 'PENDING'),
(3, 4, NOW(), 'PENDING'),
(4, 5, NOW(), 'PENDING'),
(5, 6, NOW(), 'PENDING'),
(6, 7, NOW(), 'PENDING'),
(7, 7, NOW(), 'PENDING');

INSERT INTO `Ordered_Warehouse_Goods` (`order_id`, `warehouse_id`, `goods_id`, `quantity`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 1, 1, 1),
(4, 1, 2, 2),
(5, 1, 1, 1),
(6, 1, 3, 1),
(7, 1, 3, 2);

INSERT INTO `Car` (`car_type`, `max_weight_capacity`, `max_volume_capacity`, `owner_company_id`) VALUES
('Van', 500, 5, 1),
('Van', 500, 5, 1),
('Van', 450, 4.5, 1);

INSERT INTO `Routes` (`from_address_id`, `to_address_id`, `distance_km`, `estimated_time_min`) VALUES
(1, 6, 300, 180); -- Warsaw to Krakow

INSERT INTO `Delivery` (`car_id`, `departure_time`, `estimated_arrival_time`, `type`) VALUES
(1, NOW(), DATE_ADD(NOW(), INTERVAL 3 HOUR), 'WAREHOUSE_TO_WAREHOUSE'),
(2, NOW(), DATE_ADD(NOW(), INTERVAL 30 MINUTE), 'WAREHOUSE_TO_CLIENT'),
(3, NOW(), DATE_ADD(NOW(), INTERVAL 30 MINUTE), 'WAREHOUSE_TO_CLIENT');

INSERT INTO `Orders_Delivery` (`order_id`, `delivery_id`) VALUES
(6, 1),
(7, 1),
(6, 3),
(7, 3),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2);

INSERT INTO `Delivery_routes` (`route_id`, `delivery_id`, `sequence`) VALUES
(1, 1, 1); -- Warsaw to Krakow for warehouse transfer
