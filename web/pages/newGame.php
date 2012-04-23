<?php
include('functions.php');
include('connect.php');

auth();
    $query = '
	SELECT *
	FROM player WHERE username="'.$_SESSION["SESS_USERNAME"].'"';

$result= mysql_query("$query") or die("Error: " . mysql_error());
while($row = mysql_fetch_array($result))
  {

	$username = $row["username"];
        $savedData = $row["savedData"];	
  }
?>
<?php include("template_header.php"); ?>
<div class="content">
    <div class="formLayout">
    <form action="sorry.php" method="post">
    <?php 
    if($savedData != 0) {
        echo'<h4>You have a saved game!</h4><label for="savedGame">Load Saved Game:</label>
        <input type="checkbox" name="savedGame">
        <input type="hidden" name="savedData" value="'.$savedData.'"/>
        </input><br/>';
        
    }
    ?>
        <label for="difficulty">Difficulty:</label>
        <select name="difficulty">
            <option value="easy">Easy</option>
            <option value="hard">Hard</option>
        </select><br/>
        <label for="color">Color:</label>
        <select name="color">
            <option value="red">Red</option>
            <option value="blue">Blue</option>
            <option value="yellow">Yellow</option>
            <option value="green">Green</option>

        </select><br/>
        <input type="hidden" name="username" value="<?php echo $username?>">
    <input type="submit" name="submitted" value="Start Game"/>
    </form>
    </div>
    
</div>
<?php include("template_footer.php"); ?>
