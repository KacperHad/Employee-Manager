<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dodaj Pracownika</title>
    <link rel="stylesheet" type="text/css" href="kolorki.css" />
    <nav>
        <ul>
            <li><a href="index.php">Lista pracownikow</a></li>
            <li><a href="Usun.php">Usun pracownika</a></li>
            <li><a href="wyszukaj.php">Wyszukaj pracownika</a></li>
        </ul>
    </nav>
</head>

<body>
    <div class="formaa">
        <form method="POST">
            <p>
                <label>Imie i Nazwisko:</label>
                <input class="ainput" id="dane" type="text" name="dane" placeholder="Imie i Nazwisko" />
            </p>

            <p>
                <label>Adres:</label>
                <input class="ainput" id="adres" type="text" name="adres" placeholder="Adres" />
            </p>

            <p>
                <label>Miasto:</label>
                <input class="ainput" id="miasto" type="text" name="miasto" placeholder="Miasto" />
            </p>

            <p>
                <label>Stanowisko:</label>
                <input class="ainput" id="stanowisko" type="text" name="stanowisko" placeholder="Stanowisko" />
            </p>

            <p>
                <label>Data rozpoczecia pracy:</label>
                <input class="ainput" id="data" type="text" name="data" placeholder="Rok/Miesiac/Dzien" />
            </p>

            <p>
                <label>Telefon:</label>
                <input class="ainput" id="nrtel" type="text" name="nrtel" placeholder="Nr Tel" />
            </p>

            <p>
                <label>Pensja</label>
                <input class="ainput" id="kasa" type="text" name="kasa" placeholder="Ilosc przychodow" />
            </p>

            <input name="dodaj" type="submit" value="Dodaj" />
            <?php
            if (isset($_POST['dodaj'])) {
                $mysqli = new mysqli("localhost", "root", "", "pracownicy");

                $dane = $_POST['dane'];
                $adres = $_POST['adres'];
                $miasto = $_POST['miasto'];
                $stanowisko = $_POST['stanowisko'];
                $data = $_POST['data'];
                $tel = $_POST['nrtel'];
                $pensja = $_POST['kasa'];

                $mysqli->query("INSERT INTO `pracownicy`(Imie_Nazwisko,Adres,Miasto,Stanowisko,Data_rozpoczecia,Telefon,Pensja) VALUES ('$dane','$adres','$miasto','$stanowisko','$data','$tel','$pensja')");
                if (!$mysqli) {
                    echo mysqli_error($mysqli);
                } else {
                    echo "Pomyslnie wprowadzono dane";
                }
            }
            ?>

        </form>
    </div>
</body>

</html>