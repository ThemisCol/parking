-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-09-2022 a las 07:15:16
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ciclo3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `idDetalle` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idTransaccion` int(11) NOT NULL,
  `valorDetalle` double NOT NULL,
  `cantidadDetalle` double NOT NULL,
  `totalDetalle` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`idDetalle`, `idProducto`, `idTransaccion`, `valorDetalle`, `cantidadDetalle`, `totalDetalle`) VALUES
(1, 6, 2, 500000, 2, 1000000),
(2, 4, 2, 400000, 3, 1200000),
(3, 5, 1, 500000, 3, 1500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(45) NOT NULL,
  `valorCompra` double NOT NULL,
  `valorVenta` double NOT NULL,
  `cantidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `valorCompra`, `valorVenta`, `cantidad`) VALUES
(4, 'Computador Dell', 3500000, 4500000, 40),
(5, 'Computador Asus', 3000000, 4000000, 15),
(6, 'Computador HP', 5000000, 12500000, 2000),
(19, 'Esponja Nueva', 30000, 50000, 120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `idTransaccion` int(11) NOT NULL,
  `tipoTransaccion` varchar(45) NOT NULL,
  `fechaTransaccion` varchar(45) NOT NULL,
  `vendedor` varchar(45) NOT NULL,
  `comprador` varchar(45) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`idTransaccion`, `tipoTransaccion`, `fechaTransaccion`, `vendedor`, `comprador`, `total`) VALUES
(1, 'Crédito', '2022-09-17T10:04:03.841Z', 'Silvia Rios R', 'Daniela Nuñez', 5500000),
(2, 'Crédito', '2022-09-17T10:04:17.228Z', 'Hugo Osorio A', 'Camila Bermonth', 4500000),
(3, 'Crédito', '2022-09-05T19:15:01.490Z', 'Carlos Carreño', 'Daniela Nuñez', 4500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `idUsuario` varchar(20) NOT NULL,
  `clave` text NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `idUsuario`, `clave`, `nombre`, `tipo`, `estado`) VALUES
(1, 'cahucadi', '798693621714ad237ab699b77b01153307b4ed479993cfe196bf43af25b6f3d7971c73305e329637d660d9e15de7a095e55600d753ce3ad2e78f9eedaac7b0bb', 'Carlos Humberto', 'Guest', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `fk_detalle_transaccion` (`idTransaccion`),
  ADD KEY `fk_detalle_producto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`idTransaccion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uniqueUser` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `idTransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `fk_detalle_transaccion` FOREIGN KEY (`idTransaccion`) REFERENCES `transaccion` (`idTransaccion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

