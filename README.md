Android Assessment
==================

# Description

In this assessment we would like you to complete a small Android app that displays shared cars in the Berlin area in the following manner:
The user inputs longitude and latitude (yes yes, manually), and when he presses a button the entered location is centered on the map. All the cars within a radius of 2 Km are shown on the map. 
The app is almost completed, we've marked the stubs which need to be implemented.

# Prerequisites

This is what we recommend:

* OpenJDK 1.7
* Eclipse with ADT (Android Development Tools)
* Android SDK
* git

Feel free to use tools of your choice, but keep in mind that we cannot provide any assistance for tools other than the listed above.

# Setup

1. git clone git@github.com:Android-assessment/android-assessment.git
2. Within eclipse: File > Import > Android > Existing Android Code Into Workspace 

# Tasks

1. Add the following UI elements:
 * Text input field with id and title: 'latitude'.
 * Text input field with id and title: 'longitude'.
 * A button with id and title: 'go'.

2. Implement the following method stubs:
 * getCars()
 * filterCarsByDistance()
 * updateLocation()

3. Wire the UI elements to the updateLocation() method.

4. Zip the code and a working apk and mail this to your HR contact.


Good Luck!
