DROP DATABASE IF EXISTS FACTBOOK;
CREATE DATABASE FACTBOOK;
USE FACTBOOK;

CREATE TABLE `CountryMain` (
    `Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CountryCode` CHAR(2) NOT NULL,
	`CountryName` VARCHAR(50) NOT NULL, 
	`Region` VARCHAR(30) NOT NULL, 
	`Introduction` TEXT
);

	
CREATE TABLE `city` (
    `Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CountryCode` CHAR(2) NOT NULL, 
	`CityName` VARCHAR(50) NOT NULL, 
	`Population` INT,
	`Capital` BOOLEAN
);


CREATE TABLE `geography` (
    `Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CountryCode` CHAR(2) NOT NULL,
    `Lat` FLOAT( 10, 6 ) NOT NULL,
    `Lng` FLOAT( 10, 6 ) NOT NULL,
	`LandArea` INT,
    `WaterArea` INT,
    `LandBoundaries` INT,
    `Coastline` INT,
	`MeanElevation` INT,
	`LowestPointDistance` INT,
	`LowestPointName` VARCHAR(50),
	`HighestPointDistance` INT,
	`HighestPointName` VARCHAR(50),
	`IrrigatedLand` INT
);

CREATE TABLE `society` (
    `Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CountryCode` CHAR(2),
    `Population` INT,
    `Male0_14` INT,
	`Female0_14` INT,
	`Male15_24` INT,
	`Female15_24` INT,
	`Male25_54` INT,
	`Female25_54` INT,
	`Male55_64` INT,
	`Female55_64` INT,
	`Male65` INT,
	`Female65` INT,
    `YouthDependencyRatio` DECIMAL( 3, 1 ),
    `ElderlyDependencyRatio` DECIMAL( 3, 1 ),
    `PotentialSupportRatio` DECIMAL( 3, 1 ),
	`MedianAgeMale` DECIMAL( 3, 1 ),
	`MedianAgeFemale` DECIMAL( 3, 1 ),
	`PopulationGrowthRate` DECIMAL( 3, 2 ),
	`BirthRatePer1K` DECIMAL( 3, 1 ),
	`DeathRate` DECIMAL( 3, 1 ),
	`NetMigrationRate` DECIMAL( 3, 1 ),
	`UrbanPopulation` INT,
	`UrbanizationRate` DECIMAL( 3, 2 ),
	`MotherMeanAgeAtFirstBirth` DECIMAL( 3, 1 ),
	`MaternalMortalityRatePer100K` INT,
	`InfantMaleMortalityRatePer1K` DECIMAL( 3, 1 ),
	`InfantFemaleMortalityRatePer1K` DECIMAL( 3, 1 ),
	`MaleLifeExpectancy` DECIMAL( 3, 1 ),
	`FemaleLifeExpectancy` DECIMAL( 3, 1 ),
	`ChildrenBornPerWoman` DECIMAL( 3, 2 ),
	`ContraceptivePrevalencePCT` DECIMAL( 3, 1 ),
	`HealthExpenditurePCT` DECIMAL( 3, 1 ),
	`PhysiciansPer1K` DECIMAL( 3, 2 ),
	`HospitalBedPer1K` DECIMAL( 3, 2 ),
	`ImprovedUrbanDrinkingWaterPCT` DECIMAL( 4, 1 ),
	`ImprovedRuralDrinkingWaterPCT` DECIMAL( 4, 1 ),
	`ImprovedUrbanSanitationFacilityAccessPCT` DECIMAL( 3, 1 ),
	`ImprovedRuralSanitationFacilityAccessPCT` DECIMAL( 3, 1 ),
	`ImprovedTotalSanitationFacilityAccessPCT` DECIMAL( 3, 1 ),
	`HIVAIDSPrevalencePCT` DECIMAL( 3, 1 ),
	`HIVAIDSAfflicted` INT,
	`HIVAIDSDeaths` INT,
	`InfectiousDiseasesRisk` VARCHAR(15),
	`AdultObesityPCT` Decimal( 3, 1 ),
	`EducationExpenditures` DECIMAL( 3, 1 ),
	`MaleLiteracy` Decimal( 3, 1 ),
	`FemaleLiteracy` Decimal( 3, 1 ),
	`SchoolLifeExpectancy` INT,
	`Unemployment` Decimal( 3, 1 )
);