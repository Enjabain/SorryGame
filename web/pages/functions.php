<?php function auth() {

	session_start();
	
	if(!isset($_SESSION['SESS_USERNAME']) || (trim($_SESSION['SESS_USERNAME']) == '')) {
		header("location: login.php");
		exit();
	}
}
?>