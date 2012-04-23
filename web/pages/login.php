<?php

if (isset($_POST["submitted"])){
	session_start();

	include('connect.php');
	
	$errorMsg = array();
	
	$username = htmlentities($_POST['username']);
	$password = htmlentities($_POST['password']);
	
	if($username == '') {
		$errorMsg[] = 'Username missing';
	}
	if($password == '') {
		$errorMsg[] = 'Password missing';
	}
	
    	if($errorMsg){
        	echo "<ul>\n";
        	foreach($errorMsg as $err){
            	echo "<li style='color: red'>" . $err . "</li>\n";
        }
        echo "</ul>\n";
    	} else { 
	
	$qry="SELECT * FROM player WHERE username='$username' AND password='".md5($_POST['password'])."'";
	$result=mysql_query($qry);
	
	if($result) {
		if(mysql_num_rows($result) == 1) {
			session_regenerate_id();
			$member = mysql_fetch_assoc($result);
			$_SESSION['SESS_USERNAME'] = $member['username'];
			session_write_close();
			header("location: newGame.php");
			exit();
		}else {
			echo "<span style='color:red;'>Login Failed</span>";
		}
	}else {
		die("Query failed");
	}
	}
}
?>
<?php include("template_header.php"); ?>
<div class="content">
<div class="formLayout">
<form id="loginForm" name="loginForm" method="post" action="<?php print $_SERVER['PHP_SELF']; ?>">
	<label for="username">Login:</label>
	<input name="username" type="text" class="textfield" id="username" /><br/>
	<label for="password">Password:</label>
      	<input name="password" type="password" class="textfield" id="password" /><br/>
	<input type="submit" name="submitted" value="Login" />
</form>
</div>
</div>
<?php include("template_footer.php"); ?>

