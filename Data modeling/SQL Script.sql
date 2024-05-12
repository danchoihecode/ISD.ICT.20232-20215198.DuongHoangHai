CREATE TABLE `DeliveryInfo` (
  `id` int PRIMARY KEY,
  `name` varchar(45) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `instructions` varchar(200),
  `province` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL
);

CREATE TABLE `Product` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `value` int NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `imageURL` varchar(45) NOT NULL,
  `rushSupport` bool NOT NULL
);

CREATE TABLE `Order` (
  `id` int PRIMARY KEY,
  `shippingFees` float NOT NULL,
  `isRush` bool NOT NULL,
  `deliveryInfoId` int NOT NULL
);

CREATE TABLE `OrderProduct` (
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `productId` int NOT NULL,
  `orderId` int NOT NULL
);

CREATE TABLE `TransactionInfo` (
  `id` int PRIMARY KEY,
  `method` varchar(45) NOT NULL,
  `content` varchar(45) NOT NULL,
  `createTime` date NOT NULL,
  `invoiceId` int NOT NULL
);

CREATE TABLE `Book` (
  `id` int PRIMARY KEY,
  `author` varchar(45) NOT NULL,
  `coverType` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `publishDate` DATE NOT NULL,
  `language` varchar(45) NOT NULL,
  `noPages` int NOT NULL,
  `bookCategory` varchar(45) NOT NULL
);

CREATE TABLE `CD` (
  `id` int PRIMARY KEY,
  `releaseDate` Date,
  `artist` varchar(45) NOT NULL,
  `musicType` varchar(45) NOT NULL,
  `recordLabel` varchar(45) NOT NULL
);

CREATE TABLE `DVD` (
  `id` int PRIMARY KEY,
  `discType` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  `runTime` int NOT NULL,
  `studio` varchar(45) NOT NULL,
  `subtitle` varchar(45) NOT NULL,
  `releaseDate` DATE NOT NULL,
  `filmType` varchar(45) NOT NULL
);

CREATE TABLE `Invoice` (
  `id` int PRIMARY KEY,
  `totalAmount` int NOT NULL,
  `order_id` int NOT NULL
);

ALTER TABLE `Order` ADD FOREIGN KEY (`deliveryInfoId`) REFERENCES `DeliveryInfo` (`id`);

ALTER TABLE `OrderProduct` ADD FOREIGN KEY (`productId`) REFERENCES `Product` (`id`);

ALTER TABLE `OrderProduct` ADD FOREIGN KEY (`orderId`) REFERENCES `Order` (`id`);

ALTER TABLE `TransactionInfo` ADD FOREIGN KEY (`invoiceId`) REFERENCES `Invoice` (`id`);

ALTER TABLE `Book` ADD FOREIGN KEY (`id`) REFERENCES `Product` (`id`);

ALTER TABLE `CD` ADD FOREIGN KEY (`id`) REFERENCES `Product` (`id`);

ALTER TABLE `DVD` ADD FOREIGN KEY (`id`) REFERENCES `Product` (`id`);

ALTER TABLE `Invoice` ADD FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`);

ALTER TABLE `Order` ADD FOREIGN KEY (`shippingFees`) REFERENCES `Order` (`id`);

ALTER TABLE `TransactionInfo` ADD FOREIGN KEY (`content`) REFERENCES `TransactionInfo` (`id`);
