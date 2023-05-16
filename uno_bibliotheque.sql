-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 16 mai 2023 à 22:23
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `uno_bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `ID` int(10) NOT NULL,
  `Date_emprunt` date DEFAULT NULL,
  `Prolongation` bit(1) NOT NULL,
  `Date_ristitution` date DEFAULT NULL,
  `LecteurID` int(10) NOT NULL,
  `OuvrageID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `ID` int(10) NOT NULL,
  `Nom_filiere` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`ID`, `Nom_filiere`) VALUES
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

CREATE TABLE `lecteur` (
  `ID` int(10) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `Prenom_lecteur` varchar(255) NOT NULL,
  `Adresse` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Num_tel` int(10) DEFAULT NULL,
  `Date_naiss` date NOT NULL,
  `Discriminator` varchar(255) DEFAULT NULL,
  `type` enum('etudiant interne','etudiant externe','enseignant') NOT NULL,
  `paiement` enum('vrai','faux') NOT NULL DEFAULT 'faux',
  `dateA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lecteur`
--

INSERT INTO `lecteur` (`ID`, `nom`, `Prenom_lecteur`, `Adresse`, `Email`, `Num_tel`, `Date_naiss`, `Discriminator`, `type`, `paiement`, `dateA`) VALUES
(23, 'asx', 'asx', 'asx', 'asx', 1213, '2023-04-06', NULL, 'enseignant', 'faux', NULL),
(33, 'dsa', 'das', 'fds', 'billal@gmail.com', 43, '2023-03-27', NULL, 'enseignant', 'faux', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ouvrage`
--

CREATE TABLE `ouvrage` (
  `ID` int(10) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `specialiteID` int(10) DEFAULT NULL,
  `Titre` varchar(255) NOT NULL,
  `Auteur` varchar(255) NOT NULL,
  `Maison_edition` varchar(100) DEFAULT NULL,
  `Date_edition` year(4) DEFAULT NULL,
  `Prix` float NOT NULL,
  `Nb_exemplaire` int(10) NOT NULL,
  `Discription` varchar(255) DEFAULT NULL,
  `idSpecialite` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ouvrage`
--

INSERT INTO `ouvrage` (`ID`, `isbn`, `specialiteID`, `Titre`, `Auteur`, `Maison_edition`, `Date_edition`, `Prix`, `Nb_exemplaire`, `Discription`, `idSpecialite`) VALUES
(1, 'sdfsdf', 13, 'dsfsdf', 'sdfsdfsd', 'sdfdsf', 2023, 3, 3, 'sdfsdfsd', 0),
(2, '125sdf5sdfsdfsd', 9, 'chess', 'ghilas', 'olibris', 2022, 2000, 10, 'aersdfsdfsd', 0),
(4, '125sdf5sdfsdfsddfsf', 13, 'chess', 'ghilas', 'olibris', 2022, 2000, 10, 'aersdfsdfsd', 0),
(6, '125sdf5sdfsdfsddfsfsdf', 1, 'chess', 'ghilas', 'olibris', 2022, 2000, 10, 'aersdfsdfsd', 0),
(8, 'aaaaaaaaaaaaaaaaaaaaa', 9, 'chess', 'ghilas', 'olibris', 2022, 2000, 10, 'aersdfsdfsd', 0),
(9, 'bbbbbbbbbb', 13, 'aaaaaaaaaaaa', 'aaaaaaaaaaa', 'aaaaaaaaaaaa', 2002, 6000, 50, 'sdfsfs', 126),
(10, 'addddddddddddd', 16, 'ddddddddd', 'ddddddddddd', 'ddddddddddd', 1999, 2550, 30, 'sdfsdfsdf', 149),
(11, 'azeraz', NULL, 'azreaz', 'azereaz', 'azeraz', 1966, 2455, 20, 'dfgsg', 0),
(12, 'sdfdsd', NULL, 'sdfsdf', 'sdfsdf', 'sdfsdf', 1999, 8999, 89, 'sdfsdf', 0),
(13, 'dfssd', 1, 'dfssdf', 'sdfsd', 'dsfsf', 2000, 4545, 45445, 'sdfsdf', 0),
(14, 'azeraze', 1, 'azerazer', 'azerazer', 'fsdfsdf', 2020, 1234, 12, 'sdfsd', 0),
(16, 'informatique', 1, 'sdfsdf', 'sdfsdf', 'dsfsdf', 2002, 1254, 50, 'sdfsdf', 0),
(17, 'info', 1, 'sdfsdf', 'sdfsd', 'sdfsdf', 2022, 2045, 45, 'ssdf', 0),
(18, 'azer', 1, 'azre', 'azer', 'sdfq', 2013, 1234, 12, 'azre', 0),
(19, 'sdfsd', 1, 'sdfsdf', 'dsfsdf', 'sdfsd', 2022, 54, 12, 'sdfsddsf', 0),
(20, 'aaaaaddddddddd', 7, 'aaaaaaaadddddddd', 'aaaaaaddddddd', 'aaaaaadddddd', 2021, 3000, 50, 'aaaaaaadddddd', 61),
(22, 'sdfsdfdffff', 13, 'sdfsdf', 'sdfsdf', 'sdfsdf', 2023, 12212, 12, 'sdfsf', 120);

-- --------------------------------------------------------

--
-- Structure de la table `penalisation`
--

CREATE TABLE `penalisation` (
  `ID` int(10) NOT NULL,
  `SanctionID` int(10) NOT NULL,
  `LecteurID` int(10) NOT NULL,
  `Date_debut` date DEFAULT NULL,
  `Date_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `restitution`
--

CREATE TABLE `restitution` (
  `ID` int(10) NOT NULL,
  `EmpruntID` int(10) NOT NULL,
  `Date_restitution` date DEFAULT NULL,
  `Retard` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sanction`
--

CREATE TABLE `sanction` (
  `ID` int(10) NOT NULL,
  `Durée_retard` int(255) DEFAULT NULL,
  `Durée_sanction` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sanction`
--

INSERT INTO `sanction` (`ID`, `Durée_retard`, `Durée_sanction`) VALUES
(18, 1, 1),
(19, 2, 1),
(20, 21, 1),
(21, 90, 1),
(22, 3, 7),
(23, 3, 30),
(24, 3, 60),
(25, 30, 14),
(26, 5, 14);

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE `specialite` (
  `ID` int(10) NOT NULL,
  `FiliereID` int(10) NOT NULL,
  `Nom_specialite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `specialite`
--

INSERT INTO `specialite` (`ID`, `FiliereID`, `Nom_specialite`) VALUES
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
(12, 1, 'Conservation et restauration d\'œuvres d\'art'),
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
(56, 6, 'Droit de l\'environnement'),
(57, 7, 'Éducation de la petite enfance'),
(58, 7, 'Éducation primaire'),
(59, 7, 'Éducation secondaire'),
(60, 7, 'Éducation physique'),
(61, 7, 'Éducation à distance'),
(62, 7, 'Didactique'),
(63, 7, 'Psychologie de l\'éducation'),
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
(112, 12, 'Médecine d\'urgence'),
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

CREATE TABLE `utilisateur` (
  `ID` int(10) NOT NULL,
  `Nom_utilisateur` varchar(255) NOT NULL,
  `Mot_de_pass` varchar(255) NOT NULL,
  `Nom_biblio` varchar(255) DEFAULT NULL,
  `Prénom_biblio` varchar(255) DEFAULT NULL,
  `Adresse_biblio` varchar(255) DEFAULT NULL,
  `Email_biblio` varchar(255) DEFAULT NULL,
  `Num_tel_biblio` int(10) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Nom_utilisateur`, `Mot_de_pass`, `Nom_biblio`, `Prénom_biblio`, `Adresse_biblio`, `Email_biblio`, `Num_tel_biblio`, `Discriminator`) VALUES
(1, 'admin', 'admin', 'a', 'a', 'a', 'a', 558955552, 'gérant'),
(2, 'biblio1', '1234', 'Berkati', NULL, NULL, NULL, NULL, 'biblio'),
(3, 'ghilas', 'b', 'sdfsd', 'sdfsdf', 'sdfsdf', 'sdfsf', 56456, 'biblio'),
(4, 'sdfsdf', 'ab', 'sdfsd', 'sdfds', 'dsfsf', 'dsfdsf', 558695847, 'biblio'),
(5, 'abc', 'ab', 'gh', 'az', 'sdfsdf', 'sdfsd@gmail.com', 555898457, 'biblio'),
(6, 'ab', 'ab', 'aer', 'azer', 'aerzear', 'sdfsdf', 55589865, 'biblio'),
(9, 'azertyuiop', '123456789', 'ghilas', 'benyahia', 'sdfsdf', 'ghila.ben@gh.com', 55598658, 'biblio'),
(13, 'aqw', 'aqw', 'nnnnnnn', 'nnnnn', 'sdfsdf', 'sdfsd@gaimk.com', 555, 'biblio');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKEmprunt683818` (`OuvrageID`),
  ADD KEY `FKEmprunt860752` (`LecteurID`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Nom_filiere` (`Nom_filiere`);

--
-- Index pour la table `lecteur`
--
ALTER TABLE `lecteur`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `ouvrage`
--
ALTER TABLE `ouvrage`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `appartenir` (`specialiteID`);

--
-- Index pour la table `penalisation`
--
ALTER TABLE `penalisation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `apartenir` (`SanctionID`),
  ADD KEY `pénaliser` (`LecteurID`);

--
-- Index pour la table `restitution`
--
ALTER TABLE `restitution`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKrestitutio523900` (`EmpruntID`);

--
-- Index pour la table `sanction`
--
ALTER TABLE `sanction`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKspecialité614933` (`FiliereID`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Nom_utilisateur` (`Nom_utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `lecteur`
--
ALTER TABLE `lecteur`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `ouvrage`
--
ALTER TABLE `ouvrage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `penalisation`
--
ALTER TABLE `penalisation`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `restitution`
--
ALTER TABLE `restitution`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sanction`
--
ALTER TABLE `sanction`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
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
  ADD CONSTRAINT `appartenir` FOREIGN KEY (`specialiteID`) REFERENCES `specialite` (`ID`);

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
-- Contraintes pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD CONSTRAINT `FKspecialité614933` FOREIGN KEY (`FiliereID`) REFERENCES `filiere` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
