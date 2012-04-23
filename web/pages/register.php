<?php
include("connect.php");

$username="";
$password="";
$cpassword="";

if (isset($_POST["submitted"])){
    $username = $_POST["username"];
    $password = $_POST["password"];
    $cpassword = $_POST["cpassword"];
    $today = date( 'Y-m-d H:i:s' );

    
    $username = htmlentities($username, ENT_QUOTES);
    $password = htmlentities($password, ENT_QUOTES);
    $cpassword = htmlentities($cpassword, ENT_QUOTES);

    include ("functions.php");
    $errorMsg=array();
    
    if($username==""){
        $errorMsg[]="Please enter your desired Username";
    } 
    else {
	$qry = "SELECT * FROM player WHERE username='$username'";
	$result = mysql_query($qry);
	if($result) {
		if(mysql_num_rows($result) > 0) {
			$errorMsg[] = 'Username already in use.';
		}
		@mysql_free_result($result);
	}
	else {
		die("Query failed");
	}
    }


	if($password == "") {
		$errorMsg[] = "Please enter a Password";
	}
	if($cpassword == "") {
		$errorMsg[] = "Please Confirm Password";
	}
	if( strcmp($password, $cpassword) != 0 ) {
		$errorMsg[] = "Passwords do not match.";
	}
        
    if($errorMsg){
        echo "<ul>\n";
        foreach($errorMsg as $err){
            echo "<li style='color: red'>" . $err . "</li>\n";
        }
        echo "</ul>\n";
    } else { 

	$sql1 = "INSERT INTO player(username, password, dateJoined) 
	VALUES ('$username','".md5($_POST['password'])."','$today')
";

	$result1= mysql_query("$sql1") or die("Error: " . mysql_error());
	if ($result1) {
            header("location: index.php");
        }
    }
}
include("template_header.php");
?>

<div class="content">
		<p>All fields are required.</p>
		<div class="formLayout">
		<form action="<?php print $_SERVER['PHP_SELF']; ?>" method="post">
            		<label for="username">Username: </label>
			<input type="text" name="username" id="username"/><br/>
            		<label for="password">Password: </label>
			<input type="password" name="password" id="password"/><br/>
            		<label for="cpassword">Confirm: </label>
			<input type="password" name="cpassword" id="cpassword"/><br/>
			<input type="submit" name="submitted" value="Submit"/>
		</form>
		</div>
</div>
<?php include("template_footer.php")?>


