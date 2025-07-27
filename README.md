# ERTS

## OBJECTIVES

To design and develop an Event Registration & Ticketing System (ERTS) that enables multi-role access for Admins, Organizers, and Attendees. The system must support event creation, registration, ticketing, reporting, and secure communication, applying Java Swing UI, MVC architecture, MySQL integration, and security best practices.
OVERVIEW

### User Roles & Core Capabilities

The system will support three user roles:

    Admin: Manage users, approve/reject event proposals, view platform statistics

    Organizer: Propose/create/manage events, view and manage registrations, send email updates

    Attendee: Register for events, download/view ticket (with QR code), cancel registration, contact organizers

## IMPLEMENTATION REQUIREMENTS

The following requirements must be strictly followed.
1. System Architecture

    MVC Pattern

    Java Swing for GUI

    MySQL for persistent storage

2. User Authentication & Access Control

    Secure login screen
    Password hashing and validation

    Prepared Statements for all SQL interactions (prevent SQL injection)

### CORE SYSTEM FEATURES
A. Authentication

    User registration

    Secure login screen

    Role-based dashboard routing

    First-login password reset flow for organizers

B. Admin Panel

    View all users and their roles

    Approve or reject pending event proposals

    Manage event categories

    Deactivate or delete accounts

C. Organizer Panel

    Create new events with:

        Event name, description, category, capacity, date/time, location, price

        Upload image/poster (JPG/PNG, max 5MB)

    View and edit owned events

    Email all registered attendees (you may simulate without actually sending out emails)

    Cancel an event (sends notification to attendees)

D. Attendee Panel

    Browse/search upcoming events (by name, type, date)

    View event details with image

    Register for available events

    Download a ticket (with QR code)

    Cancel registration (confirmation required)

    Contact event organizers via email (you may simulate without actually sending out emails)

### ADVANCED FEATURES

    Field Validations: Email, numeric inputs, file size/type, required fields
    QR Code Ticketing: Generate QR-coded ticket PDF or PNG with event and user details (using an external library like ZXing)
    Search and Filter System: Allow filtering events by date, type, and keyword
    User profile picture: Allow users to upload their profile pictures
    Statistics Dashboard: Real-time data for Admin (events by category, most attended, etc.)
    Data Export (CSV): Export registrations per event

## SREENSHOTS

### ADMIN DASHBOARD

<img width="975" height="549" alt="image" src="https://github.com/user-attachments/assets/2e720a32-6bb2-4ff4-86f4-74acf6346e57" />

<img width="975" height="548" alt="image" src="https://github.com/user-attachments/assets/4ccd01c7-014c-4031-8303-3856641981be" />


### ORGANIZER DASHBOARD
<img width="975" height="548" alt="image" src="https://github.com/user-attachments/assets/4aaa302e-5921-4440-b328-f5d8c5df27a0" />

### ATTENDEE DASHBOARD
<img width="975" height="548" alt="image" src="https://github.com/user-attachments/assets/e2d34d68-d672-4dac-8a8e-6e8433ae6c30" />


