# WeatherWear

Design Document

Jacob Hornung

## Introduction

WeatherWear is a custom weather app personally tailored for you and only you! WeatherWear tracks how you’re feeling in different temperatures and conditions based on the outfits you wear while simultaneously recommending outfits that fit your need for future forecasts.

- Monitor weather conditions in any city
- Create and receive tailored outfit recommendations based on the temperature and forecast
- Setup custom notifications to update you when there’s a change in weather that may affect your outfit choice


## Storyboard

[InVision Storyboard Prototype](https://projects.invisionapp.com/prototype/ckkjua9el002sx201666dlhfv/play)

[InVision Storyboard Artboards](https://projects.invisionapp.com/prototype/WeatherWear-Storyboard-ckkjua9el002sx201666dlhfv)

![Storyboard](https://user-images.githubusercontent.com/54491123/106366940-0c7a5300-630d-11eb-901b-662f8ac06478.png)

## Functional Requirements 

### Requirement 100.0 Search for Weather Conditions of a City

##### Scenario

As a user interested in a city’s weather forecast, I want to be able to search for a city of my choice so that I can view that city’s temperature and weather conditions.

##### Dependencies

City search data is available and accessible.

City weather data is available and accessible.

User’s device has GPS capabilities and has granted location access.


##### Assumptions

Searchable cities are specific to the United States.

City’s initial weather data retrieved is that of the user’s location.

Temperature is in the Fahrenheit scale


#### Examples

1.1

**Given** a city’s weather data is available

**When** I search for “Cleveland”

**Then** I should receive weather data with the results of:

        	City: Cleveland
        	Actual Temperature: 28°F
        	Feels Like: 22°F
        	Condition: Snowing
          
1.2

**Given** a city’s weather data is available

**When** I search for “_____”

**Then** I should receive my current location’s weather with results of:

        	City: Cincinnati (Current Location)
        	Actual: 39°F
        	Feels Like: 36°F
        	Condition: Raining

1.3

**Given** a city’s weather data is available

**When** I search for “wasdqwerty”

**Then** I should receive my current location’s weather with results of:

        	Warning: ‘Selected City Not Found – Setting to Current Location’
        	City: Cincinnati (Current Location)
        	Actual: 39°F
        	Feels Like: 36°F
        	Condition: Raining
          
## Class Diagram

### Class Diagram Description

**MainActivity:**

## Scrum Roles

- 
- 
- 

## Weekly Meeting

TBD
