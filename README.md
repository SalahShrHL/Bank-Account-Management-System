# Bank Account Management System

## Project Overview

The **Bank Account Management System** is a Java-based application designed to simulate the core operations of a bank. It allows users to manage clients and their bank accounts, supporting various account types, including checking accounts, PEL (Home Savings Plan), and LDD (Sustainable Development Accounts). The system enforces rules related to deposits, withdrawals, overdrafts, and savings interest rates.

## Features

- **Client Management**:  
  Each bank client is identified by their full name and can hold multiple accounts (one checking account and various savings accounts).

- **Account Types**:
  - **Checking Accounts**: Allow deposits, withdrawals, and can have an overdraft limit.
  - **PEL (Home Savings Plan)**: Earns 3% interest but withdrawals are blocked until the end of the plan.
  - **LDD (Sustainable Development Accounts)**: Earns 2% interest with the option to withdraw at any time.

- **Banking Operations**:  
  The system allows for typical banking operations such as deposits, withdrawals, transfers between accounts, and balance checks. Specific rules apply to each account type (e.g., overdraft fees for checking accounts, blocked withdrawals for PEL).

- **Error Handling**:  
  Illegal operations like negative withdrawals, withdrawals that exceed overdraft limits, or deposits with negative amounts are handled by the system with appropriate error messages.

## Key Classes

1. **Client Class**:
   - Attributes: Name, surname, address, birth date, and a list of accounts.
   - Methods: Includes methods to correctly format and manage client data, such as `toString()` and `equals()`.

2. **Account Classes**:
   - Implements different types of accounts such as checking accounts, PEL, and LDD.
   - Methods to manage deposits, withdrawals, and transfers while adhering to the specific rules for each account.

3. **Bank Class**:
   - Manages a list of clients and accounts.
   - Key operations include adding clients, opening new accounts, crediting/debiting accounts, and displaying account balances.

## Example Scenario
1. Create two clients: Ahmed and Mohamed.
2. For Ahmed:
  -Create a checking account with a -500 overdraft limit, deposit 1000 Dinars, withdraw 100, and attempt to withdraw 2000.
  -Create a PEL with 3% interest and deposit 200.
  -Create an LDD account and deposit 800.
3.Display the details of all clients and their accounts, and list accounts that are overdrawn.
