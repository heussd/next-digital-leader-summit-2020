# NEXT DIGITAL LEADER SUMMIT 2020

# Get started
1. You will have to code in this session. We have prepared a running development environment on gitpod.io. Please click on the button to start you own instance.
[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/heussd/next-digital-leader-summit-2020)

1. Make yourself familiar with the Editor (It is very similiar to VS Code)

1. Do you find the file of the Sudoku Board implementation?

1. Open HTML test report [./build/reports/tests/test/index.html](./build/reports/tests/test/index.html)

1. What is the output of the Unit Test?

# First Task

1. Switch to Branch Taks_1 or open a new instance GITPODLINK

2. We have prepared a Sudoku Board for you and your taks is to fill the board with the number 8. For this you have to create a new Constraint Rule in the file sudokuConstraints.drl. You can test your code with the command gradle -t test.

# Second Task

1. Switch to Branch Taks_2 or open a new instance GITPODLINK

2. In this task you will implement two new Constraint Rules. 
One to check that each row in the Sudoku Board is valid, 
that means all numbers 1 - 9 are present, and the second rule is to check each column in the Sudoku Board.
(You will only need to edit sudokuConstraints.drl, but also have a look at Cell.kt)

# Third Task

1. Switch to Branch Taks_3 or open a new instance GITPODLINK

2. To get a valid Sudoku one rule is missing, you will implent this rule now. A Sudoku Board has nine 3x3 regions. In each reagion all numbers from 1-9 must be present.
(You will need to edit sudokuConstraints.drl, but also can edit Cell.kt)
