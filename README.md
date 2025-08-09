# Booking.com Automation Framework

![Booking Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnv3cboQb9Y_n9DhiasYKInc7ZFcDDkbdpCA&s.png)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction

**Booking.com Automation Framework is a web-based testing suite tailored for validating core functionalities of 
the Booking.com platform. It provides a realistic environment for QA professionals to practice both manual and automated testing across 
travel-related workflows, including hotel search, 
booking, and user account management.
## Features

Search & Filter Functionality

Automate hotel searches based on location, date, guest count, and preferences.

Validate filters like price range, star rating, amenities, and cancellation policies.

 User Authentication & Profile Management

Test login, registration, and password recovery flows.

Validate profile updates, saved preferences, and booking history.

Hotel Details & Booking Workflow

Automate hotel selection, room type validation, and booking confirmation.

Test dynamic pricing, availability, and cancellation options.

 Payment & Transaction Handling

Validate payment gateway integration, card details, and error handling.

Automate refund and cancellation scenarios.

 Responsive UI Testing

Ensure consistent behavior across desktop, tablet, and mobile views.

 Localization & Language Switching

Test multi-language support and currency conversions.

## Installation

To set up and test the Booking.com automation framework locally:


1. Clone the repository:

   
git clone https://github.com/your-username/booking-automation-framework


2. Navigate to the project directory: cdbooking-automation-framework
3. Install dependencies: npm install

4. Configure the application:

Update configuration files with necessary settings, such as database credentials and API endpoints.

5. Run the application: npm start

## Uasge

Navigating the Booking.com Platform

Log in with valid credentials or continue as a guest.

Search for hotels, apply filters, and proceed to booking.
 
 # Automating Tests:
Use frameworks like Selenium, Cypress, or Playwright to automate:

Hotel search and filter validation

Booking confirmation and cancellation

UI responsiveness across devices


## Examples
Here are some scenarios you can automate:

Search Functionality

Search for hotels in Cairo with check-in and check-out dates.

Apply filters and validate results.

Login Authentication

Test login with valid, invalid, and edge-case credentials.

 Booking Workflow

Automate hotel selection, room booking, and confirmation.

Validate booking summary and email confirmation.

 Payment Validation

Test payment with valid/invalid card details.

Automate refund and cancellation flows.

Responsive Design

Validate layout and functionality on mobile and tablet views.

## Contributing
We welcome contributions to enhance the Booking.com automation framework!

Fork the repository

Create a feature or bug-fix branch

Implement your changes

Submit a pull request for review
## License

This framework is licensed under the MIT License.

## Additional Test Scenarios

For more extensive test cases and automation exercises, refer to the curated test scenarios available for Booking.com workflows. These include:

 Advanced Search Filters

Validate combinations of filters such as free cancellation, breakfast included, and property type.

Test sorting by price, rating, and distance from city center.

 Date Boundary Testing

Automate edge cases like same-day check-in/check-out, leap year bookings, and invalid date ranges.

 Localization & Currency Conversion

Switch between languages and currencies to validate UI consistency and price accuracy.

 Email Confirmation & Notifications

Verify booking confirmation emails, reminders, and cancellation alerts.
 Booking Modifications

Automate scenarios for changing dates, room types, or guest count after booking.

Security & Access Control

Test session timeouts, unauthorized access to booking history, and password reset flows.

