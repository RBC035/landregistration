-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 19, 2025 at 09:59 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `land`
--

-- --------------------------------------------------------

--
-- Table structure for table `land`
--

CREATE TABLE `land` (
  `land_id` varchar(20) NOT NULL,
  `district` varchar(255) DEFAULT NULL,
  `land_use` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `owner_id` varchar(255) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `register_by` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `shehia` varchar(255) DEFAULT NULL,
  `shape` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `land`
--

INSERT INTO `land` (`land_id`, `district`, `land_use`, `latitude`, `longitude`, `owner_id`, `region`, `register_date`, `register_by`, `size`, `ward`, `shehia`, `shape`) VALUES
('1', 'bhss4', 'fdkfd4', 33.4608, 8.9094, '54645646532', 'change', '2025-08-13', 'df', 'xckxc4', 'dfd4', 'fdsf', 'bfsdf');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) NOT NULL,
  `owner_type` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `zanid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`id`, `address`, `full_name`, `owner_type`, `phone`, `status`, `zanid`) VALUES
(4, 'Kijichi', 'Saidi bakari haji', 'Owner type', '+255 778 777 113', 'Inactive', '124567908'),
(5, 'chamwino', 'salim khamis issa', 'Family Ownership', '+255 778 777 113', 'Pending', '54645646532');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `email`, `full_name`, `phone`, `position`, `status`) VALUES
(10, 'hassanmustafah@gmail.com', 'hassan ally mustafah', '+255 778 777 113', 'Manager', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `created_at`, `password`, `role`, `updated_at`, `username`) VALUES
(1, '2025-08-19 06:24:42.000000', '$2a$10$misnR2hRSng51RN0QK18reGsqwsW2Hp1wI7b6qMORV6nwM0La.POm', 'Admin', '2025-08-19 06:24:42.000000', 'Admin'),
(2, '2025-08-19 07:27:12.000000', '$2a$10$26gj0pQ875IcI8WoD54TPOI/Nw7lnTJ8LxYAnJNEmSdzt8wGSBWl6', 'Staff', '2025-08-19 07:27:12.000000', 'hassanmustafah@gmail.com'),
(3, '2025-08-19 07:48:07.000000', '$2a$10$aQk4klQg64SrquPBVyKmSe.zqJXR9H/b7vhHIolccm4zHankpVIWO', 'Owner', '2025-08-19 07:48:07.000000', '124567908'),
(4, '2025-08-19 09:08:19.000000', '$2a$10$nZbedgoiGs0K9Dkxc24e.et1BHeZG93tFeflLTRNCJdxbzoNuKCJG', 'Owner', '2025-08-19 09:08:19.000000', '54645646532');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `land`
--
ALTER TABLE `land`
  ADD PRIMARY KEY (`land_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKb2muv9qvglhnwfd0669803y92` (`zanid`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKpvctx4dbua9qh4p4s3gm3scrh` (`email`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
