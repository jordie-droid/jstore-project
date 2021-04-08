-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mer 26 Octobre 2016 à 07:52
-- Version du serveur: 5.5.8
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `b_geststockstandar`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_article`
--

CREATE TABLE IF NOT EXISTS `t_article` (
  `refart` varchar(5) NOT NULL,
  `design` varchar(50) DEFAULT NULL,
  `codtype` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`refart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_article`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_catcli`
--

CREATE TABLE IF NOT EXISTS `t_catcli` (
  `codcat` varchar(5) NOT NULL,
  `libcat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codcat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_catcli`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_client`
--

CREATE TABLE IF NOT EXISTS `t_client` (
  `refcli` varchar(5) NOT NULL,
  `nomscli` varchar(50) DEFAULT NULL,
  `adrcli` varchar(50) DEFAULT NULL,
  `mailcli` varchar(50) DEFAULT NULL,
  `telcli` varchar(20) DEFAULT NULL,
  `codcat` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`refcli`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_client`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_entrer`
--

CREATE TABLE IF NOT EXISTS `t_entrer` (
  `DateEntrer` date DEFAULT NULL,
  `QteEntrer` decimal(10,3) DEFAULT NULL,
  `PrixUnitaire` decimal(10,3) NOT NULL,
  `reffour` varchar(5) DEFAULT NULL,
  `refart` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_entrer`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_fourn`
--

CREATE TABLE IF NOT EXISTS `t_fourn` (
  `reffour` varchar(5) NOT NULL,
  `nomsfour` varchar(50) DEFAULT NULL,
  `adressfour` varchar(50) DEFAULT NULL,
  `mailfour` varchar(50) DEFAULT NULL,
  `telfour` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`reffour`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_fourn`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_sortie`
--

CREATE TABLE IF NOT EXISTS `t_sortie` (
  `DateSortie` date DEFAULT NULL,
  `QteSortie` decimal(10,3) DEFAULT NULL,
  `PrixUnitaire` decimal(10,3) NOT NULL,
  `Numfact` decimal(5,0) DEFAULT NULL,
  `refcli` varchar(5) DEFAULT NULL,
  `refart` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_sortie`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_stock`
--

CREATE TABLE IF NOT EXISTS `t_stock` (
  `numstock` bigint(10) NOT NULL,
  `refart` varchar(5) NOT NULL,
  `qtstock` decimal(10,3) NOT NULL,
  `pustock` decimal(10,3) NOT NULL,
  `DateStock` date NOT NULL,
  PRIMARY KEY (`numstock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_stock`
--


-- --------------------------------------------------------

--
-- Structure de la table `t_typart`
--

CREATE TABLE IF NOT EXISTS `t_typart` (
  `codtype` varchar(5) NOT NULL,
  `libtype` varchar(50) DEFAULT NULL,
  `caract1` varchar(50) DEFAULT NULL,
  `caract2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `t_typart`
--

