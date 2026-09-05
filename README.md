# Sudoku Solver

A command-line Sudoku solver written in Java. It reads a 9×9 puzzle, checks
whether it's valid and how many solutions it has, then solves it using a
backtracking algorithm — and reports how long it took to solve.

## Features

- **Solves any valid 9×9 Sudoku** using recursive backtracking.
- **Input validation** — rejects starting boards that already break the rules
  (a repeated digit in a row, column, or 3×3 box).
- **Solution counting** — reports whether a puzzle has no solution, exactly one
  (a proper puzzle), or multiple solutions, stopping early once it finds a second.
- **Timing** — measures and prints how long the solve takes, in milliseconds.
- **Custom puzzles** — enter your own puzzle as 9 rows of 9 digits (0 = empty)

## How to run

1. Compile and run `SudokuSolver.java` (Java 25).
2. When prompted, enter the puzzle as 9 lines of 9 digits, using `0` for empty cells:
   530070000
   600195000
   098000060
   800060003
   400803001
   700020006
   060000280
   000419005
   000080079
3. The program prints the puzzle, diagnoses it and then prints the solved grid and solve time.

## How it works
The solver uses **backtracking**, a form of intelligent trial-and-error:
1. Find the next empty cell.
2. Try digits 1–9 in it, skipping any that break Sudoku's row, column, or box rules.
3. Place a legal digit and recursively try to solve the rest of the board.
4. If that leads to a dead end, undo the guess and try the next digit.

Because each guess is undone when it fails, the algorithm automatically explores
every possibility until it either fills the board (solved) or exhausts all options
(no solution).

The solution counter uses the same idea, but instead of stopping at the first
solution it keeps backtracking and tallies every complete board — capping the
count at 2, since distinguishing "unique" from "multiple" is all that's needed to
judge whether a puzzle is proper.

## What I learned

- Recursion and backtracking for constraint-satisfaction problems.
- Using integer division to map a cell to its 3×3 box (`(row / 3) * 3`).
- Reusing one validity check for both solving and input validation via a
  "remove, test, restore" trick.

## Author

Abhijot Singh