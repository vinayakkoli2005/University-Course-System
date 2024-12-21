University Course Registration System
---------------------------------------

-> Overview
This project implements a terminal-based University Course Registration System, developed as part of CSE201 Advanced Programming coursework. The system utilizes fundamental and advanced Object-Oriented Programming (OOP) concepts to manage student enrollments, schedules, academic records, and administrative tasks.

Functionalities Implemented
----------------------------

-> User Roles
- Students:
  - View available courses with details (code, title, professor, credits, prerequisites, timings).
  - Register for courses (with prerequisites and credit limits).
  - View weekly schedule.
  - Track academic progress (calculate SGPA/CGPA).
  - Drop courses.
  - Submit complaints and view complaint status.
  - Provide feedback (numeric ratings and textual comments) on completed courses.

- Professors:
  - Manage courses (update syllabus, timings, credits, prerequisites, etc.).
  - View enrolled students.
  - Access and review feedback provided by students.

- Teaching Assistants (TAs):
  - Assist professors by managing student grades.
  - Have limited privileges compared to professors.

- **Administrators:**
  - Manage course catalog (view, add, delete courses).
  - Manage student records (grades and personal details).
  - Assign professors to courses.
  - Handle student complaints.

-> Advanced Features
1. Generic Feedback System:
   - Feedback managed using a generic class.
   - Includes numeric ratings and textual comments.

2. Enhanced User Role Management:
   - Introduced Teaching Assistant (TA) role using inheritance, extending the Student class.

3. Robust Exception Handling:
   - Invalid Course Registration: Throws `CourseFullException` if a course is full.
   - Invalid Login: Throws `InvalidLoginException` for incorrect login attempts.
   - Course Drop Failures: Throws `DropDeadlinePassedException` if a course drop is attempted past the deadline.
   - Custom exception classes created for each scenario and handled using try-catch blocks.

-> Technologies Used
- Programming Language: Java
- Concepts Applied:
  - OOP: Classes, Inheritance, Interfaces, Encapsulation, Polymorphism, Abstraction.
  - Advanced OOP: Generics, Exception Handling, Role-based Interfaces.

-> Credits
- Developed by: Vinayak Koli
- Course: CSE201 Advanced Programming
- Institution: IIITD
