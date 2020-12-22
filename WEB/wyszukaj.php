<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wyszukaj pracownika</title>
    <link rel="stylesheet" type="text/css" href="kolorki.css" />
    <nav>
        <ul>
            <li><a href="index.php">Lista pracowników</a></li>
            <li><a href="Usun.php">Usuń pracownika</a></li>
            <li><a href="Dodaj.php">Dodaj pracownika</a></li>
        </ul>
    </nav>
</head>

<body>
    <div class="formaa">
        <form action="" method="post">
            <label>Wyszukaj pracownika</label>
            </br>
            <input class="ainput" type="text" name="search" placeholder="Imie i Nazwisko">
            <input type="submit" name="submit" value="Search">
        </form>
    </div>
    <?php
    if (isset($_POST["search"])) {
        $search_value = $_POST["search"];
        $con = new mysqli("localhost", "root", "", "pracownicy");
        if ($con->connect_error) {
            echo 'Connection Faild: ' . $con->connect_error;
        } else {
            $sql = "select * from pracownicy where Imie_Nazwisko like '%$search_value%'";

            $res = $con->query($sql);

            while ($row = $res->fetch_assoc()) {
                echo '<div class="formaa">';
                echo '<label class="labelaa"> Imie i nazwisko: </label> ' . $row["Imie_Nazwisko"];
                echo '</br>';
                $dane = $row["Imie_Nazwisko"];
                echo '<label class="labelaa">Adres: </label>  ' . $row["Adres"];
                echo '</br>';
                echo '<label class="labelaa">Miasto: </label>  ' . $row["Miasto"];
                echo '</br>';
                echo '<label class="labelaa">Stanowisko: </label>' . $row["Stanowisko"];
                echo '</br>';
                echo '<label class="labelaa">Data rozpoczęcia pracy: </label> ' . $row["Data_rozpoczecia"];
                echo '</br>';
                echo '<label class="labelaa">Telefon: </label> ' . $row["Telefon"];
                echo '</br>';
                echo '<label class="labelaa">Pensja: </label> ' . $row["Pensja"];
                echo '</div>';
            }
        }
    }
    ?>
</body>

</html>