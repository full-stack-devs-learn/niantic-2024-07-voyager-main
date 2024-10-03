// players player 1,2
const player1 = {
    name: 'Player One',
    value: 'X'
}
const player2 = {
    name: 'Player Two',
    value: 'O'
}

// current
let currentPlayer;

// if a button has been clicked
let scoreGrid = []
let clickedButtons = []

function checkForWinner()
{
    const playerOneScore = scoreGrid.filter(score => score.player === player1)
    const playerTwoScore = scoreGrid.filter(score => score.player === player2)

    // did player 1 win


    // did player 2 win
}

function setNextPlayer()
{
    currentPlayer = (currentPlayer === player1) ? player2 : player1
    
    document.getElementById('playerName').innerText = currentPlayer.name
}


function init()
{
    // initializing the application
    setNextPlayer()

    // add click handlers for each game button click
    const buttons = document.querySelectorAll('.game-button')
    buttons.forEach(button =>
    {
        button.addEventListener('click', () =>
        {
            if (!clickedButtons.includes(button))
            {
                button.innerText = currentPlayer.value
                clickedButtons.push(button)
                const score = {
                    player: currentPlayer,
                    cell: button.id
                }
                scoreGrid.push(score)
                checkForWinner()

                setNextPlayer()
            }
        })  
    })

    const reset = document.getElementById('resetButton')
    reset.addEventListener('click', () =>
    {
        clickedButtons = []
        buttons.forEach(button => button.innerText = '')
        currentPlayer = null
        setNextPlayer()
    })
}

// main
document.addEventListener('DOMContentLoaded', () =>
{
    init()
})
