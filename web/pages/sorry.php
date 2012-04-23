<?php
include('functions.php');
auth();

if (isset($_POST['submitted'])) {
$username = $_POST['username'];
$color = $_POST['color'];
$difficulty = $_POST['difficulty'];
    
}    
else header("location: newGame.php");
?>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

<title>Sorry! Board Game</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<link rel="stylesheet" href="sorry.css" type="text/css" media="screen"/>

<script>

window.n = 0;
window.index1 = -1;
window.index2 = -1;


function newGame() {
    var started = document.getElementById('sorryApplet').startGame(<?php echo '"'.$username.'", "'.$color.'", "'.$difficulty.'"'?>);
document.getElementById('cover').style.display = 'none';
document.getElementById('newGame').style.display = 'none';
    setCurrentPlayer('<?php echo $username?>');
    setStatus('Draw a Card to Continue.');
}
function setStatus(status) {
    document.getElementById('status').innerHTML =  status;

}
function setCurrentPlayer(player) {
    window.currentPlayer = player;
    document.getElementById('currentPlayer').innerHTML = 'Current Player: ' + player;

}

function graphIt() {
    var grid = initBoard(16, 16, function (el, row, col, i) {

        if (window.index1 != -1 && window.index2 != -1) {
            window.n = 0;
	    document.getElementById(index1).setAttribute('style','border: 1px solid transparent;');
	    document.getElementById(index2).setAttribute('style','border: 1px solid transparent;');
            window.index1 = -1;
            window.index2 = -1;

        }

        if (window.n == 0) {
            window.index1 = i;
            ++window.n;
	    document.getElementById(index1).setAttribute('style','border: 1px solid gold;');
        } else if (window.n == 1) {
            window.index2 = i;
            ++window.n;
	    document.getElementById(index2).setAttribute('style','border: 1px solid gold;');
        }
        var feedbackdisplay = document.getElementById('feedbackdebug');
        feedbackdisplay.innerHTML = index1 + ' ' + index2;


        if (document.getElementById(index1).hasChildNodes() && index2 != -1) {
	    document.getElementById(index1).setAttribute('style','border: 1px solid transparent;');
	    document.getElementById(index2).setAttribute('style','border: 1px solid transparent;');
            validateMove(index1, index2);


        }

        if (!document.getElementById(index1).hasChildNodes()) {
            window.n = 0;
	    document.getElementById(index1).setAttribute('style','border: 1px solid transparent;');
            window.index1 = -1;
            window.index2 = -1;

        }

    });

    var board = document.getElementById('board');
    board.appendChild(grid);
}

function validateMove(index1, index2) {
    var pieceID = document.getElementById(index1).firstChild.getAttribute("id");
    var valid = (document.getElementById('sorryApplet')).validateMove(pieceID, index1, index2);
}

function movePiece(index1, index2) {
    var piece = document.getElementById(index1);
    var moveTo = document.getElementById(index2);
    moveTo.insertBefore(piece, moveTo.firstChild);
}

function bumpPiece(index1, index2) {
    var piece1 = document.getElementById(index1).firstChild;
    bumper(index2);
    var moveTo = document.getElementById(index2);
    moveTo.insertBefore(piece1, moveTo.firstChild);
}
function swapPiece(index1, index2) {
    var piece1 = document.getElementById(index1).firstChild;
    var moveFrom = document.getElementById(index1);
    var moveTo = document.getElementById(index2);
    if (moveTo.firstChild) {
        var piece2 = document.getElementById(index2).firstChild;
        moveTo.insertBefore(piece1, moveTo.firstChild);
        moveFrom.insertBefore(piece2, moveFrom.firstChild);
    }
}
function slidePiece4(index1, index2) {
    var piece1 = document.getElementById(index1).firstChild;
    bumper(index2);
    bumper(index2 + 1);
    bumper(index2 + 2);
    bumper(index2 + 3);
    var moveTo = document.getElementById(index2 + 3);
    moveTo.insertBefore(piece1, moveTo.firstChild);


}
function slidePiece5(index1, index2) {
    var piece1 = document.getElementById(index1).firstChild;
    bumper(index2);
    index2++;
    bumper(index2);
    index2++;
    bumper(index2);
    index2++;
    bumper(index2);
    index2++;
    bumper(index2);
    var moveTo = document.getElementById(index2);
    moveTo.insertBefore(piece1, moveTo.firstChild);
}
function bumper(bump) {
    var bumped = document.getElementById(bump);
    if (bumped.firstChild) {
        var piece2 = document.getElementById(bump).firstChild;
        var piece2ID = piece2.getAttribute("id");
        if (piece2ID.indexOf("r") != -1) {
            var start = document.getElementById("rstart");
        } else if (piece2ID.indexOf("b") != -1) {
            start = document.getElementById("bstart");
        } else if (piece2ID.indexOf("y") != -1) {
            start = document.getElementById("ystart");
        } else if (piece2ID.indexOf("g") != -1) {
            start = document.getElementById("gstart");
        }
        start.insertBefore(piece2, start.firstChild);
    }
}


