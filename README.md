# JobVetau

*JobVetau – Connecting Employers and Job Seekers in Nepal*
JobVetau is a dedicated job portal system aimed at bridging the gap between employers and job seekers by offering a modern, user-friendly platform tailored for the Nepalese market. It supports job posting, job search, applications, profile management, and more, all in a single cohesive system.

## Table of Contents

* [Features](#features)
* [Screenshots / UI Prototype](#screenshots--ui-prototype)
* [Tech Stack](#tech-stack)
* [System Architecture](#system-architecture)
* [Setup Instructions](#setup-instructions)
* [Development Methodology](#development-methodology)
* [Project Artifacts](#project-artifacts)
* [Team Members and Roles](#team-members-and-roles)
* [License](#license)
* [Contact Info](#contact-info)

## Features

JobVetau includes the following key functionalities:

* **User Authentication:** Secure login/logout and user registration for job seekers and employers.
* **Profile Management:** Creation and editing of job seeker and company profiles (with options to delete accounts).
* **Job Listings & Search:** Employers can post new jobs; seekers can view, search (filter/sort), and save jobs.
* **Application Tracking:** Job seekers can apply for jobs and track their applications; employers can view applicants and accept or reject applications.
* **Admin Dashboard:** Administrators can view or delete any user or job listing and manage the entire system.
* **Company Ratings:** Users can rate companies after applying or interviewing, helping improve trust and feedback.

## Screenshots / UI Prototype

We created low-fidelity and high-fidelity UI mockups using Figma to illustrate key screens (login, registration, dashboards, etc.). The interactive prototypes and design files are available [on Figma](https://www.figma.com/design/LQlROyF7qvpajOGwaVkAUz/JobVetau?node-id=0-1&t=8RdoB4JSsUOsYrXs-1). *(Note: screenshots below are representative; see the Figma link for full designs.)*

## Tech Stack

JobVetau is built with:

* **Java (Swing):** Desktop GUI framework for the user interface.
* **MySQL:** Relational database for storing users, jobs, and applications (managed with MySQL Workbench).
* **Git & GitHub:** Version control and code repository.
* **Visual Studio Code:** Primary IDE for development.
* **Trello:** Agile task and sprint management tool.
* **Figma:** UI/UX design and prototyping tool.
* **Draw\.io:** Diagramming (ER diagrams, flowcharts).

## System Architecture

The system follows the **MVC (Model-View-Controller)** architecture for a clean separation of concerns:

* **Model:** Manages application data and business logic (e.g., job listings, user accounts).
* **View:** Presentation layer (Java Swing forms) responsible for displaying data to the user and capturing input.
* **Controller:** Intermediary that handles user input (button clicks, form submissions), updates the Model, and refreshes the View as needed.

This layered design makes the code modular and easier to maintain.

## Setup Instructions

To run JobVetau locally:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/anilkc01/JobVetau_GroupC_37B.git
   cd JobVetau_GroupC_37B
   ```
2. **Configure the Database:**

   * Install MySQL and create a database (e.g., `jobvetau_db`).
   * Use MySQL Workbench or the CLI to run any provided SQL scripts to set up the tables.
   * Update the database connection settings in the application (e.g., in a configuration file) with your MySQL credentials.
3. **Build & Run:**

   * Open the project in Visual Studio Code or your preferred Java IDE (ensure JDK 8+ is installed).
   * Compile the code and run the main class (e.g., `JobVetauMain.java`).
   * The Java Swing application window should launch, allowing users to register, log in, post jobs, and apply according to the features above.

## Development Methodology

We followed an **Agile Scrum** process for development:

* **Agile Approach:** Emphasized flexibility, user feedback, and iterative improvement.
* **Scrum Practices:** Organized work into weekly sprints. We held daily stand-up meetings, sprint planning, and sprint retrospectives.
* **Tools & Communication:** Tasks were managed on Trello, and all code was version-controlled with Git/GitHub. Regular team meetings (online and in person) kept everyone aligned. This methodology allowed us to adapt to change quickly and continuously refine the platform.

## Project Artifacts

Key project resources and links:

* **Trello Board:** [JobFinder Sprint Board](https://trello.com/b/mqcPpv0f/jobfinder) – used for task planning and tracking.
* **Figma Prototypes:** [JobVetau UI Designs](https://www.figma.com/design/LQlROyF7qvpajOGwaVkAUz/JobVetau) – all low/high-fidelity mockups (login, dashboards, forms).
* **Development Log:** [Google Sheets Task Log](https://docs.google.com/spreadsheets/d/1qVnMe574ludyJ1tVzQh_cmwCGJQ7vaqYEEzjJvo5ra4/edit) – records of tasks, time tracking, and sprint outcomes.
* **Source Code:** [GitHub Repository](https://github.com/anilkc01/JobVetau_GroupC_37B) – contains all code and commit history.

## Team Members and Roles

* **Tek Bahadur KC** – Team Leader; responsible for overall architecture and back-end (database) development.
* **Krijal Shrestha** – Developer
* **Adwitiya Bahadur Pandey** – Developer
* **Sampada Shahi Thakuri** – Developer
* **Pukar Bogati** –Developer

Each member collaborated across design, development, and testing to deliver the project successfully.

## License

*This project does not currently have an open-source license (to be determined).*

## Contact Info

For questions or collaboration, contact the team lead: **Tek Bahadur KC** (email: *[tek.bahadur@softwarica.com.np](mailto:tek.bahadur@softwarica.com.np)* or the Softwarica College helpdesk).
