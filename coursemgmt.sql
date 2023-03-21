-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2022 at 02:15 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursemgmt`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `sec_q` varchar(25) NOT NULL,
  `sec_a` varchar(25) NOT NULL,
  `acc_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`username`, `name`, `password`, `sec_q`, `sec_a`, `acc_type`) VALUES
('suyogyag', 'Suyogya Gautam', '12345', 'Your NickName?', 'suku', 'Admin'),
('student', 'student', 'student', 'Your NickName?', 'student', 'Student'),
('gaurav', 'Gaurav Thapaliya', '123', 'Your NickName?', 'gau', 'Student'),
('inst', 'inst', 'inst', 'Your NickName?', 'inst', 'Instructor'),
('admin', 'admin', 'admin', 'Your NickName?', 'admin', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `bibm`
--

CREATE TABLE `bibm` (
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(25) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `21st Century Management` int(100) DEFAULT NULL,
  `Preparing Success at University` int(100) DEFAULT NULL,
  `Principles of Business` int(100) DEFAULT NULL,
  `Project Based Learning` int(100) DEFAULT NULL,
  `Responsible Business` int(100) DEFAULT NULL,
  `Sustainable Business` int(100) DEFAULT NULL,
  `Innovative Business` int(100) DEFAULT NULL,
  `Digital Business` int(100) DEFAULT NULL,
  `Contemporary Issues in International Business` int(100) DEFAULT NULL,
  `International HR Professional` int(100) DEFAULT NULL,
  `Operation and Project Planning` int(100) DEFAULT NULL,
  `Managing Finance and Accounts` int(100) DEFAULT NULL,
  `Strategic Business` int(100) DEFAULT NULL,
  `Global Context for Multinational Enterprises` int(100) DEFAULT NULL,
  `Professional Project` int(100) DEFAULT NULL,
  `Marketing Consultant` int(100) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibm`
--

INSERT INTO `bibm` (`student_id`, `student_name`, `level`, `21st Century Management`, `Preparing Success at University`, `Principles of Business`, `Project Based Learning`, `Responsible Business`, `Sustainable Business`, `Innovative Business`, `Digital Business`, `Contemporary Issues in International Business`, `International HR Professional`, `Operation and Project Planning`, `Managing Finance and Accounts`, `Strategic Business`, `Global Context for Multinational Enterprises`, `Professional Project`, `Marketing Consultant`, `status`) VALUES
(7352, 'Kabi Gurung', 6, 70, 70, 70, 70, 70, 70, 40, 50, 60, 70, 80, 90, NULL, NULL, NULL, NULL, 'Pass'),
(170, 'Ram Parshad', 4, 30, 20, 10, 15, 19, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Fail');

-- --------------------------------------------------------

--
-- Table structure for table `bscit`
--

CREATE TABLE `bscit` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(25) NOT NULL,
  `level` varchar(10) DEFAULT NULL,
  `Introductory Programming` int(100) DEFAULT NULL,
  `Academic Skills` int(100) DEFAULT NULL,
  `Fundamentals of Computing` int(100) DEFAULT NULL,
  `Embedded Systems Programming` int(100) DEFAULT NULL,
  `Internet Software` int(100) DEFAULT NULL,
  `Computational Mathematics` int(100) DEFAULT NULL,
  `Concepts and Technologies of AI` int(100) DEFAULT NULL,
  `Object-Oriented Design and Programming` int(100) DEFAULT NULL,
  `Numerical Methods and Concurrency` int(100) DEFAULT NULL,
  `Distributed and Cloud System Programming` int(100) DEFAULT NULL,
  `Collaborative Development` int(100) DEFAULT NULL,
  `Human Computer Interaction` int(100) DEFAULT NULL,
  `Complex System` int(100) DEFAULT NULL,
  `High Performance Computing` int(100) DEFAULT NULL,
  `Project and Professionalism` int(100) DEFAULT NULL,
  `Artificial Intelligence and Machine Learning` int(100) DEFAULT NULL,
  `Big Data` int(100) DEFAULT NULL,
  `Optional Subject` int(100) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bscit`
--

INSERT INTO `bscit` (`student_id`, `student_name`, `level`, `Introductory Programming`, `Academic Skills`, `Fundamentals of Computing`, `Embedded Systems Programming`, `Internet Software`, `Computational Mathematics`, `Concepts and Technologies of AI`, `Object-Oriented Design and Programming`, `Numerical Methods and Concurrency`, `Distributed and Cloud System Programming`, `Collaborative Development`, `Human Computer Interaction`, `Complex System`, `High Performance Computing`, `Project and Professionalism`, `Artificial Intelligence and Machine Learning`, `Big Data`, `Optional Subject`, `status`) VALUES
(7276, 'Gaurav Thapaliya', '4', 80, 80, 80, 80, 80, 80, 60, 40, 50, 70, 80, 90, 80, 80, 80, 80, 80, 80, 'Pass'),
(7754, 'Raymon', '4', 90, 90, 90, 90, 90, 90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''),
(8211, 'Ram Krisha', '5', 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, NULL, 10, NULL, NULL, NULL, NULL, NULL, 'Fail'),
(3106, 'Ashim Baral', '4', 40, 40, 40, 40, 40, 40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Pass'),
(6888, 'Pratik Thapa', '4', 80, 80, 80, 40, 50, 60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Pass');

-- --------------------------------------------------------

--
-- Table structure for table `coursedb`
--

CREATE TABLE `coursedb` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(25) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coursedb`
--

INSERT INTO `coursedb` (`course_id`, `course_name`, `status`) VALUES
(101, 'BscIT', 'Active'),
(954, 'BIBM', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `instructor_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `faculty` varchar(25) NOT NULL,
  `semester` varchar(25) NOT NULL,
  `module` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`instructor_id`, `name`, `faculty`, `semester`, `module`) VALUES
(363, 'Ashish Acharya', 'BscIT', '3rd', 'Numerical Method'),
(1268, 'Biraj Dulal', 'BscIT', '3rd', 'AI'),
(2629, 'Saurav Gautam', 'BscIT', '1st', 'Introductory Programming'),
(4561, 'Bishal Khadka', 'BscIT', '3rd', 'Object Oriented'),
(7596, 'Deepson Shrestha', 'BscIT', '3rd', 'Object Oriented'),
(9735, 'Subash Bista', 'BscIT', '1st', 'Fundamentals');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `course` varchar(25) NOT NULL,
  `level` varchar(11) NOT NULL,
  `semester` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `course`, `level`, `semester`) VALUES
(170, 'Ram Parshad', 'BIBM', '3', 'First'),
(3106, 'Ashim Baral', 'BscIT', '4', 'First'),
(6888, 'Pratik Thapa', 'BscIT', '4', 'First'),
(7276, 'Gaurav Thapaliya', 'BscIT', '4', 'First'),
(7352, 'Kabi Gurung', 'BIBM', '3', 'First'),
(7754, 'Raymon', 'BscIT', '4', 'First'),
(8211, 'Ram Krisha', 'BscIT', '4', 'Third');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`instructor_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `instructor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9736;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8212;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
