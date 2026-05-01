# Nexus University Management System

A complete University Management System featuring both a robust Java application backend (from earlier assignments) and a modern, stunning, and responsive Web Application built using pure HTML, CSS, and Vanilla JavaScript with a **Supabase** database integration.

## 🌟 Features

* **Three-Tier User Roles**: Support for Students, Professors, and Administrators.
* **Modern Web UI**: A beautiful dark-mode glassmorphism design built from scratch without any heavy frameworks.
* **Serverless Architecture**: The frontend talks directly to the Supabase REST API—no middleman server required!
* **Student Portal**:
  * Browse available courses by semester.
  * Register for and drop courses.
  * View current enrollments and final grades.
  * Submit and track academic complaints.
* **Professor Portal**:
  * View assigned courses.
  * See a roster of enrolled students.
  * Assign and update final grades in real-time.
* **Administrator Portal**:
  * Full control over course catalog (add/delete courses).
  * Resolve student complaints and provide resolution feedback.

---

## 🛠️ Technology Stack

1. **Frontend**: HTML5, Vanilla CSS (Glassmorphism & Flexbox/Grid), Vanilla JavaScript
2. **Database**: [Supabase](https://supabase.com/) (PostgreSQL) interacting via REST API
3. **Backend/Legacy Code**: Java

---

## 🚀 Getting Started

You do **not** need a local server or Node.js environment to run the web application. It relies entirely on standard browser APIs (`fetch`).

### 1. Database Setup (Supabase)
1. Create a free project on [Supabase](https://supabase.com/).
2. Open the **SQL Editor** in your Supabase dashboard.
3. Copy the contents of the `schema.sql` file provided in this repository and run it. 
   *(Note: This creates the necessary tables, inserts demo data, and deliberately disables Row Level Security (RLS) to allow our serverless frontend to interact with it seamlessly).*
4. When prompted by Supabase about destructive operations, click **"Run without RLS"**.

### 2. Connect the Web App
1. Get your **Project URL** and **Anon Public Key** from your Supabase Project Settings -> API.
2. Open `index.html` in your favorite code editor.
3. Locate the configuration constants near line 470:
   ```javascript
   const SUPA_URL = 'https://your-project.supabase.co';
   const SUPA_KEY = 'your-anon-key';
   ```
4. Replace them with your actual Supabase credentials.

### 3. Run the App
Simply double-click the `index.html` file to open it in your browser. Alternatively, you can drag and drop the entire folder into [Netlify Drop](https://app.netlify.com/drop) to host it instantly for free!

---

## 🔑 Demo Credentials

After running `schema.sql`, the following default Administrator account is created:
* **Email:** `admin@uni.edu`
* **Password:** `admin123`

To test the **Professor** role:
1. Ensure the Admin has assigned a course to a specific professor name (e.g., `Dr. Smith`).
2. On the main login page, click "Sign up".
3. Select **Account Type: Professor**.
4. Enter `Dr. Smith` as your full name. You will immediately see the courses assigned to you!

To test the **Student** role:
1. On the login page, click "Sign up".
2. Select **Account Type: Student**.
3. Create your account and begin enrolling in courses!

---

## 📁 Repository Structure

* `index.html`: The complete single-page web application.
* `schema.sql`: The database schema definition and seeding script for Supabase.
* `src/`: Contains the original Java source code classes for the legacy backend implementation.

## 📝 License
This project was built for educational purposes. Feel free to use and modify it!
