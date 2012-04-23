<?php
$hostname='webdb.uvm.edu';
$user='01cmorse_writer';
$pass='mXlxDZH7rivzq1Zy';
$dbase='01CMORSE_SORRYGAME';
$connection = mysql_connect("$hostname" , "$user" , "$pass") 
or die ("Can't connect to MySQL");
$db = mysql_select_db($dbase , $connection) or die ("Can't select database.");
?>
