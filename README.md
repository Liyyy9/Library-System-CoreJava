# Library Management System
<br />

## About the Project

The Library Management System is a Java-based application that enables efficient management of members and staff within a library. This program demonstrates the core principles of **object-oriented programming (OOP)**, specifically emphasizing **inheritance** and modular design.
<br />
<br />

## Project Motivation

I wanted to practice what I've learnt in **MOOC Fi University of Helsinki** online Java course where they taught about ```inheritance and polymorphism```. I want to create a project of my own to practice this concept.
<br />

## Features

- **Member Management**

  - Add, edit, search, and delete members.

  - Retrieve member details by name or email.

- **Staff Management**

  - Add, edit, search, and delete staff members.

  - Includes an additional field for staff roles.

- **Inheritance**

  - The ```Staff``` class extends the ```Members``` class, inheriting its properties and methods while adding staff-specific functionality (e.g., roles).

- **User Interface**

  - Console-based interface for interaction with the system.

- **Scalable Design**

  - Separation of concerns across multiple classes for better maintainability.

  - Easy to extend functionality in the future.
<br />

## Tech Stack

- **Programming Language**: Core Java

- **Data Structures**: HashMap, ArrayList
<br />

## Class Structure

-  ```Members```

    - Handles general member functionality, including storing and managing member data using a ```HashMap```.

- ```Staff```

    - Extends ```Members``` to include role-specific functionality for staff members, utilizing a ```HashMap``` with ```ArrayList``` values to store email and role.

- ```MemberInterface```

  - Provides methods for user interaction and operations related to members.

- ```StaffInterface```

  - Provides methods for user interaction and operations related to staff.

- ```UserInterface```

  - Acts as the central hub for user input, directing actions to the appropriate interfaces.
<br />

## Example Usage
```
=======================================================================

Member Options:
1. Sign up new member.
2. Edit existing member.
3. Find a member's details.
4. Member list.
5. Delete member.
6. Back to main menu.
7. Quit program.

Choose option: 1

Name: John Doe
Email: john.doe@example.com

New member successfully registered! Welcome John Doe!
=======================================================================

Staff Options:
1. Register new staff.
2. Edit existing staff.
3. Find a staff's details.
4. Search staffs under a certain Role.
5. Staff list.
6. Delete staff.
7. Back to main menu.
8. Quit program.

Choose option: 1

Name: Jane Smith
Email: jane.smith@example.com
Role: Librarian

New staff successfully registered! Welcome Jane Smith!
=======================================================================
```

## Future Features

I would like to expand the project with the following features:

- **Spring Boot Integration**

  - Rewriting the application using the Spring Boot framework for improved scalability and structure.

- **RESTful APIs**

  - Enabling interaction with the system via RESTful web services to allow integration with external systems or front-end applications.

- **Database Integration**

  - Connecting the application to a relational database (e.g., MySQL, PostgreSQL) to store and manage member and staff data persistently.

- **User Authentication**

  - Adding authentication and role-based access control to differentiate between regular members and staff users.

- **Input Validation**

  - Implementing Regex to ensure clean and correct data entry for names, emails, and roles.

- **Web-Based Interface**

  - Developing a user-friendly front-end web interface using HTML, CSS, and JavaScript for better usability.
