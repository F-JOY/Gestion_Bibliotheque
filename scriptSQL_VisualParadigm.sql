-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 15 Avril 2023 à 06:14
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `uno_bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE IF NOT EXISTS `emprunt` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Date_emprunt` date DEFAULT NULL,
  `Prolongation` bit(1) NOT NULL,
  `Date_ristitution` date DEFAULT NULL,
  `LecteurID` int(10) NOT NULL,
  `OuvrageID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKEmprunt683818` (`OuvrageID`),
  KEY `FKEmprunt860752` (`LecteurID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `filière`
--

CREATE TABLE IF NOT EXISTS `filière` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom_filiere` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom_filiere` (`Nom_filiere`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `filière`
--

INSERT INTO `filière` (`ID`, `Nom_filiere`) VALUES
(1, 'Arts'),
(2, 'Biologie'),
(3, 'Chimie'),
(4, 'Commerce et gestion'),
(5, 'Communication'),
(6, 'Droit'),
(7, 'Éducation'),
(8, 'Génie'),
(9, 'Informatique'),
(10, 'Langues et littératures'),
(11, 'Mathématiques'),
(12, 'Médecine'),
(16, 'phisique'),
(13, 'Sciences économiques'),
(14, 'Sciences politiques'),
(15, 'Sociologie');

-- --------------------------------------------------------

--
-- Structure de la table `lecteur`
--

CREATE TABLE IF NOT EXISTS `lecteur` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom_lecteur` varchar(255) DEFAULT NULL,
  `Prenom_lecteur` varchar(255) DEFAULT NULL,
  `Adresse` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Num_tel` int(10) NOT NULL,
  `Date_naiss` date DEFAULT NULL,
  `paiement` tinyint(1) NOT NULL,
  `Discriminator` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `ouvrage`
--

CREATE TABLE IF NOT EXISTS `ouvrage` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) NOT NULL,
  `specialitéID` int(10) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Auteur` varchar(255) NOT NULL,
  `Maison_edition` int(10) DEFAULT NULL,
  `Date_edition` date DEFAULT NULL,
  `Prix` float NOT NULL,
  `Nb_exemplaire` int(10) NOT NULL,
  `Discription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `appartenir` (`specialitéID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `penalisation`
--

CREATE TABLE IF NOT EXISTS `penalisation` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `SanctionID` int(10) NOT NULL,
  `LecteurID` int(10) NOT NULL,
  `Date_debut` date DEFAULT NULL,
  `Date_fin` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `apartenir` (`SanctionID`),
  KEY `pénaliser` (`LecteurID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `restitution`
--

CREATE TABLE IF NOT EXISTS `restitution` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `EmpruntID` int(10) NOT NULL,
  `Date_restitution` date DEFAULT NULL,
  `Retard` bit(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKrestitutio523900` (`EmpruntID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sanction`
--

CREATE TABLE IF NOT EXISTS `sanction` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Durée_retard` varchar(255) DEFAULT NULL,
  `Durée_sanction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `specialité`
--

CREATE TABLE IF NOT EXISTS `specialité` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FilièreID` int(10) NOT NULL,
  `Nom_specialité` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKspecialité614933` (`FilièreID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=152 ;

--
-- Contenu de la table `specialité`
--

INSERT INTO `specialité` (`ID`, `FilièreID`, `Nom_specialité`) VALUES
(1, 1, 'Design graphique'),
(2, 1, 'Peinture'),
(3, 1, 'Sculpture'),
(4, 1, 'Photographie'),
(5, 1, 'Cinéma'),
(6, 1, 'Arts visuels'),
(7, 1, 'Arts numériques'),
(8, 1, 'Théâtre'),
(9, 1, 'Danse'),
(10, 1, 'Musique'),
(11, 1, 'Art-thérapie'),
(12, 1, 'Conservation et restauration d''œuvres d''art'),
(13, 1, 'Arts du spectacle'),
(14, 2, 'Génétique'),
(15, 2, 'Biologie moléculaire'),
(16, 2, 'Écologie'),
(17, 2, 'Zoologie'),
(18, 2, 'Botanique'),
(19, 2, 'Microbiologie'),
(20, 2, 'Biochimie'),
(21, 2, 'Biotechnologie'),
(22, 2, 'Sciences de la santé'),
(23, 2, 'Bioinformatique'),
(24, 3, 'Chimie organique'),
(25, 3, 'Chimie inorganique'),
(26, 3, 'Chimie analytique'),
(27, 3, 'Chimie physique'),
(28, 3, 'Chimie des polymères'),
(29, 3, 'Chimie environnementale'),
(30, 3, 'Chimie pharmaceutique'),
(31, 3, 'Chimie alimentaire'),
(32, 4, 'Marketing'),
(33, 4, 'Finance'),
(34, 4, 'Ressources humaines'),
(35, 4, 'Comptabilité'),
(36, 4, 'Management'),
(37, 4, 'Entrepreneuriat'),
(38, 4, 'Analyse de données'),
(39, 4, 'Gestion de projets'),
(40, 4, 'Logistique'),
(41, 5, 'Relations publiques'),
(42, 5, 'Journalisme'),
(43, 5, 'Médias sociaux'),
(44, 5, 'Publicité'),
(45, 5, 'Communication visuelle'),
(46, 5, 'Communication organisationnelle'),
(47, 5, 'Communication interculturelle'),
(48, 5, 'Communication politique'),
(49, 6, 'Droit civil'),
(50, 6, 'Droit pénal'),
(51, 6, 'Droit du travail'),
(52, 6, 'Droit international'),
(53, 6, 'Droit des affaires'),
(54, 6, 'Droit de la propriété intellectuelle'),
(55, 6, 'Droit fiscal'),
(56, 6, 'Droit de l''environnement'),
(57, 7, 'Éducation de la petite enfance'),
(58, 7, 'Éducation primaire'),
(59, 7, 'Éducation secondaire'),
(60, 7, 'Éducation physique'),
(61, 7, 'Éducation à distance'),
(62, 7, 'Didactique'),
(63, 7, 'Psychologie de l''éducation'),
(64, 8, 'Génie civil'),
(65, 8, 'Génie mécanique'),
(66, 8, 'Génie électrique'),
(67, 8, 'Génie industriel'),
(68, 8, 'Génie chimique'),
(69, 8, 'Génie informatique'),
(70, 8, 'Génie aérospatial'),
(71, 8, 'Génie biomédical'),
(72, 8, 'Génie des matériaux'),
(73, 8, 'Génie minier'),
(74, 8, 'Génie environnemental'),
(75, 8, 'Génie géologique'),
(76, 9, 'Développement web'),
(77, 9, 'Développement mobile'),
(78, 9, 'Intelligence artificielle'),
(79, 9, 'Sécurité informatique'),
(80, 9, 'Base de données'),
(81, 9, 'Réseaux informatiques'),
(82, 9, 'Analyse de données'),
(83, 9, 'Informatique décisionnelle'),
(84, 9, 'Ingénierie logicielle'),
(85, 9, 'Informatique embarquée'),
(86, 10, 'Anglais'),
(87, 10, 'Français'),
(88, 10, 'Espagnol'),
(89, 10, 'Allemand'),
(90, 10, 'Italien'),
(91, 10, 'Portugais'),
(92, 10, 'Arabe'),
(93, 10, 'Chinois'),
(94, 10, 'Japonais'),
(95, 10, 'Langues autochtones'),
(96, 10, 'Traduction'),
(97, 10, 'Interprétation'),
(98, 11, 'Algèbre'),
(99, 11, 'Analyse mathématique'),
(100, 11, 'Statistiques'),
(101, 11, 'Probabilités'),
(102, 11, 'Géométrie'),
(103, 11, 'Mathématiques appliquées'),
(104, 11, 'Mathématiques financières'),
(105, 11, 'Théorie des nombres'),
(106, 11, 'Cryptographie'),
(107, 12, 'Médecine générale'),
(108, 12, 'Chirurgie'),
(109, 12, 'Gynécologie-obstétrique'),
(110, 12, 'Pédiatrie'),
(111, 12, 'Psychiatrie'),
(112, 12, 'Médecine d''urgence'),
(113, 12, 'Radiologie'),
(114, 12, 'Anesthésiologie'),
(115, 12, 'Ophtalmologie'),
(116, 12, 'Dermatologie'),
(117, 12, 'Médecine légale'),
(118, 12, 'Médecine du sport'),
(119, 13, 'Économie politique'),
(120, 13, 'Économie de la santé'),
(121, 13, 'Économie du développement'),
(122, 13, 'Économie industrielle'),
(123, 13, 'Économétrie'),
(126, 13, 'Gestion'),
(127, 14, 'Relations internationales'),
(128, 14, 'Politiques publiques'),
(129, 14, 'Science politique comparée'),
(130, 14, 'Théorie politique'),
(131, 14, 'Droit international'),
(132, 14, 'Études de sécurité'),
(133, 14, 'Études stratégiques'),
(134, 15, 'Anthropologie'),
(135, 15, 'Sociologie'),
(136, 15, 'Science de la communication'),
(137, 15, 'Travail social'),
(138, 15, 'Géographie'),
(139, 15, 'Archéologie'),
(140, 15, 'Histoire'),
(141, 15, 'Psychologie'),
(142, 16, 'Physique nucléaire'),
(143, 16, 'Physique atomique et moléculaire'),
(144, 16, 'Physique de la matière condensée'),
(145, 16, 'Physique théorique'),
(146, 16, 'Physique mathématique'),
(147, 16, 'Astrophysique'),
(148, 16, 'Physique des particules'),
(149, 16, 'Optique'),
(150, 16, 'Physique médicale'),
(151, 16, 'Acoustique');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom_utilisateur` varchar(255) NOT NULL,
  `Mot_de_pass` varchar(255) NOT NULL,
  `Nom_biblio` varchar(255) DEFAULT NULL,
  `Prénom_biblio` varchar(255) DEFAULT NULL,
  `Adresse_biblio` varchar(255) DEFAULT NULL,
  `Email_biblio` varchar(255) DEFAULT NULL,
  `Num_tel_biblio` int(10) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Nom_utilisateur` (`Nom_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Nom_utilisateur`, `Mot_de_pass`, `Nom_biblio`, `Prénom_biblio`, `Adresse_biblio`, `Email_biblio`, `Num_tel_biblio`, `Discriminator`) VALUES
(1, 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, 'gerant'),
(2, 'biblio1', '1234', 'Berkati', NULL, NULL, NULL, NULL, 'biblio');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `FKEmprunt683818` FOREIGN KEY (`OuvrageID`) REFERENCES `ouvrage` (`ID`),
  ADD CONSTRAINT `FKEmprunt860752` FOREIGN KEY (`LecteurID`) REFERENCES `lecteur` (`ID`);

--
-- Contraintes pour la table `ouvrage`
--
ALTER TABLE `ouvrage`
  ADD CONSTRAINT `appartenir` FOREIGN KEY (`specialitéID`) REFERENCES `specialité` (`ID`);

--
-- Contraintes pour la table `penalisation`
--
ALTER TABLE `penalisation`
  ADD CONSTRAINT `apartenir` FOREIGN KEY (`SanctionID`) REFERENCES `sanction` (`ID`),
  ADD CONSTRAINT `pénaliser` FOREIGN KEY (`LecteurID`) REFERENCES `lecteur` (`ID`);

--
-- Contraintes pour la table `restitution`
--
ALTER TABLE `restitution`
  ADD CONSTRAINT `FKrestitutio523900` FOREIGN KEY (`EmpruntID`) REFERENCES `emprunt` (`ID`);

--
-- Contraintes pour la table `specialité`
--
ALTER TABLE `specialité`
  ADD CONSTRAINT `FKspecialité614933` FOREIGN KEY (`FilièreID`) REFERENCES `filière` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
