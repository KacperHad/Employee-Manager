<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usun pracownika z bazy danych</title>
    <link rel="stylesheet" type="text/css" href="kolorki.css" />
    <nav>
        <ul>
            <li><a href="index.php">Lista pracownikow</a></li>
            <li><a href="Dodaj.php">Dodaj pracownika</a></li>
            <li><a href="wyszukaj.php">Wyszukaj pracownika</a></li>
        </ul>
    </nav>
</head>

<body>
    <div class="formaa">
        <form method="POST">
            <p>
                <label>Podaj imię i nazwisko pracownika:</label>
                <input class="ainput" id="dane" type="text" name="dane" placeholder="Imie i Nazwisko" />
                <input name="usun" type="submit" value="usun" />
                <?php
                if (isset($_POST['usun'])) {
                    $mysqli = new mysqli("localhost", "root", "", "pracownicy");

                    $dane = $_POST['dane'];

                    $mysqli->query("DELETE FROM `pracownicy` where Imie_Nazwisko='$dane'");
                    if (!$mysqli) {
                        echo mysqli_error($mysqli);
                    } else {
                        echo '<label id="deletmsg">Pomyślnie usunięto pracownika</label>';
                    }
                }
                ?>

            </p>
        </form>
    </div>
</body>

</html>