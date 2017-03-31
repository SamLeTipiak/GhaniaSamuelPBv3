-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 31 Mars 2017 à 16:58
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ghaniasampbv3`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `DTYPE` varchar(31) NOT NULL,
  `idAccount` bigint(20) NOT NULL,
  `accountRate` double NOT NULL,
  `accountType` int(11) DEFAULT NULL,
  `openDate` varchar(255) DEFAULT NULL,
  `sold` double NOT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `account`
--

INSERT INTO `account` (`DTYPE`, `idAccount`, `accountRate`, `accountType`, `openDate`, `sold`, `client_id`) VALUES
('CurrentAccount', 1, 0, NULL, 'lundi', 4648644.5464, NULL),
('SavingAccount', 2, 0.029999999329447746, NULL, '46465', 35.4, NULL),
('CurrentAccount', 3, 0, NULL, 'mardi dernier', 644.5464, NULL),
('SavingAccount', 4, 0.029999999329447746, NULL, '15/9/45', -58.4, NULL),
('CurrentAccount', 5, 0, NULL, 'jeudi dernier', 644.5464, NULL),
('SavingAccount', 6, 0.029999999329447746, NULL, '1/11/85', -58.4, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `actor`
--

CREATE TABLE `actor` (
  `id` bigint(20) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `idAgence` bigint(20) NOT NULL,
  `lastName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `actor`
--

INSERT INTO `actor` (`id`, `firstName`, `idAgence`, `lastName`) VALUES
(1, 'pierre', 1, 'curie'),
(2, 'Image', 1, 'Emile'),
(3, 'Jacques', 1, 'Jean');

-- --------------------------------------------------------

--
-- Structure de la table `adviser`
--

CREATE TABLE `adviser` (
  `id` bigint(20) NOT NULL,
  `agence_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `idAgence` bigint(20) NOT NULL,
  `creationDate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `phoneNumer` varchar(255) DEFAULT NULL,
  `zipCode` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  `adviser_id` bigint(20) DEFAULT NULL,
  `agence_id` bigint(20) DEFAULT NULL,
  `currentAccount_idAccount` bigint(20) DEFAULT NULL,
  `savingAccount_idAccount` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`address`, `city`, `phoneNumer`, `zipCode`, `id`, `adviser_id`, `agence_id`, `currentAccount_idAccount`, `savingAccount_idAccount`) VALUES
('45 rue belle', 'paris', '124578996', 75645, 1, NULL, NULL, 1, 2),
('45 rue de lumière', 'Orléans', '145578996', 4645, 2, NULL, NULL, 3, 4),
('45 rue de la musique', 'Lyon', '085578996', 69645, 3, NULL, NULL, 5, 6);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequences`
--

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`) VALUES
('Actor', 1),
('Account', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`idAccount`),
  ADD KEY `FK_6o6pwq91ma079l21lw4xpmmld` (`client_id`);

--
-- Index pour la table `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `adviser`
--
ALTER TABLE `adviser`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_r3yybt17dhl44ckgd6tatncp1` (`agence_id`);

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`idAgence`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_o5hto3e936lpno327vo02u9xb` (`adviser_id`),
  ADD KEY `FK_64cps4tcrrjmnqj4vfq7f475l` (`agence_id`),
  ADD KEY `FK_7aedvtd64lyvrgjxxo4w8eluf` (`currentAccount_idAccount`),
  ADD KEY `FK_n0y7ydw2ceh1wjh1dxj4iq8a9` (`savingAccount_idAccount`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `idAgence` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK_6o6pwq91ma079l21lw4xpmmld` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `adviser`
--
ALTER TABLE `adviser`
  ADD CONSTRAINT `FK_k43nfruswi0j2auy31hp9col5` FOREIGN KEY (`id`) REFERENCES `actor` (`id`),
  ADD CONSTRAINT `FK_r3yybt17dhl44ckgd6tatncp1` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`idAgence`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_64cps4tcrrjmnqj4vfq7f475l` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`idAgence`),
  ADD CONSTRAINT `FK_7aedvtd64lyvrgjxxo4w8eluf` FOREIGN KEY (`currentAccount_idAccount`) REFERENCES `account` (`idAccount`),
  ADD CONSTRAINT `FK_n0y7ydw2ceh1wjh1dxj4iq8a9` FOREIGN KEY (`savingAccount_idAccount`) REFERENCES `account` (`idAccount`),
  ADD CONSTRAINT `FK_o5hto3e936lpno327vo02u9xb` FOREIGN KEY (`adviser_id`) REFERENCES `adviser` (`id`),
  ADD CONSTRAINT `FK_ry5y27p5iwfa43hripgl2n1y6` FOREIGN KEY (`id`) REFERENCES `actor` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
