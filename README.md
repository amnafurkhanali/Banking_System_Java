# Banking System — Java (Console)

A console-based banking management system built in Java for **SWE 201 – Structured Programming**, using arrays for data storage and structured, menu-driven program flow.

## Features

- **Sign up** for a new customer account
- **Customer login** with account access
- **Admin login** with elevated privileges
- **View balance**
- **Deposit** and **withdraw** funds
- **Transfer** funds between accounts
- **Delete own account**
- Input validation and clear console-based menus throughout

## Tech Stack

- **Java** (core, no external libraries) — uses parallel arrays (`names`, `balances`, `accountNumbers`, etc.) to model customer data and structured control flow (loops, switch-case menus) to drive the program.

## Project Structure

```
BankingSystem.java   # Single-file application: main menu, admin flow,
                      # customer flow, and all account operations
```

## Setup

```bash
javac BankingSystem.java
java GroupProject.BankingSystem
```
*(Adjust the run command if you remove the `GroupProject` package declaration.)*

## Notes

- Built as an academic exercise focused on structured programming: arrays, loops, methods, and menu-driven design rather than OOP class modeling.
- Data is stored in memory only (no file or database persistence) — all accounts reset when the program exits.
