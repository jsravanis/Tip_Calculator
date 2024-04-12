# Tip Calculator Android App

## Overview
This Android application allows users to calculate tips based on different percentages and custom amounts. It provides functionalities like selecting tip percentage, calculating tips, resetting the form, and viewing bill summaries.

## Requirements
1. **Selecting Tip Percentage:**
    - Clicking the “Select” button launches the Select Tip Activity for Result.
    - Upon receiving the selected tip percentage, it should be displayed.

2. **Calculating Tips:**
    - Clicking the “Calculate” button checks if bill amount is missing and shows a Toast message if required.
    - If no tip percentage has been selected, it shows a Toast message indicating the error.
    - If bill amount and tip percentage are entered correctly, it creates a Bill object and starts the Bill Summary Activity, passing the Bill object.

3. **Resetting the Form:**
    - Clicking the “Reset” button clears the form and brings it back to the initial state.

4. **Using RadioGroup and SeekBar:**
    - RadioGroup containing RadioButtons enables users to pick from predefined tip options or choose "Custom" for a custom tip percentage.
    - SeekBar allows users to pick a custom tip value, with the maximum set to 50%. It initializes with a default value of 25%.
    - A TextView displays the current progress of the SeekBar.

5. **Submitting and Cancelling:**
    - Clicking “Submit” sends back the selected tip to the Tip Calculator Activity and finishes the current activity.
    - Clicking “Cancel” simply finishes the current activity.

6. **Bill Summary Activity:**
    - Expects to receive a Bill object containing the bill amount and the tip percentage.
    - Calculates the tip and total bill and displays the results.

## Screenshots
![Screenshot 1](screenshots/screenshot1.jpeg)    ![Screenshot 2](screenshots/screenshot2.jpeg)    ![Screenshot 3](screenshots/screenshot3.jpeg)    ![Screenshot ](screenshots/screenshot4.jpeg)

## Dependencies

- No external dependencies required.

## Installation

- Clone the repository.
- Open the project in Android Studio.
- Build and run the project on an Android device or emulator.

## Author

Jaya Sravani Sirigineedi

## Acknowledgments

- This app was created as part of Mobile Application Development course at UNCC.
