-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2023 a las 16:22:50
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `provemax`
--
CREATE DATABASE IF NOT EXISTS `provemax` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `provemax`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idProveedor` int(30) NOT NULL,
  `fecha` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `idProveedor`, `fecha`, `estado`) VALUES
(1, 1, '2023-11-04', 1),
(2, 7, '2023-11-04', 0),
(3, 3, '2023-11-04', 1),
(14, 1, '2023-11-04', 1),
(15, 3, '2023-11-05', 1),
(16, 10, '2023-11-05', 0),
(17, 6, '2023-11-05', 1),
(18, 3, '2023-11-13', 1),
(19, 2, '2023-11-14', 1),
(20, 9, '2023-11-13', 0),
(21, 4, '2023-11-01', 0),
(22, 2, '2023-11-15', 1),
(23, 9, '2023-11-15', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

CREATE TABLE `detallecompra` (
  `idDetalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioCosto` double NOT NULL,
  `idCompra` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`idDetalle`, `cantidad`, `precioCosto`, `idCompra`, `idProducto`) VALUES
(1, 3, 250000, 2, 5),
(6, 1, 300000, 2, 2),
(7, 2, 300000, 3, 4),
(17, 1, 300000, 20, 11),
(18, 2, 5000000, 19, 4),
(19, 3, 200000000, 17, 6),
(20, 3, 4000000, 1, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int(11) NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcion`, `precioActual`, `stock`, `stockMinimo`, `estado`) VALUES
(1, 'Televisor Sony ', 'Ultra HD 50 pulgadas ', 280000, 18, 3, 1),
(2, 'televisor Sony', '32LDC', 210000, 14, 3, 1),
(3, 'lavarropas Whirpool', '5kg', 230000, 25, 3, 1),
(4, 'plancha Philips', 'seco', 60000, 7, 0, 1),
(5, 'ventilador de techo', 'philips, 5 velocid.', 10000, 6, 0, 1),
(6, 'Aire Acondicionado', 'Split BGH', 200000, 2, 0, 1),
(7, ' Play Station Sony ', ' 5ta generacion ', 700000, 10, 3, 1),
(11, 'cocina Florencia', 'autolimpiante , 6 hornallas , reloj', 200000, 13, 2, 1),
(12, 'caloventor Liliana', '3000 w , portatil, varios colores,', 12000, 30, 1, 1),
(13, 'heladera Gafa', '230 lts, varios colores, sistema de enfriamiento de agua en puerta', 400000, 40, 2, 1),
(14, 'batidora', 'liliana 300 wts', 80000, 23, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `cuit` float NOT NULL,
  `razonSocial` varchar(70) NOT NULL,
  `domicilio` varchar(70) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `cuit`, `razonSocial`, `domicilio`, `telefono`, `estado`) VALUES
(1, 9234, 'Megatone 1', 'La Rioja', '27878211', 1),
(2, 9845680, 'Constru Shop', 'centenario 789', '2665980', 1),
(3, 98456700, 'Reigth', 'Rivadavia 555', '266498456', 1),
(4, 546678, 'Ribeiro', 'Paseo del Padre 22', '266489234', 1),
(5, 90463800, 'Libert', 'San Martin 345', '266464930', 0),
(6, 120946, 'Garbarino', 'Ayacucho 980', '2664453678', 1),
(7, 98456, 'Naldo', 'Rivadavia 800 ', '266548943', 0),
(9, 89656, 'Niki-Niki', 'San Martin 400 ', '266448900', 1),
(10, 823678, 'Get-Shop', 'San Martin 1500 ', '266465478', 1),
(11, 238745000, ' Shop Shop', 'Riobamba 456', '26654789', 0),
(19, 876455, 'Cetrogar', 'chacabuco 78', '266578345', 1),
(21, 784567, 'easy', 'chacabuco 34', '26647893', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `proveedor` (`idProveedor`);

--
-- Indices de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `compra` (`idCompra`),
  ADD KEY `producto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`),
  ADD UNIQUE KEY `cuit` (`cuit`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
