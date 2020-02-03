# CampaignsApp

Android App using Campaigns API

## Description

a simple app that contains some basic functionality. It connects to the Campaigns DB API and fetch current campaigns on there.


## Technologies
- [Dagger 2](https://www.google.com "Google's Homepage")
- Retrofit 2 - OkHttp3
- Glide
- RxJava 2
- LiveData
- Data Binding

## Overview of app arch.
- Follow the rules from Architecture guidelines recommended by Google.
- Keep Activity only responsible for UI related code 
- ViewModel provides pure data required by the UI class
- Repository layer provides data to ViewModel classes.
- ViewStates are responsible for reporting changes to the UI.