function drawCard() {
    var discardpile = document.getElementById('discard');
    var card = document.getElementById('sorryApplet').drawCard();
    if (card == 1) {
        discardpile.innerHTML = '<div id="description">Must either start a man out or move one man forward 1 square.</div>' + card
    } else if (card == 2) {
        discardpile.innerHTML = '<div id="description">Must either start a man out or move one man forward 2 squares. DRAW AGAIN</div>' + card
    } else if (card == 3) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 3 squares.</div>' + card
    } else if (card == 4) {
        discardpile.innerHTML = '<div id="description">Must move one man backward 4 squares.</div>' + card
    } else if (card == 5) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 5 squares.</div>' + card
    } else if (card == 7) {
        discardpile.innerHTML = '<div id="description">Must either move one man forward 7 squares or split the move between any two men.</div>' + card
    } else if (card == 8) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 8 squares.</div>' + card
    } else if (card == 10) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 8 squares.</div>' + card
    } else if (card == 11) {
        discardpile.innerHTML = '<div id="description">Move one man forward 11 squares or any one of your men may change places with any one opponent. Note: Forfeit move if you do not wish to change places and it is impossible to go forward 11 squares.</div>' + card
    } else if (card == 12) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 12 squares.</div>' + card
    } else if (card == 0) {
        discardpile.innerHTML = '<div id="description">Must take one man from your start, place it on any square that is occupied by any opponent, and return that opponents man to its start. If there is no man on your start or no opponents man is on any square your move is forfeited.</div>' + "Sorry"
    }
}

function changeCard(card) {
    var discardpile = document.getElementById('discard');
    if (card == 1) {
        discardpile.innerHTML = '<div id="description">Must either start a man out or move one man forward 1 square.</div>' + card
    } else if (card == 2) {
        discardpile.innerHTML = '<div id="description">Must either start a man out or move one man forward 2 squares. DRAW AGAIN</div>' + card
    } else if (card == 3) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 3 squares.</div>' + card
    } else if (card == 4) {
        discardpile.innerHTML = '<div id="description">Must move one man backward 4 squares.</div>' + card
    } else if (card == 5) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 5 squares.</div>' + card
    } else if (card == 7) {
        discardpile.innerHTML = '<div id="description">Must either move one man forward 7 squares or split the move between any two men.</div>' + card
    } else if (card == 8) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 8 squares.</div>' + card
    } else if (card == 10) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 8 squares.</div>' + card
    } else if (card == 11) {
        discardpile.innerHTML = '<div id="description">Move one man forward 11 squares or any one of your men may change places with any one opponent. Note: Forfeit move if you do not wish to change places and it is impossible to go forward 11 squares.</div>' + card
    } else if (card == 12) {
        discardpile.innerHTML = '<div id="description">Must move one man forward 12 squares.</div>' + card
    } else if (card == 0) {
        discardpile.innerHTML = '<div id="description">Must take one man from your start, place it on any square that is occupied by any opponent, and return that opponents man to its start. If there is no man on your start or no opponents man is on any square your move is forfeited.</div>' + "Sorry"
    }
}

