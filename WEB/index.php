<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menager Pracowniczy</title>
    <link rel="stylesheet" type="text/css" href="kolorki.css" />
    <ul>
        <li><a href="Dodaj.php">Dodaj pracownika</a></li>
        <li><a href="Usun.php">Usun pracownika</a></li>
        <li><a href="wyszukaj.php">Wyszukaj pracownika</a></li>
    </ul>
    </nav>
</head>

<?php
$username = "root";
$password = "";
$database = "pracownicy";
$mysqli = new mysqli("localhost", $username, $password, $database);
$query = "SELECT * FROM pracownicy";


echo '<table id="tabela"> 
      <tr class="trcol"> 
          <th class="tablecol"> <font face="Arial">Imie i Nazwisko</font> </th> 
          <th class="tablecol"> <font face="Arial">Adres</font> </th> 
          <th class="tablecol"> <font face="Arial">Miasto</font> </th> 
          <th class="tablecol"> <font face="Arial">Stanowisko</font> </th> 
          <th class="tablecol"> <font face="Arial">Data rozpoczecia pracy</font> </th>
          <th class="tablecol"> <font face="Arial">Telefon</font> </th>
          <th class="tablecol"> <font face="Arial">Pensja</font> </th>
      </tr>';

if ($result = $mysqli->query($query)) {
    while ($row = $result->fetch_assoc()) {
        $field1name = $row["Imie_Nazwisko"];
        $field2name = $row["Adres"];
        $field3name = $row["Miasto"];
        $field4name = $row["Stanowisko"];
        $field5name = $row["Data_rozpoczecia"];
        $field6name = $row["Telefon"];
        $field7name = $row["Pensja"];

        echo '<tr class="trcol"> 
                  <td class="tdcol">' . $field1name . '</td> 
                  <td class="tdcol">' . $field2name . '</td> 
                  <td class="tdcol">' . $field3name . '</td> 
                  <td class="tdcol">' . $field4name . '</td> 
                  <td class="tdcol">' . $field5name . '</td> 
                  <td class="tdcol">' . $field6name . '</td>
                  <td class="tdcol">' . $field7name . '</td>
              </tr>';
    }
    $result->free();
}
?>
</body>

</html>