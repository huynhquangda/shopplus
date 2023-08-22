-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 17, 2023 at 02:09 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `estate`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `dtype` varchar(31) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_title` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`, `dtype`, `address`, `contact_name`, `contact_title`, `create_by`, `create_date`, `mobile`, `note`, `update_by`, `update_date`) VALUES
(1, 'demo@devcamp.edu.vn', '$2a$10$CC6mE43iO/AKyEPTPiaL/.2kX7dDeik1QTeyxOT3EH5y1pLTzVnf6', 'DevcampUser', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'gh@gmail.com', '$2a$10$HBuOiywF4BrtVz1G9P6iHegiMgqAy5JRvDEgDR1Zu1jk3FcKYAir2', 'DevcampUerrr', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'teo@gmail.com', '$2a$10$qOyTv35uCZr07LD4klIGzuJb6Tadj6.t9tXbybv6WfzLIIIwKneB.', 'CuTeoHeoNai', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'teoteo@gmail.com', '$2a$10$PKn8VbJISP77VOkgn9X2HeuGoa1BryqxV9MWn0kLjZQOrC2xbSdym', 'teoheonoc', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'da@gmail.com', '$2a$10$PbKbfwECmMUABYqa8W2hquzDUY6sMs5gERtwixAHjQw9mCM0y8OxW', 'DaHuynh', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'dahuynh@gmail.com', '$2a$10$oUkJGrBSLqgmbsYdkUR5dO3HxJNGjA4Hqjy0hV.CHqHQ9RNL/7lcW', 'DaHuynhQuang', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'abc@gmail.com', '$2a$10$VipIEhKjplhSzJLBL9frPOPSVK4jdjrB07lkkVBYsVjn4NOjPEdLu', 'abc', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'java@gmail.com', '$2a$10$0Er72gGCiWoIBLU.2ZJzKuPml32Yst/GyKIKVvWs9fRZmiAGWJIT6', 'java', '', 'TP HCM', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'python@gmail.com', '$2a$10$BE5DzAPhvb8jjMCFnTeFo.xuGAMcmqzIQ.IO6EH9YJXmW74ho/pPm', 'python', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'huynhquangda2016@gmail.com', '$2a$10$q7don4nt1ezm04t8lOZ0UuR3qgc0yKgssDNibErP48Rf6kYCsoRzm', 'huynhquangda', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'golang@gmail.com', '$2a$10$jn6hqSwidp8UyXq1Qjq.6eGLB2E3MUXDOMKjuPukICSE40v6MvQbq', 'golang', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'quy@gmail.com', '$2a$10$O3acejcSvppr2Fj7qUwA7e5WjHMkdxTexc.bEp58h9MFDkJD2Y9im', 'quy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, 'cuccu@gmail.com', '123456789', 'cuccu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'de@devcamp.edu.vn', '123456789', '1%', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(21, 'lan@gamil.com', '123456789', 'Ngo Di Lan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
