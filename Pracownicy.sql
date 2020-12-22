

CREATE TABLE `Pracownicy` (
  `Imie_Nazwisko` varchar(50) NOT NULL,
  `Adres` varchar(30) NOT NULL,
  `Miasto` varchar(20) NOT NULL,
  `Stanowisko` varchar(20) NOT NULL,
  `Data_rozpoczecia` date NOT NULL,
  `Telefon` int NOT NULL,
  `Pensja` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