function initBoard(rows, cols, callback) {
    var ileft = 59;
    var iright = 16;
    var itop = 0;
    var ibottom = 45;
    var ired = 70;
    var iblue = 76;
    var igreen = 60;
    var iyellow = 78;
    var grid = document.createElement('table');
    grid.className = 'grid';
    for (var r = 0; r < rows; ++r) {
        var tr = grid.appendChild(document.createElement('tr'));
        for (var c = 0; c < cols; ++c) {
            var cell = tr.appendChild(document.createElement('td'));

            if (r == 0) {
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", itop);
                cell.addEventListener('click', (function (el, r, c, itop) {
                    return function () {
                        callback(el, r, c, itop);
                    }
                })(cell, r, c, itop), false);
                ++itop;
            }
            if (c == 15 && r != 0) {
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", iright);
                cell.addEventListener('click', (function (el, r, c, iright) {
                    return function () {
                        callback(el, r, c, iright);
                    }
                })(cell, r, c, iright), false);
                ++iright;
            }
            if (r == 15 && c != 15) {
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", ibottom);
                cell.addEventListener('click', (function (el, r, c, ibottom) {
                    return function () {
                        callback(el, r, c, ibottom);
                    }
                })(cell, r, c, ibottom), false);
                --ibottom;
            }
            if (c == 0 && r != 15 && r != 0) {
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", ileft);
                cell.addEventListener('click', (function (el, r, c, ileft) {
                    return function () {
                        callback(el, r, c, ileft);
                    }
                })(cell, r, c, ileft), false);
                --ileft;
            }

            if (c == 2 && r >= 1 && r <= 5) {
                var index = "" + igreen;
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", index);
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
                ++igreen;
            }
            if (r == 2 && c >= 10 && c <= 14) {
                index = "" + ired;
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", index);
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
                --ired;
            }
            if (c == 13 && r >= 10 && r <= 14) {
                index = "" + iblue;
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", index);
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
                --iblue;
            }
            if (r == 13 && c >= 1 && c <= 5) {
                index = "" + iyellow;
                cell.setAttribute("class", 'space');
                cell.setAttribute("id", index);
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
                ++iyellow;
            }

            if (c == 14 && r == 4) {
                index = 'rstart';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('rstart');
                for (i = 0; i < 4; ++i) {
                    var piece = cell.appendChild(document.createElement('div'));
                    piece.setAttribute("class", 'red piece');
                    piece.setAttribute("id", 'r' + i);
                }
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
            } else if (c == 1 && r == 11) {
                index = 'ystart';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('ystart');
                for (i = 0; i < 4; ++i) {
                    piece = cell.appendChild(document.createElement('div'));
                    piece.setAttribute("class", 'yellow piece');
                    piece.setAttribute("id", 'y' + i);
                }
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
            } else if (c == 4 && r == 1) {
                index = 'gstart';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('gstart');
                for (i = 0; i < 4; ++i) {
                    piece = cell.appendChild(document.createElement('div'));
                    piece.setAttribute("class", 'green piece');
                    piece.setAttribute("id", 'g' + i);
                }
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
            } else if (c == 11 && r == 14) {
                index = 'bstart';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('bstart');
                for (var i = 0; i < 4; ++i) {
                    piece = cell.appendChild(document.createElement('div'));
                    piece.setAttribute("class", 'blue piece');
                    piece.setAttribute("id", 'b' + i);
                }
                cell.addEventListener('click', (function (el, r, c, index) {
                    return function () {
                        callback(el, r, c, index);
                    }
                })(cell, r, c, index), false);
            } else if (c == 13 && r == 9) {
                i = 'bluehome';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('bluehome');
                cell.addEventListener('click', (function (el, r, c, i) {
                    return function () {
                        callback(el, r, c, i);
                    }
                })(cell, r, c, i), false);
            } else if (c == 2 && r == 6) {
                i = 'greenhome';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('greenhome');
                cell.addEventListener('click', (function (el, r, c, i) {
                    return function () {
                        callback(el, r, c, i);
                    }
                })(cell, r, c, i), false);
            } else if (c == 6 && r == 13) {
                i = 'yellowhome';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('yellowhome');
                cell.addEventListener('click', (function (el, r, c, i) {
                    return function () {
                        callback(el, r, c, i);
                    }
                })(cell, r, c, i), false);
            } else if (c == 9 && r == 2) {
                i = 'redhome';
                cell.setAttribute("class", 'space');
                cell = document.getElementById('redhome');
                cell.addEventListener('click', (function (el, r, c, i) {
                    return function () {
                        callback(el, r, c, i);
                    }
                })(cell, r, c, i), false);
            }
            if (c == 15 && ((r >= 9 && r <= 13) || (r >= 1 && r <= 4))) {
                cell.setAttribute("class", 'space');
            }
            if (c == 0 && ((r >= 11 && r <= 14) || (r >= 2 && r <= 6))) {
                cell.setAttribute("class", 'space');
            }
            if (r == 15 && ((c >= 11 && c <= 14) || (c >= 2 && c <= 6))) {
                cell.setAttribute("class", 'space');
            }
            if (r == 0 && ((c >= 9 && c <= 13) || (c >= 1 && c <= 4))) {
                cell.setAttribute("class", 'space');
            }


        }
    }
    return grid;
}

</script>
       


</head>

<body onload="graphIt()">
<script src="http://www.java.com/js/deployJava.js"></script>
<script>
    var attributes = { id:'sorryApplet', code:'sorryGame.GameApplet', archive:'sorryGame.jar', width:1, height:1};
    var parameters = {fontSize:16, jnlp_href:'sorryGame-applet.jnlp', java_status_events: 'true'};
    var version = '1.6';
    deployJava.runApplet(attributes, parameters, version);
</script>

<div id="wrapper">
    <div id="board">
        <div id="cover"><button id="newGame" onclick="newGame()">Start Game</button>
        </div>
        <div class="starthome" id="gstart"></div>
        <div class="starthome" id="rstart"></div>
        <div class="starthome" id="bstart"></div>
        <div class="starthome" id="ystart"></div>
        <div class="starthome" id="greenhome"></div>
        <div class="starthome" id="redhome"></div>
        <div class="starthome" id="bluehome"></div>
        <div class="starthome" id="yellowhome"></div>
	<div id="middle">
        <div id="feedback">
            <div id="lastMove">Last Move:</div>
            <div id="currentPlayer">Current Player:</div>
            <div id="status">Draw a card to continue.</div>
            <div id="feedbackdebug"></div>
        </div>
        <div id="deck" onclick="drawCard()">
            <div style="margin-top:100px; margin-left:30px; -moz-transform:rotate(45deg);">Sorry!</div>
        </div>
        <div id="discard"></div>
	</div>
    </div>
</div>
</body>
</html>
